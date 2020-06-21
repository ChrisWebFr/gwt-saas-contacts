package com.logos.contacts.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.logos.contacts.shared.Contact;
import com.logos.contacts.shared.ContactLists;

public interface SharedContactsServiceAsync {

	void addContact(Contact contact, AsyncCallback<ContactLists> callback);

	void deleteContacts(HashMap<String, ArrayList<String>> mapOfIds, AsyncCallback<ContactLists> callback);

	void getContact(String id, AsyncCallback<Contact> callback);

	void getContactDetails(AsyncCallback<ContactLists> callback);

	void updateContact(Contact contact, AsyncCallback<ContactLists> callback);

}
