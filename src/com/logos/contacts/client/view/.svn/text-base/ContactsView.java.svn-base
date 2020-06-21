package com.logos.contacts.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Image;
import com.logos.contacts.client.presenter.Display;
import com.logos.contacts.client.view.widget.CustomPushButton;
import com.logos.contacts.client.view.widget.FlexibleCustomWidget;
import com.logos.contacts.client.view.widget.QuestionDialogBox;
import com.logos.contacts.client.view.widget.WaitingDialogBox;
import com.logos.contacts.shared.ContactLists;
import com.logos.contacts.shared.ContactsConstants;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.logos.contacts.client.view.widget.ContactDetailsFlexTable;

public class ContactsView extends Composite implements Display,
		ContactsConstants {

	private CustomPushButton addButton;
	private final CustomPushButton deleteButton;
	private FlexTable sharedContactsTable;
	private final FlexTable contentTable;
	private VerticalPanel vDetailsPanel;
	private PushButton saveButton;
	private DecoratorPanel contactDetailsPanelDecorator;
	private Label lblFirstName_1;
	private Label lblLastName_1;
	private Label lblEmailAddress_1;
	private int currentRow = -1;
	private Label lblEmpty;
	private HorizontalPanel horizontalPanel;
	private ScrollPanel sharedScrollPanel;
	private DecoratedStackPanel decoratedStackPanel;
	private Label lblContacts;
	private ScrollPanel privateScrollPanel;
	private FlexTable privateContactsTable;
	private Label lblEmpty_1;
	private UIObject lblFirstName_2;
	private Label lblLastName_2;
	private Label lblEmailAddress_2;
	private WaitingDialogBox waitingDialogBox = null;
	private FlexTable hMainPanel;
	private QuestionDialogBox questionDialogBox;
	private ContactDetailsFlexTable contactDetailsFlexTable;
	private FlexTable detailsContentTable;
	private HorizontalPanel horizontalPanel_1;
	private Label lblDetails;
	private ScrollPanel scrollPanel;

	public ContactsView() {
		hMainPanel = new FlexTable();

		hMainPanel.setStyleName("panelStyle");
		initWidget(hMainPanel);
		hMainPanel.setSize("", "100%");
		DecoratorPanel contactsTableDecorator = new DecoratorPanel();
		contactsTableDecorator.setSize("400px", "600");

		VerticalPanel vContentPanel = new VerticalPanel();
		contentTable = new FlexTable();
		contentTable.setSize("400", "30");
		contentTable.getCellFormatter().addStyleName(0, 0,
				"contacts-ListContainer");
		contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");

		vContentPanel.add(contentTable);
		vContentPanel.add(contentTable);

		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		contentTable.setWidget(0, 0, horizontalPanel);
		horizontalPanel.setSize("210", "30");
		contentTable.getCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		lblContacts = new Label("Contacts");
		horizontalPanel.add(lblContacts);
		horizontalPanel.setCellVerticalAlignment(lblContacts,
				HasVerticalAlignment.ALIGN_MIDDLE);
		addButton = new CustomPushButton(CustomPushButton.ADD_CONTACT_STYLE);
		horizontalPanel.add(addButton);
		horizontalPanel.setCellHorizontalAlignment(addButton,
				HasHorizontalAlignment.ALIGN_RIGHT);

		horizontalPanel.setCellVerticalAlignment(addButton,
				HasVerticalAlignment.ALIGN_MIDDLE);

		deleteButton = new CustomPushButton(CustomPushButton.DELETE_STYLE);
		horizontalPanel.add(deleteButton);

		horizontalPanel.setCellVerticalAlignment(deleteButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		hMainPanel.setWidget(0, 0, contactsTableDecorator);
		contactsTableDecorator.add(vContentPanel);
		vContentPanel.setSize("", "100%");

		decoratedStackPanel = new DecoratedStackPanel();
		vContentPanel.add(decoratedStackPanel);
		vContentPanel.setCellHeight(decoratedStackPanel, "100%");
		vContentPanel.setCellWidth(decoratedStackPanel, "100%");
		decoratedStackPanel.setSize("400", "600");

		privateScrollPanel = new ScrollPanel();
		privateScrollPanel.setSize("100%", "100%");

		privateContactsTable = new FlexTable();
		privateContactsTable.setCellSpacing(0);
		privateContactsTable.setCellPadding(0);
		privateContactsTable.setBorderWidth(0);
		privateScrollPanel.setWidget(privateContactsTable);
		privateContactsTable.setSize("100%", "");

		sharedScrollPanel = new ScrollPanel();
		decoratedStackPanel
				.add(sharedScrollPanel, "Shared contacts</h1>", true);
		sharedScrollPanel.setSize("100%", "100%");

		// Create the contacts list
		//
		sharedContactsTable = new FlexTable();
		sharedScrollPanel.setWidget(sharedContactsTable);
		sharedContactsTable.setBorderWidth(0);
		sharedContactsTable.setCellSpacing(0);
		sharedContactsTable.setCellPadding(0);
		sharedContactsTable.setSize("100%", "");
		sharedContactsTable.addStyleName("contacts-ListContents");
		sharedContactsTable.getColumnFormatter().setWidth(4, "15px");
		decoratedStackPanel.add(privateScrollPanel, "Private contacts", false);

		contactDetailsPanelDecorator = new DecoratorPanel();
		hMainPanel.setWidget(0, 1, contactDetailsPanelDecorator);
		contactDetailsPanelDecorator.setSize("", "600");

		vDetailsPanel = new VerticalPanel();
		vDetailsPanel.setSize("100%", "100%");

		detailsContentTable = new FlexTable();
		detailsContentTable.setStyleName("td.contacts-ListContainer");
		vDetailsPanel.add(detailsContentTable);
		detailsContentTable.setSize("100%", "100%");
		
		scrollPanel = new ScrollPanel();
		scrollPanel.setSize("450", "600");
		scrollPanel.setStyleName("panelStyle");
		vDetailsPanel.add(scrollPanel);
		vDetailsPanel.setCellHeight(scrollPanel, "100%");
		vDetailsPanel.setCellWidth(scrollPanel, "100%");
		contactDetailsPanelDecorator.setWidget(vDetailsPanel);
		contactDetailsFlexTable = new ContactDetailsFlexTable();
		scrollPanel.setWidget(contactDetailsFlexTable);
		contactDetailsFlexTable.getLastUpdatedLabel().setText("");
		contactDetailsFlexTable.setSize("100%", "100%");



		horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.setSpacing(5);
		detailsContentTable.setWidget(0, 0, horizontalPanel_1);
		horizontalPanel_1.setSize("210", "30");

		lblDetails = new Label("Details");
		horizontalPanel_1.add(lblDetails);
		horizontalPanel_1.setCellVerticalAlignment(lblDetails,
				HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setCellHorizontalAlignment(lblDetails,
				HasHorizontalAlignment.ALIGN_CENTER);
		detailsContentTable.getCellFormatter().setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);
		
				saveButton = new PushButton("Save");
				detailsContentTable.setWidget(0, 1, saveButton);
				saveButton.setSize("18", "18");
				saveButton.getUpFace().setImage(new Image("images/SaveIcon.png"));
				detailsContentTable.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER);
				detailsContentTable.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		detailsContentTable.getCellFormatter().addStyleName(0, 0,
				"contacts-ListMenu");
		detailsContentTable.getCellFormatter().addStyleName(0, 1,
		"contacts-ListMenu");
		hMainPanel.getCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);
		hMainPanel.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);

	}

	public Widget asWidget() {
		return this;
	}

	@Override
	public void clearDetailsPanelFields() {
		contactDetailsFlexTable.clear();
		deselectAllRows();

	}

	private void deselectAllRows() {
		for (int i = 0; i < sharedContactsTable.getRowCount(); i++) {
			sharedContactsTable.getRowFormatter().setStyleName(i,
					CONTACT_LIST_ROW);
		}
		for (int i = 0; i < privateContactsTable.getRowCount(); i++) {
			privateContactsTable.getRowFormatter().setStyleName(i,
					CONTACT_LIST_ROW);
		}
		currentRow = -1;
	}

	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public boolean getConfirmationFromDialog() {

		return questionDialogBox.isOK();
	}

	@Override
	public HasValue<String> getContactTitle() {

		return contactDetailsFlexTable.titleTextBox;
	}

	@Override
	public ListBox getContactType() {

		return contactDetailsFlexTable.contactTypeComboBox;
	}

	public HasClickHandlers getDeleteButton() {
		return deleteButton;
	}

	@Override
	public FlexibleCustomWidget getEmailAddress() {

		return contactDetailsFlexTable.getEmailCustomWidget();

	}
	
	@Override
	public FlexibleCustomWidget getAddresses() {
		
		return contactDetailsFlexTable.getAddressCustomWidget();
	}

	@Override
	public TextBox getFirstFocusField() {
		// return the firs field to be focused
		return contactDetailsFlexTable.fullNameTextBox;
	}

	@Override
	public HasValue<String> getFullName() {

		return contactDetailsFlexTable.fullNameTextBox;
	}

	@Override
	public Label getLastUpdated() {
		return contactDetailsFlexTable.getLastUpdatedLabel();
	}

	@Override
	public HasValue<String> getNotes() {
		return contactDetailsFlexTable.notesTextArea;
	}

	@Override
	public HasValue<String> getOrganization() {
		return contactDetailsFlexTable.organizationTextBox;
	}

	@Override
	public FlexibleCustomWidget getPhone() {
		return contactDetailsFlexTable.getPhoneCustomWidget();
	}

	@Override
	public HasClickHandlers getPrivateContactList() {

		return privateContactsTable;
	}

	@Override
	public int getPrivateContactsClickedRow(ClickEvent event) {
		int selectedRow = -1;
		HTMLTable.Cell cell = privateContactsTable.getCellForEvent(event);

		if (cell != null) {
			// Suppress clicks if the user is actually selecting the
			// check box
			//
			if (cell.getCellIndex() > 0 && cell.getRowIndex() != 0) {
				selectedRow = cell.getRowIndex();
				deselectAllRows();
				highlightSelectedRow(selectedRow, KEY_PRIVATE);
				currentRow = selectedRow;
			}
		}
		currentRow = selectedRow;
		return selectedRow;
	}

	@Override
	public List<Integer> getPrivateContactsSelectedRows() {
		List<Integer> selectedRows = new ArrayList<Integer>();

		for (int i = 1; i < privateContactsTable.getRowCount(); ++i) {
			CheckBox checkBox = (CheckBox) privateContactsTable.getWidget(i, 0);
			if (checkBox.getValue()) {
				selectedRows.add(i + 1);
			}
		}

		return selectedRows;
	}

	@Override
	public HasClickHandlers getSaveButton() {

		return saveButton;
	}

	@Override
	public int getSelectedRow() {
		return currentRow;

	}

	public HasClickHandlers getSharedContactList() {
		return sharedContactsTable;
	}

	public int getSharedContactsClickedRow(ClickEvent event) {
		int selectedRow = -1;
		HTMLTable.Cell cell = sharedContactsTable.getCellForEvent(event);

		if (cell != null) {
			// Suppress clicks if the user is actually selecting the
			// check box
			//
			if (cell.getCellIndex() > 0 && cell.getRowIndex() != 0) {
				selectedRow = cell.getRowIndex();
				deselectAllRows();
				highlightSelectedRow(selectedRow, KEY_SHARED);
				currentRow = selectedRow;
			}
		}
		currentRow = selectedRow;
		return selectedRow;
	}

	public List<Integer> getSharedContactsSelectedRows() {
		List<Integer> selectedRows = new ArrayList<Integer>();

		for (int i = 1; i < sharedContactsTable.getRowCount(); ++i) {
			CheckBox checkBox = (CheckBox) sharedContactsTable.getWidget(i, 0);
			if (checkBox.getValue()) {
				selectedRows.add(i + 1);
			}
		}

		return selectedRows;
	}

	@Override
	public HasValue<String> getWebsite() {
		return contactDetailsFlexTable.webSiteTextBox;
	}

	public void hideWaitingDialog() {
		if (waitingDialogBox != null)
			waitingDialogBox.hide();
	}

	@Override
	public void highlightSelectedRow(int row, String key) {
		if (key.equals(KEY_SHARED))
			sharedContactsTable.getRowFormatter().setStyleName(row,
					SELECTED_ROW_STYLE);
		if (key.equals(KEY_PRIVATE))
			privateContactsTable.getRowFormatter().setStyleName(row,
					SELECTED_ROW_STYLE);

	}

	/**
	 * Set data to the view
	 */
	public void setData(ContactLists data) {
		sharedContactsTable.removeAllRows();
		privateContactsTable.removeAllRows();
		// setSharedContactTableHeaders();
		// setPrivateContactTableHeaders();

		for (int i = 0; i < data.getSharedContacts().size(); ++i) {
			sharedContactsTable.setWidget(i + 1, 0, new CheckBox());
			sharedContactsTable.setHTML(i + 1, 1,
					data.getSharedContacts().get(i).getFullName() +"<br>"+ data.getSharedContacts().get(i).getEmailAddress().get(0).getValue());

			sharedContactsTable.setStyleName(CONTACT_LIST_ROW);
		}

		for (int i = 0; i < data.getPrivateContacts().size(); ++i) {
			privateContactsTable.setWidget(i + 1, 0, new CheckBox());
			privateContactsTable.setHTML(i + 1, 1, data.getPrivateContacts()
					.get(i).getFullName() + "<br>" + data.getPrivateContacts()
					.get(i).getEmailAddress().get(0).getValue() );

			privateContactsTable.setStyleName(CONTACT_LIST_ROW);
		}
	}

	/**
	 * Set headers for the flexTable contacts
	 */
	@SuppressWarnings("unused")
	private void setPrivateContactTableHeaders() {
		lblEmpty_1 = new Label(" ");
		privateContactsTable.setWidget(0, 0, lblEmpty);
		lblEmpty_1.setStyleName(HEADER_ROW_STYLE);

		lblFirstName_2 = new Label("First Name");
		privateContactsTable.setWidget(0, 1, lblFirstName_1);
		lblFirstName_2.setStyleName(HEADER_ROW_STYLE);

		lblLastName_2 = new Label("Last name");
		privateContactsTable.setWidget(0, 2, lblLastName_1);
		lblLastName_2.setStyleName(HEADER_ROW_STYLE);

		lblEmailAddress_2 = new Label("Email Address");
		privateContactsTable.setWidget(0, 3, lblEmailAddress_1);
		lblEmailAddress_2.setStyleName(HEADER_ROW_STYLE);

	}

	/**
	 * Set headers for the flexTable contacts
	 */
	@SuppressWarnings("unused")
	private void setSharedContactTableHeaders() {
		lblEmpty = new Label(" ");
		sharedContactsTable.setWidget(0, 0, lblEmpty);
		lblEmpty.setStyleName(HEADER_ROW_STYLE);

		lblFirstName_1 = new Label("First Name");
		sharedContactsTable.setWidget(0, 1, lblFirstName_1);
		lblFirstName_1.setStyleName(HEADER_ROW_STYLE);

		lblLastName_1 = new Label("Last name");
		sharedContactsTable.setWidget(0, 2, lblLastName_1);
		lblLastName_1.setStyleName(HEADER_ROW_STYLE);

		lblEmailAddress_1 = new Label("Email Address");
		sharedContactsTable.setWidget(0, 3, lblEmailAddress_1);
		lblEmailAddress_1.setStyleName(HEADER_ROW_STYLE);

	}

	@Override
	public void showConfirmation() {
		questionDialogBox = new QuestionDialogBox();
		questionDialogBox.show();

	}

	public void showWaitingDialog() {
		if (waitingDialogBox == null) {
			waitingDialogBox = new WaitingDialogBox();
		}
		waitingDialogBox.show();
	}



}
