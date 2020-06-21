package com.logos.contacts.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextContent;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.Website;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.FormattedAddress;
import com.google.gdata.data.extensions.FullName;
import com.google.gdata.data.extensions.Name;
import com.google.gdata.data.extensions.OrgName;
import com.google.gdata.data.extensions.OrgTitle;
import com.google.gdata.data.extensions.Organization;
import com.google.gdata.data.extensions.PhoneNumber;
import com.google.gdata.data.extensions.StructuredPostalAddress;
import com.google.gdata.util.ServiceException;
import com.logos.contacts.shared.ComplexField;
import com.logos.contacts.shared.Contact;
import com.logos.contacts.shared.ContactsConstants;

/**
 * 
 * @author cweber Helper for feed operations
 * 
 */
public class FeedHelper implements ContactsConstants {

	/**
	 * Updates a Contact Entry by giving a Contact as parameter
	 * 
	 * @param myService
	 * @param contactToUpdate
	 * @return ContactEntry
	 * @throws ServiceException
	 * @throws IOException
	 */
	public static ContactEntry createUpdateQuery(ContactsService myService,
			Contact contactToUpdate, ContactEntry contactEntry)
			throws IOException, ServiceException {
		URL editUrl = new URL(contactToUpdate.getEditLink());
		return myService.update(editUrl,
				fillContactEntry(contactToUpdate, contactEntry));
	}

	/**
	 * Adds a contact
	 * 
	 * @param myService
	 * @param contactToAdd
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	public static ContactEntry createContact(ContactsService myService,
			Contact contactToAdd) throws ServiceException, IOException {
		// Ask the service to insert the new entry
		if (contactToAdd.getType().equals(KEY_SHARED))
			return myService.insert(getGlobalURL(),
					fillContactEntry(contactToAdd, null));
		if (contactToAdd.getType().equals(KEY_PRIVATE))
			return myService.insert(getPrivateURL(LOGIN),
					fillContactEntry(contactToAdd, null));
		return null;
	}

	/**
	 * This method fills the contactEntry with the Contact Object
	 * 
	 * @param contactToAdd
	 * @param contactEntry
	 * @return
	 */
	private static ContactEntry fillContactEntry(Contact contactToAdd,
			ContactEntry contactEntry) {
		// Create the entry to insert or get the existing one
		ContactEntry contact;
		if (contactEntry == null) {
			contact = new ContactEntry();

		} else {
			contact = contactEntry;
		}

		// NAME
		Name name = new Name();
		name.setFullName(new FullName(contactToAdd.getFullName(), NO_YOMI));
		contact.setName(name);

		// NOTES
		contact.setContent(new PlainTextConstruct(contactToAdd.getNotes()));

		// EMAIL
		fillEmail(contactToAdd, contact);

		// POSTAL ADDRESS
		fillAdress(contactToAdd, contact);

		// ORGANIZATION & TITLE
		if (!contactToAdd.getOrganization().equals("")) {
			if (contact.hasOrganizations())
				contact.getOrganizations().clear();
			Organization organization = new Organization();
			organization.setOrgTitle(new OrgTitle(contactToAdd.getTitle()));
			organization.setPrimary(true);
			organization.setRel(Organization.Rel.WORK);
			organization
					.setOrgName(new OrgName(contactToAdd.getOrganization()));
			contact.addOrganization(organization);
		}
		if (contact.hasOrganizations()
				&& contactToAdd.getOrganization().equals(""))
			contact.getOrganizations().clear();

		// PHONE

		fillPhone(contactToAdd, contact);

		// WEBSITE
		if (!contactToAdd.getWebSite().equals("")) {
			if (contact.hasWebsites())
				contact.getWebsites().clear();
			Website website = new Website();
			website.setPrimary(true);
			website.setRel(Website.Rel.WORK);
			website.setHref(contactToAdd.getWebSite());
			contact.addWebsite(website);
		}
		if (contact.hasWebsites() && contactToAdd.getWebSite().equals(""))
			contact.getWebsites().clear();

		return contact;

	}

	private static void fillPhone(Contact contactToAdd, ContactEntry contact) {
		if (!contactToAdd.getPhone().equals("")) {
			if (contact.hasPhoneNumbers())
				contact.getPhoneNumbers().clear();
			PhoneNumber number = null;
			List<ComplexField> phones = contactToAdd.getPhone();
			boolean primary = true;

			for (int i = 0; i < phones.size(); i++) {
				number = new PhoneNumber();
				number.setPrimary(primary);
				number.setLabel(phones.get(i).getType());
				number.setPhoneNumber(phones.get(i).getValue());
				contact.addPhoneNumber(number);
				primary = false;
			}
		}
	}

	private static void fillEmail(Contact contactToAdd, ContactEntry contact) {
		if (contact.hasEmailAddresses())
			contact.getEmailAddresses().clear();
		Email mail = null;
		List<ComplexField> emails = contactToAdd.getEmailAddress();
		boolean primary = true;

		for (int i = 0; i < emails.size(); i++) {
			mail = new Email();
			mail.setAddress(emails.get(i).getValue());
			mail.setLabel(emails.get(i).getType());
			mail.setPrimary(primary);
			contact.addEmailAddress(mail);
			primary = false;
		}
	}

