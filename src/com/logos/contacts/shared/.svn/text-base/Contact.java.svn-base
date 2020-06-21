package com.logos.contacts.shared;

import java.io.Serializable;
import java.util.List;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 * Contact Object mapped with the feeds
 * 
 * @author cweber
 * 
 */
public class Contact implements IsSerializable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String id;
	private String fullName;
	private String title;
	private List<ComplexField> emailAddress;
	private List<ComplexField> addresses;
	private String organization;

	private List<ComplexField> phone;

	private String webSite;
	private String notes;
	private String editLink;
	private String eTag;
	private String type;
	private String lastUpdated;
	public Contact() {
	}

	public Contact(String id, String fullName, String title,
			List<ComplexField> emailAddress, List<ComplexField> adresses,  String organization, List<ComplexField> phone, String webSite, String notes, String editLink, String eTag, String typeOfContact, String lastUpdated) {
		this.id = id;
		this.fullName = fullName;
		this.title = title;
		this.emailAddress = emailAddress;
		this.addresses = adresses;
		this.organization = organization;
		this.phone = phone;
		this.webSite = webSite;
		this.notes = notes;
		this.editLink = editLink;
		this.seteTag(eTag);
		this.setType(typeOfContact);
		this.lastUpdated= lastUpdated;
		
		
	}

	public List<ComplexField> getAddresses() {
		return addresses;
	}

	public String getEditLink() {
		return editLink;
	}
	

	public List<ComplexField> getEmailAddress() {
		return emailAddress;
	}

	public String geteTag() {
		return eTag;
	}

	public String getFullName() {
		return fullName;
	}

	public String getId() {
		return id;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}


	public String getNotes() {
		return notes;
	}

	public String getOrganization() {
		return organization;
	}

	public List<ComplexField> getPhone() {
		return phone;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setAddresses(List<ComplexField> addresses) {
		this.addresses = addresses;
	}

	public void setEditLink(String editLink) {
		this.editLink = editLink;
	}

	public void setEmailAddress(List<ComplexField> emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setPhone(List<ComplexField> phone) {
		this.phone = phone;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
}
