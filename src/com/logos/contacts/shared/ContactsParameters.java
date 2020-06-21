package com.logos.contacts.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * parameters singleton
 * 
 * @author cweber
 * 
 */
public class ContactsParameters implements ContactsConstants {

	// instance
	private static ContactsParameters instance = null;
	// email
	private List<String> emailViewList = null;
	private List<String> emailLabelList = null;
	private Map<String, String> emailKeys = null;

	// phone
	private List<String> phoneViewList = null;
	private List<String> phoneLabelList = null;
	private Map<String, String> phoneKeys = null;

	public static ContactsParameters getInstance() {
		if (instance == null)
			return new ContactsParameters();
		return instance;

	}

	public ContactsParameters() {
		init();

	}

	private void init() {
		getEmailOrAddressParameters();
		getPhoneParameters();

	}

	public synchronized List<String> getPhoneParameters() {
		phoneViewList = new Vector<String>();
		phoneKeys = new HashMap<String, String>();
		phoneLabelList = new Vector<String>();

		// personal
		phoneViewList.add("Personal");
		phoneLabelList.add(FEED_HOME_LABEL);
		phoneKeys.put("Personal", FEED_HOME_LABEL);
		// professional
		phoneViewList.add("Professional");
		phoneLabelList.add(FEED_WORK_LABEL);
		phoneKeys.put("Professional", FEED_WORK_LABEL);
		// mobile
		phoneViewList.add("Mobile");
		phoneLabelList.add(FEED_MOBILE_LABEL);
		phoneKeys.put("Mobile", FEED_MOBILE_LABEL);
		// Personal Fax
		phoneViewList.add("Fax (Personal)");
		phoneLabelList.add(FEED_FAX_HOME_LABEL);
		phoneKeys.put("Fax (Personal)", FEED_FAX_HOME_LABEL);
		// Work Fax
		phoneViewList.add("Fax (Work)");
		phoneLabelList.add(FEED_FAX_WORK_LABEL);
		phoneKeys.put("Fax (Work)", FEED_FAX_WORK_LABEL);
		// Pager
		phoneViewList.add("Pager");
		phoneLabelList.add(FEED_PAGER_LABEL);
		phoneKeys.put("Pager", FEED_PAGER_LABEL);
		// Others
		phoneViewList.add("Other");
		phoneLabelList.add(FEED_OTHER_LABEL);
		phoneKeys.put("Other", FEED_OTHER_LABEL);

		return phoneViewList;
	}

	public synchronized List<String> getEmailOrAddressParameters() {
		emailViewList = new Vector<String>();
		emailKeys = new HashMap<String, String>();
		emailLabelList = new Vector<String>();
		// professional
		emailViewList.add("Professional");
		emailLabelList.add(FEED_WORK_LABEL);
		emailKeys.put("Professional", FEED_WORK_LABEL);
		// personal
		emailViewList.add("Personal");
		emailLabelList.add(FEED_HOME_LABEL);
		emailKeys.put("Personal", FEED_HOME_LABEL);
		// other
		emailViewList.add("Other");
		emailLabelList.add(FEED_OTHER_LABEL);
		emailKeys.put("Other", FEED_OTHER_LABEL);
		return emailViewList;
	}

	public synchronized int getIndexOfEmailOrAddressType(String type) {
		if (type == null) return 0;
		for (int i = 0; i < emailLabelList.size(); i++) {
			if (type.equals(emailLabelList.get(i)))
				return i;
		}
		return 0;

	}
	
	public synchronized int getIndexOfPhoneType (String type) {
		if (type == null) return 0;
		for (int i = 0; i < phoneLabelList.size(); i++) {
			if (type.equals(phoneLabelList.get(i)))
				return i;
		}
		return 0;
	}

	public String getEmailOrAddressTypeByLabel(String label) {
		if (emailKeys == null)
			getEmailOrAddressParameters();

		return emailKeys.get(label);

	}
	
	public String getPhoneTypeByLabel (String label) {
		if (phoneKeys == null)
			getPhoneParameters();

		return phoneKeys.get(label);
	}

}
