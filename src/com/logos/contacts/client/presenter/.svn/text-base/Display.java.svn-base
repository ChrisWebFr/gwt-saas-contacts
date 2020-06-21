package com.logos.contacts.client.presenter;

import java.util.List;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.logos.contacts.client.view.widget.FlexibleCustomWidget;
import com.logos.contacts.shared.ContactLists;

/**
 * Display interface = contract for the view
 * 
 */
public interface Display {

	// ////////////////////////
	// CONTACTS LISTS
	// ////////////////////////
	HasClickHandlers getSharedContactList();

	HasClickHandlers getPrivateContactList();

	// ///////////////////////////
	// BUTTONS
	// //////////////////////////
	HasClickHandlers getSaveButton();

	HasClickHandlers getAddButton();

	HasClickHandlers getDeleteButton();

	////////////////////////////////
	// FIELDS
	////////////////////////////////
	HasValue<String> getFullName();

	HasValue<String> getContactTitle();

	FlexibleCustomWidget getEmailAddress();
	
	FlexibleCustomWidget getAddresses ();

	HasValue<String> getOrganization();

	FlexibleCustomWidget getPhone();

	HasValue<String> getWebsite();

	HasValue<String> getNotes();
		
	ListBox getContactType();
	
	Label getLastUpdated ();

	///////////////////////
	// SET DATA TO VIEW
	///////////////////////
	void setData(ContactLists data);

	///////////////////////
	// METHODS FOR EVENTS
	///////////////////////

	int getSelectedRow();
	

	int getSharedContactsClickedRow(ClickEvent event);
	
	int getPrivateContactsClickedRow (ClickEvent event);

	List<Integer> getSharedContactsSelectedRows();
	
	List<Integer> getPrivateContactsSelectedRows ();

	void clearDetailsPanelFields();

	TextBox getFirstFocusField();

	Widget asWidget();

	void highlightSelectedRow(int row, String key);
	
	void showWaitingDialog();
	
	void hideWaitingDialog();

	void showConfirmation();

	boolean getConfirmationFromDialog();
}