	private static void fillAdress(Contact contactToAdd, ContactEntry contact) {
		if (contact.hasPostalAddresses())
			contact.getPostalAddresses().clear();
		StructuredPostalAddress address = null;
		List<ComplexField> addresses = contactToAdd.getAddresses();
		boolean primary = true;

		for (int i = 0; i < addresses.size(); i++) {
			address = new StructuredPostalAddress();
			address.setFormattedAddress(new FormattedAddress(addresses.get(i).getValue()));
			address.setLabel(addresses.get(i).getType());
			address.setPrimary(primary);
			contact.addStructuredPostalAddress(address);
			primary = false;
		}

	}

	/**
	 * Map from ContactEntry to Contact Object
	 * 
	 * @param contact
	 * @return
	 */
	public static Contact mapContactEntryToContact(ContactEntry contactEntry) {
		String fullName = "";
		String title = "";
		List<ComplexField> emailList = null;
		List<ComplexField> addressList = null;
		String organization = "";
		List<ComplexField> phoneList = null;
		String webSite = "";
		String notes = "";
		String typeOfContact = "";

		try {
			fullName = contactEntry.getName().getFullName().getValue();
		} catch (Exception e) {
			fullName = "";
		}
		try {
			title = contactEntry.getOrganizations().get(0).getOrgTitle()
					.getValue();

		} catch (Exception e) {
			title = "";
		}
		emailList = getEmails(contactEntry);
		try {
			organization = contactEntry.getOrganizations().get(0).getOrgName()
					.getValue();
		} catch (Exception e) {
			organization = "";
		}
		phoneList = getPhones(contactEntry);
		addressList = getAddresses(contactEntry);
		try {
			webSite = contactEntry.getWebsites().get(0).getHref();
		} catch (Exception e) {
			webSite = "";
		}
		try {
			TextContent content = (TextContent) contactEntry.getContent();
			notes = content.getContent().getPlainText();
		} catch (Exception e) {
			notes = "";
		}
		try {
			if (contactEntry.getEditLink().getHref()
					.subSequence(0, GLOBAL_FEED_URL.length())
					.equals(GLOBAL_FEED_URL))
				typeOfContact = KEY_SHARED;
			else
				typeOfContact = KEY_PRIVATE;
		} catch (Exception e) {
			typeOfContact = "";
		}

		Contact contact = new Contact(contactEntry.getId(), fullName, title,
				emailList, addressList, organization, phoneList, webSite,
				notes, contactEntry.getEditLink().getHref(),
				contactEntry.getEtag(), typeOfContact, contactEntry
						.getUpdated().toUiString());
		return contact;
	}

	private static List<ComplexField> getAddresses(ContactEntry contactEntry) {
		List<ComplexField> addressList;

		List<StructuredPostalAddress> listOfAddress = new Vector<StructuredPostalAddress>();
		addressList = new Vector<ComplexField>();
		listOfAddress = contactEntry.getStructuredPostalAddresses();
		for (int i = 0; i < listOfAddress.size(); i++) {
			ComplexField address = new ComplexField();

			
			address.setType(listOfAddress.get(i).getLabel());
			if (listOfAddress.get(i).hasFormattedAddress())
			address.setValue(listOfAddress.get(i).getFormattedAddress().getValue());
			addressList.add(address);
		}

		return addressList;

	}

	private static List<ComplexField> getPhones(ContactEntry contactEntry) {
		List<ComplexField> phoneList;

		List<PhoneNumber> listOfPhones = new Vector<PhoneNumber>();
		phoneList = new Vector<ComplexField>();
		listOfPhones = contactEntry.getPhoneNumbers();
		for (int i = 0; i < listOfPhones.size(); i++) {
			ComplexField phone = new ComplexField();

			phone.setType(listOfPhones.get(i).getLabel());
			phone.setValue(listOfPhones.get(i).getPhoneNumber());
			phoneList.add(phone);
		}

		return phoneList;
	}

	private static List<ComplexField> getEmails(ContactEntry contactEntry) {
		List<ComplexField> emailList;

		List<Email> listOfEmails = new Vector<Email>();
		emailList = new Vector<ComplexField>();
		listOfEmails = contactEntry.getEmailAddresses();
		for (int i = 0; i < listOfEmails.size(); i++) {
			ComplexField email = new ComplexField();

			email.setType(listOfEmails.get(i).getLabel());
			email.setValue(listOfEmails.get(i).getAddress());
			emailList.add(email);
		}

		return emailList;
	}

	/**
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getGlobalURL() throws MalformedURLException {
		URL url = new URL(GLOBAL_FEED_URL);
		return url;
	}

	/**
	 * 
	 * @param login
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getPrivateURL(String login) throws MalformedURLException {
		URL url = new URL("http://www.google.com/m8/feeds/contacts/" + login
				+ "/" + PROJECTION);

		return url;
	}

}
