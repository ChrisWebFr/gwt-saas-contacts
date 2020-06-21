package com.logos.contacts.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.logos.contacts.client.SharedContactsServiceAsync;
import com.logos.contacts.shared.Contact;
import com.logos.contacts.shared.ContactLists;
import com.logos.contacts.shared.ContactsConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactsPresenter implements Presenter, ContactsConstants {

	private static final int FROM_CONTACT_TO_DISPLAY = 10;
	private static final int FROM_DISPLAY_TO_CONTACT = 20;

	private ArrayList<Contact> sharedContactDetails;
	private ArrayList<Contact> privateContactDetails;
	private Contact contact;
	private final SharedContactsServiceAsync rpcService;
	@SuppressWarnings("unused")
	private final HandlerManager eventBus;
	private final Display display;
	private int selectedRow;
	private String id;

	public ContactsPresenter(SharedContactsServiceAsync rpcService,
			HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
		contact = new Contact();
	}

	/**
	 * 
	 * Bind events to the view
	 * 
	 */
	private void bind() {
		// event d'ajout
		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.clearDetailsPanelFields();
				display.getFirstFocusField().setFocus(true);

			}
		});

		// event de suppression
		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				display.clearDetailsPanelFields();
				if (!display.getSharedContactsSelectedRows().isEmpty()
						|| !display.getPrivateContactsSelectedRows().isEmpty()) {
					display.showWaitingDialog();
					deleteSelectedContacts();
				}
			}
		});

		// event de clic sur un contact partagé
		display.getSharedContactList().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doGetContact(event, KEY_SHARED);
			}
		});

		// event clic sur contact privé
		display.getPrivateContactList().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doGetContact(event, KEY_PRIVATE);

			}
		});

		// event de clic sur sauvegarde
		this.display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.showWaitingDialog();
				if ((display.getSelectedRow() != -1)
						&& contact.getType().equals(
								getTypeOfContactForPresenter(display
										.getContactType().getSelectedIndex())))
					doSave();
				else
					doAddcontact();
			}
		});
	}

	/**
	 * 
	 * @param event
	 *            Get the selected contact details
	 * @param key
	 * 
	 */
	private void doGetContact(ClickEvent event, String key) {
		display.clearDetailsPanelFields();
		if (key.equals(KEY_SHARED))
			selectedRow = display.getSharedContactsClickedRow(event) - 1;
		if (key.equals(KEY_PRIVATE))
			selectedRow = display.getPrivateContactsClickedRow(event) - 1;

		if (selectedRow >= 0) {

			if (key.equals(KEY_SHARED))
				id = sharedContactDetails.get(selectedRow).getId();
			if (key.equals(KEY_PRIVATE))
				id = privateContactDetails.get(selectedRow).getId();
			rpcService.getContact(id, new AsyncCallback<Contact>() {
				public void onSuccess(Contact result) {
					contact = result;
					doMapContact(FROM_CONTACT_TO_DISPLAY);
				}

				public void onFailure(Throwable caught) {
					Window.alert("Error retrieving contact");
				}
			});
		}
		display.hideWaitingDialog();
	}

	/**
	 * 
	 * Save contact
	 * 
	 */
	private void doSave() {
		doMapContact(FROM_DISPLAY_TO_CONTACT);
		contact.setId(id);

		rpcService.updateContact(contact, new AsyncCallback<ContactLists>() {
			public void onSuccess(ContactLists result) {
				processData(result);
				// bypass the event to prevent page reloading
				// eventBus.fireEvent(new ContactUpdatedEvent(result));
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error updating contact: \n" + caught.getMessage());
			}

		});
	}

	/**
	 * 
	 * Add contact
	 * 
	 */
	private void doAddcontact() {

		doMapContact(FROM_DISPLAY_TO_CONTACT);

		rpcService.addContact(contact, new AsyncCallback<ContactLists>() {
			public void onSuccess(ContactLists result) {
				processData(result);
				// we don't throw this event anymore because of no-reloading
				// page
				// bypass of the controller which is supposed to create
				// a new instance of this presenter/view
				// eventBus.fireEvent(new AddContactEvent());
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error adding contact: \n" + caught.getMessage());
			}

		});
	}

	/**
	 * Delete selected contacts
	 * 
	 */
	private void deleteSelectedContacts() {
		HashMap<String, ArrayList<String>> mapOfIds = new HashMap<String, ArrayList<String>>();
		// shared contacts
		List<Integer> selectedRows = display.getSharedContactsSelectedRows();
		ArrayList<String> sharedIdList = new ArrayList<String>();

		for (int i = 0; i < selectedRows.size(); ++i) {
			sharedIdList.add(sharedContactDetails
					.get((selectedRows.get(i) - 2)).getId());
		}
		// private contacts
		List<Integer> selectedPrivateRows = display
				.getPrivateContactsSelectedRows();
		ArrayList<String> privateIdList = new ArrayList<String>();

		for (int i = 0; i < selectedPrivateRows.size(); ++i) {
			privateIdList.add(privateContactDetails.get(
					(selectedPrivateRows.get(i) - 2)).getId());
		}

		mapOfIds.put(KEY_SHARED, sharedIdList);
		mapOfIds.put(KEY_PRIVATE, privateIdList);

		rpcService.deleteContacts(mapOfIds, new AsyncCallback<ContactLists>() {

			@Override
			public void onSuccess(ContactLists result) {
				processData(result);
				// we don't throw event anymore for now
				// eventBus.fireEvent(new ContactDeletedEvent());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error deleting contact: \n" + caught.getMessage());
			}

		});
	}

	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		fetchContactDetails();
	}

	public void sortContactDetails() {

		// Yes, we could use a more optimized method of sorting, but the
		// point is to create a test case that helps illustrate the higher
		// level concepts used when creating MVP-based applications.
		//
		for (int i = 0; i < sharedContactDetails.size(); ++i) {
			for (int j = 0; j < sharedContactDetails.size() - 1; ++j) {
				if (sharedContactDetails
						.get(j)
						.getFullName()
						.compareToIgnoreCase(
								sharedContactDetails.get(j + 1).getFullName()) >= 0) {
					Contact tmp = sharedContactDetails.get(j);
					sharedContactDetails
							.set(j, sharedContactDetails.get(j + 1));
					sharedContactDetails.set(j + 1, tmp);
				}
			}
		}

		for (int i = 0; i < privateContactDetails.size(); ++i) {
			for (int j = 0; j < privateContactDetails.size() - 1; ++j) {
				if (privateContactDetails
						.get(j)
						.getFullName()
						.compareToIgnoreCase(
								privateContactDetails.get(j + 1).getFullName()) >= 0) {
					Contact tmp = privateContactDetails.get(j);
					privateContactDetails.set(j,
							privateContactDetails.get(j + 1));
					privateContactDetails.set(j + 1, tmp);
				}
			}
		}
	}

	/**
	 * Fetching contacts details
	 */
	private void fetchContactDetails() {
		rpcService.getContactDetails(new AsyncCallback<ContactLists>() {
			public void onSuccess(ContactLists result) {
				processData(result);
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error fetching contact details");
			}
		});
	}

	/**
	 * Method called when a new action is performed Reset the view and set the
	 * new data from server
	 * 
	 * @param result
	 */
	private void processData(ContactLists result) {
		sharedContactDetails = (ArrayList<Contact>) result.getSharedContacts();
		privateContactDetails = (ArrayList<Contact>) result
				.getPrivateContacts();
		sortContactDetails();
		display.setData(result);
		display.hideWaitingDialog();
		display.clearDetailsPanelFields();
	}

	/**
	 * Map between ACTION_GET: Contact => Display ACTION_SET: Display => Contact
	 * 
	 * @param action
	 */
	private void doMapContact(int action) {
		if (action == FROM_DISPLAY_TO_CONTACT) {
			contact.setFullName(display.getFullName().getValue());
			contact.setTitle(display.getContactTitle().getValue());
			contact.setEmailAddress(display.getEmailAddress().getContent());
			contact.setAddresses(display.getAddresses().getContent());
			contact.setOrganization(display.getOrganization().getValue());
			contact.setPhone(display.getPhone().getContent());
			contact.setWebSite(display.getWebsite().getValue());
			contact.setNotes(display.getNotes().getValue());
			contact.setType(display.getContactType().getValue(
					display.getContactType().getSelectedIndex()));

		}
		if (action == FROM_CONTACT_TO_DISPLAY) {
			display.getFullName().setValue(contact.getFullName());
			display.getContactTitle().setValue(contact.getTitle());
			display.getEmailAddress().setContent(contact.getEmailAddress());
			display.getAddresses().setContent(contact.getAddresses());
			display.getOrganization().setValue(contact.getOrganization());
			display.getPhone().setContent(contact.getPhone());
			display.getWebsite().setValue(contact.getWebSite());
			display.getNotes().setValue(contact.getNotes());
			display.getContactType().setSelectedIndex(
					getTypeOfConctactForView(contact.getType()));
			display.getLastUpdated().setText("Last Updated: \n" +contact.getLastUpdated());
		}

	}

	private int getTypeOfConctactForView(String type) {
		if (type.equals(KEY_PRIVATE))
			return 1;
		return 0;
	}

	private String getTypeOfContactForPresenter(int type) {
		if (type == 0)
			return KEY_SHARED;
		return KEY_PRIVATE;
	}

}
