package com.logos.contacts.shared;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 * Object used for client/server communication
 * This object is intended to contain all elements about contacts/groups
 * 
 * 
 * @author cwbeber
 *
 */
public class ContactLists implements IsSerializable, Serializable, ContactsConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2337986382662725337L;
		
	private Map<String, List<Contact>> map;
	
	public ContactLists () {
		map = new HashMap<String, List<Contact>>();
	}

	public void setPrivateContacts (List <Contact> list) {
		map.put(KEY_PRIVATE, list);
	}
	
	public List <Contact> getPrivateContacts () {
		return map.get(KEY_PRIVATE);
	}
	
	public void setSharedContacts (List <Contact> list) {
		map.put(KEY_SHARED, list);
	}
	
	public List <Contact> getSharedContacts () {
		return map.get(KEY_SHARED);
	}
}

