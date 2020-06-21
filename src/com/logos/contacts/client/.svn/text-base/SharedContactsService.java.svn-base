package com.logos.contacts.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import com.logos.contacts.shared.Contact;
import com.logos.contacts.shared.ContactLists;

/**
 * 
 * @author cweber
 * 
 *
 */

@RemoteServiceRelativePath("contactsService")
public interface SharedContactsService extends RemoteService {
	
  ContactLists addContact(Contact contact);
  ContactLists deleteContacts(HashMap<String, ArrayList<String>> mapOfIds);
  ContactLists getContactDetails();
  Contact getContact(String id);
  ContactLists updateContact(Contact contact);
}
