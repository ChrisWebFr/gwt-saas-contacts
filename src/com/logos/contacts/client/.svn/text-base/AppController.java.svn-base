package com.logos.contacts.client;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.logos.contacts.client.event.AddContactEvent;
import com.logos.contacts.client.event.AddContactEventHandler;
import com.logos.contacts.client.event.ContactDeletedEvent;
import com.logos.contacts.client.event.ContactDeletedEventHandler;
import com.logos.contacts.client.event.ContactUpdatedEvent;
import com.logos.contacts.client.event.ContactUpdatedEventHandler;
import com.logos.contacts.client.event.EditContactCancelledEvent;
import com.logos.contacts.client.event.EditContactCancelledEventHandler;
import com.logos.contacts.client.event.EditContactEvent;
import com.logos.contacts.client.event.EditContactEventHandler;
import com.logos.contacts.client.presenter.ContactsPresenter;
import com.logos.contacts.client.presenter.Presenter;
import com.logos.contacts.client.view.ContactsView;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final SharedContactsServiceAsync rpcService;
	private HasWidgets container;
	private String currentToken;

	public AppController(SharedContactsServiceAsync rpcService,
			HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AddContactEvent.TYPE, new AddContactEventHandler() {
			public void onAddContact(AddContactEvent event) {
				doAddNewContact();
			}
		});

		eventBus.addHandler(EditContactEvent.TYPE,
				new EditContactEventHandler() {
					public void onEditContact(EditContactEvent event) {
						doEditContact(event.getId());
					}
				});

		eventBus.addHandler(EditContactCancelledEvent.TYPE,
				new EditContactCancelledEventHandler() {
					public void onEditContactCancelled(
							EditContactCancelledEvent event) {
						doEditContactCancelled();
					}
				});

		eventBus.addHandler(ContactUpdatedEvent.TYPE,
				new ContactUpdatedEventHandler() {
					public void onContactUpdated(ContactUpdatedEvent event) {
						doContactUpdated();
					}
				});
		eventBus.addHandler(ContactDeletedEvent.TYPE,
				new ContactDeletedEventHandler() {

					@Override
					public void onContactDeleted(ContactDeletedEvent event) {
						doContactsDeleted();
					}
				});
	}

	protected void doContactsDeleted() {
		if (currentToken.equals("delete"))
			History.fireCurrentHistoryState();
		else
			History.newItem("delete");

	}

	private void doAddNewContact() {
		if (currentToken.equals("add"))
			History.fireCurrentHistoryState();
		else
			History.newItem("add");
	}

	private void doEditContact(String id) {
		History.newItem("list");
	}

	private void doEditContactCancelled() {
		History.newItem("list");
	}

	private void doContactUpdated() {

		if (currentToken.equals("edit"))
			History.fireCurrentHistoryState();
		else
			History.newItem("edit");
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("list");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		currentToken = token;

		if (token != null) {
			Presenter presenter = null;

			// dans notre cas on restera toujours sur le meme presenter quelque
			// soit l'action
			if (token.equals("list")) {
				presenter = new ContactsPresenter(rpcService, eventBus,
						new ContactsView());
			}
			if (token.equals("edit")) {
				presenter = new ContactsPresenter(rpcService, eventBus,
						new ContactsView());
			} else if (token.equals("add")) {
				presenter = new ContactsPresenter(rpcService, eventBus,
						new ContactsView());
			} else if (token.equals("delete")) {
				presenter = new ContactsPresenter(rpcService, eventBus,
						new ContactsView());
			}
			
			if (presenter != null) {
				presenter.go(container);
			}
		}
	}
}
