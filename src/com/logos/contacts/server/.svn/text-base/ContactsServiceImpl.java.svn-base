package com.logos.contacts.server;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.logos.contacts.client.SharedContactsService;
import com.logos.contacts.shared.Contact;
import com.logos.contacts.shared.ContactLists;
import com.logos.contacts.shared.ContactsConstants;

@SuppressWarnings("serial")
public class ContactsServiceImpl extends RemoteServiceServlet implements
		SharedContactsService, ContactsConstants {

	/**
	 * 
	 * class to manage easily the contacts in the shared contacts feed
	 * 
	 */
	@SuppressWarnings("unused")
	private class ContactInformation {
		private ContactEntry contactEntry;
		private int index;

		public ContactInformation(int index, ContactEntry contactEntry) {
			this.setIndex(index);
			this.setContactEntry(contactEntry);
		}

		private void setIndex(int index) {
			this.index = index;

		}

		private int getIndex() {
			return index;
		}

		public void setContactEntry(ContactEntry contactEntry) {
			this.contactEntry = contactEntry;
		}

		public ContactEntry getContactEntry() {
			return contactEntry;
		}

	}

	private List<Contact> sharedContactDetails = null;

	private List<Contact> privateContactDetails = null;

	private List<ContactEntry> sharedContactEntryList = null;

	private List<ContactEntry> privateContactEntryList = null;

	private ContactLists contactLists = null;

	private ContactsService service;

	private ContactFeed globalContactFeed = null;

	private ContactFeed privateContactFeed = null;

	public ContactsServiceImpl() throws IOException, ServiceException {

		service = new ContactsService(APPLICATION_NAME);

		String userName = LOGIN;
		String password = PASSWORD;

		if (userName == null || password == null) {
			return;
		}
		service.setUserCredentials(userName, password);
		buildContactsList();

	}

	/**
	 * 
	 * @param helper
	 * @param parameters
	 * @throws IOException
	 * @throws ServiceException
	 */
	private void buildContactsList() throws IOException, ServiceException {

		// declarations
		sharedContactEntryList = new ArrayList<ContactEntry>();
		privateContactEntryList = new ArrayList<ContactEntry>();
		sharedContactDetails = new ArrayList<Contact>();
		privateContactDetails = new ArrayList<Contact>();
		contactLists = new ContactLists();
		URL globalFeedUrl = FeedHelper.getGlobalURL();
		URL privateFeedUrl = FeedHelper.getPrivateURL(LOGIN);

		// global query

		Query globalQuery = new Query(globalFeedUrl);
		globalQuery.setMaxResults(MAX_RESULTS);
		globalContactFeed = service.query(globalQuery, ContactFeed.class);

		// private query

		Query privateQuery = new Query(privateFeedUrl);
		privateQuery.setMaxResults(MAX_RESULTS);
		privateContactFeed = service.query(privateQuery, ContactFeed.class);

		// build shared contacts list
		sharedContactEntryList = globalContactFeed.getEntries();
		Contact sharedContact = null;

		for (int i = 0; i < sharedContactEntryList.size(); i++) {
			sharedContact = FeedHelper
					.mapContactEntryToContact(sharedContactEntryList.get(i));
			sharedContactDetails.add(sharedContact);
		}
		contactLists.setSharedContacts(sharedContactDetails);

		// build private contact list
		privateContactEntryList = privateContactFeed.getEntries();
		Contact privateContact = null;

		for (int i = 0; i < privateContactEntryList.size(); i++) {
			privateContact = FeedHelper
					.mapContactEntryToContact(privateContactEntryList.get(i));
			privateContactDetails.add(privateContact);
		}
		contactLists.setPrivateContacts(privateContactDetails);

	}

	/**
	 * 
	 * Add contact
	 * 
	 */
	public ContactLists addContact(Contact contact) {

		try {
			// creates the contact in the feed
			FeedHelper.createContact(service, contact);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getContactDetails();
	}

	/**
	 * 
	 * Updades a contact
	 * 
	 */
	public ContactLists updateContact(Contact contact) {
		ContactInformation contactInfo = searchContactEntryByContact(contact);
		try {
			// update the feed with new contact
			FeedHelper.createUpdateQuery(service, contact,
					contactInfo.getContactEntry());

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return getContactDetails();
	}

	/**
	 * Delete a shared contact
	 * 
	 * @param id
	 * @return
	 */
	public void deleteSharedContact(String id) {
		int i = 0;
		try {
			ContactEntry entry = null;
			for (i = 0; i < sharedContactEntryList.size(); i++) {
				if ((sharedContactEntryList.get(i).getId()).equals(id)) {
					entry = sharedContactEntryList.get(i);
					break;
				}
			}
			entry.delete();
			sharedContactEntryList.remove(i);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete a shared contact
	 * 
	 * @param id
	 * @return
	 */
	public void deletePrivateContact(String id) {
		int i = 0;
		try {
			ContactEntry entry = null;
			for (i = 0; i < privateContactEntryList.size(); i++) {
				if ((privateContactEntryList.get(i).getId()).equals(id)) {
					entry = privateContactEntryList.get(i);
					break;
				}
			}
			entry.delete();
			privateContactEntryList.remove(i);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Deletes selected contacts from GUI
	 * 
	 * @return
	 * 
	 */
	public ContactLists deleteContacts(
			HashMap<String, ArrayList<String>> mapOfIds) {
		ArrayList<String> ids = new ArrayList<String>(mapOfIds.get(KEY_SHARED));
		for (int i = 0; i < ids.size(); ++i) {
			deleteSharedContact(ids.get(i));
		}
		sharedContactEntryList.clear();

		ArrayList<String> idsp = new ArrayList<String>(
				mapOfIds.get(KEY_PRIVATE));
		for (int i = 0; i < idsp.size(); ++i) {
			deletePrivateContact(idsp.get(i));
		}
		privateContactEntryList.clear();

		try {
			buildContactsList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return getContactDetails();
	}

	/**
	 * Builds a contact List from ContactEntry Hashmap
	 * 
	 * @return ArrayList<Contact>
	 * @throws ServiceException
	 * @throws IOException
	 */
	public ContactLists getContactDetails() {
		if (!sharedContactEntryList.isEmpty())
			try {
				buildContactsList();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		return contactLists;
	}

	/**
	 * 
	 */
	public Contact getContact(String id) {
		for (int i = 0; i < privateContactEntryList.size(); i++) {
			if (privateContactEntryList.get(i).getId().equals(id)) {
				return FeedHelper
						.mapContactEntryToContact(privateContactEntryList
								.get(i));
			}
		}
		for (int i = 0; i < sharedContactEntryList.size(); i++) {
			if (sharedContactEntryList.get(i).getId().equals(id)) {
				return FeedHelper
						.mapContactEntryToContact(sharedContactEntryList.get(i));
			}
		}
		return null;
	}

	/**
	 * Search in the list the ContactEntry corresponding to a contact
	 * 
	 * @param contact
	 * @return
	 */
	private ContactInformation searchContactEntryByContact(Contact contact) {
		int indexOfEntry = 0;
		ContactInformation contactInfo = null;
		// search the existing contactEntry
		if (contact.getType().equals(KEY_SHARED)) {
			for (indexOfEntry = 0; indexOfEntry < sharedContactEntryList.size(); indexOfEntry++) {
				if ((sharedContactEntryList.get(indexOfEntry).getId())
						.equals(contact.getId()))
					break;
			}
			contactInfo = new ContactInformation(indexOfEntry,
					sharedContactEntryList.get(indexOfEntry));

		} else {
			for (indexOfEntry = 0; indexOfEntry < privateContactEntryList
					.size(); indexOfEntry++) {
				if ((privateContactEntryList.get(indexOfEntry).getId())
						.equals(contact.getId()))
					break;
			}
			contactInfo = new ContactInformation(indexOfEntry,
					privateContactEntryList.get(indexOfEntry));
		}
		return contactInfo;
	}

}
