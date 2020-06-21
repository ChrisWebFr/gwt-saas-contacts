package com.logos.contacts.client.view.widget;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.logos.contacts.shared.ContactsConstants;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class ContactDetailsFlexTable extends FlexTable implements
		ContactsConstants {
	public CustomTextBox organizationTextBox;
	public CustomTextBox titleTextBox;
	public CustomTextBox fullNameTextBox;
	private Label contactTypeLabel;
	public ListBox contactTypeComboBox;
	public CustomTextBox webSiteTextBox;
	private Label notesLabel;
	public TextArea notesTextArea;
	private FlexibleCustomWidget emailCustomWidget;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel absolutePanel_1;
	private AbsolutePanel absolutePanel_2;
	private AbsolutePanel absolutePanel_3;
	private Label lastUpdatedLabel;
	private AbsolutePanel absolutePanel_4;
	private FlexibleCustomWidget phoneCustomWidget;
	private AbsolutePanel absolutePanel_5;
	private FlexibleCustomWidget addressCustomWidget;

	public ContactDetailsFlexTable() {
		setStyleName("detailsTable");

		setSize("490px", "532px");

		contactTypeLabel = new Label("Contact Type");
		setWidget(0, 0, contactTypeLabel);
		contactTypeLabel.setWidth("");
		getFlexCellFormatter().setColSpan(5, 0, 1);

		lastUpdatedLabel = new Label("Last updated:");
		setWidget(0, 1, lastUpdatedLabel);

		contactTypeComboBox = new ListBox();
		setWidget(1, 0, contactTypeComboBox);
		contactTypeComboBox.addItem("Shared", KEY_SHARED);
		contactTypeComboBox.addItem("Private", KEY_PRIVATE);

		absolutePanel_1 = new AbsolutePanel();
		setWidget(2, 0, absolutePanel_1);
		absolutePanel_1.setSize("50", "20");

		fullNameTextBox = new CustomTextBox("Name");
		fullNameTextBox.setName("lastNameTextBox");
		setWidget(3, 0, fullNameTextBox);
		fullNameTextBox.setWidth("350");

		titleTextBox = new CustomTextBox("Title");
		setWidget(4, 0, titleTextBox);
		titleTextBox.setWidth("200");

		organizationTextBox = new CustomTextBox("Organization");
		setWidget(5, 0, organizationTextBox);
		organizationTextBox.setSize("200", "22");

		absolutePanel = new AbsolutePanel();
		setWidget(6, 0, absolutePanel);
		absolutePanel.setSize("50", "20");

		emailCustomWidget = new FlexibleCustomWidget("Email", EMAIL_WIDGET_TYPE);
		emailCustomWidget.getBoxAndLabelWidget().getSelectionComboBox()
				.setHeight("25");
		setWidget(7, 0, emailCustomWidget);
				
				absolutePanel_5 = new AbsolutePanel();
				setWidget(8, 0, absolutePanel_5);
				absolutePanel_5.setSize("50", "15");
		
				phoneCustomWidget = new FlexibleCustomWidget("Phone", PHONE_WIDGET_TYPE);
				phoneCustomWidget.getBoxAndLabelWidget().getSelectionComboBox()
						.setHeight("25");
				setWidget(9, 0, phoneCustomWidget);

		absolutePanel_2 = new AbsolutePanel();
		setWidget(10, 0, absolutePanel_2);
		absolutePanel_2.setSize("50", "20");
		
		addressCustomWidget = new FlexibleCustomWidget("Address", "ADDRESS_WIDGET_TYPE");
		addressCustomWidget.getBoxAndLabelWidget().getAddressTextArea().setSize("200", "60");
		setWidget(11, 0, addressCustomWidget);
		
		AbsolutePanel absolutePanel_6 = new AbsolutePanel();
		setWidget(12, 0, absolutePanel_6);
		absolutePanel_6.setSize("50", "20");

		webSiteTextBox = new CustomTextBox("Website");
		setWidget(13, 0, webSiteTextBox);
		webSiteTextBox.setWidth("200");

		absolutePanel_3 = new AbsolutePanel();
		setWidget(14, 0, absolutePanel_3);
		absolutePanel_3.setSize("50", "20");

		notesLabel = new Label("Notes");
		setWidget(15, 0, notesLabel);

		notesTextArea = new TextArea();
		setWidget(16, 0, notesTextArea);
		notesTextArea.setSize("350", "76");

		absolutePanel_4 = new AbsolutePanel();
		setWidget(17, 0, absolutePanel_4);
		absolutePanel_4.setSize("50", "20");
		getFlexCellFormatter().setColSpan(11, 0, 2);
		getFlexCellFormatter().setColSpan(9, 0, 2);
		getFlexCellFormatter().setColSpan(5, 0, 2);
		getFlexCellFormatter().setColSpan(4, 0, 2);
		getCellFormatter().setHorizontalAlignment(4, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		getCellFormatter().setHorizontalAlignment(0, 1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		getFlexCellFormatter().setColSpan(16, 0, 2);
		getFlexCellFormatter().setColSpan(13, 0, 2);
		getFlexCellFormatter().setColSpan(7, 0, 2);
		getFlexCellFormatter().setColSpan(3, 0, 2);
		getCellFormatter().setVerticalAlignment(16, 0,
				HasVerticalAlignment.ALIGN_TOP);
		getCellFormatter().setVerticalAlignment(15, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		getCellFormatter().setVerticalAlignment(5, 0,
				HasVerticalAlignment.ALIGN_MIDDLE);
		getFlexCellFormatter().setColSpan(1, 0, 1);
		getCellFormatter().setVerticalAlignment(4, 0,
				HasVerticalAlignment.ALIGN_MIDDLE);
		getCellFormatter().setVerticalAlignment(3, 0,
				HasVerticalAlignment.ALIGN_MIDDLE);

	}

	public FlexibleCustomWidget getAddressCustomWidget() {
		return addressCustomWidget;
	}

	public Label getLastUpdatedLabel() {
		return lastUpdatedLabel;
	}

	public void setLastUpdatedLabel(Label lastUpdatedLabel) {
		this.lastUpdatedLabel = lastUpdatedLabel;
	}

	public FlexibleCustomWidget getEmailCustomWidget() {
		return emailCustomWidget;
	}

	public FlexibleCustomWidget getPhoneCustomWidget() {
		return phoneCustomWidget;
	}

	public void clear() {
		fullNameTextBox.clear();
		titleTextBox.clear();
		emailCustomWidget.clear();
		organizationTextBox.clear();
		phoneCustomWidget.clear();
		webSiteTextBox.clear();
		notesTextArea.setText("");
		addressCustomWidget.clear();
	}
}
