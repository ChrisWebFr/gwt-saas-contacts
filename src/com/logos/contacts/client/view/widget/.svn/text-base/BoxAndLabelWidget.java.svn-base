package com.logos.contacts.client.view.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.logos.contacts.shared.ContactsConstants;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class BoxAndLabelWidget extends Composite implements ContactsConstants {
	private HorizontalPanel horizontalPanel;
	private ListBox selectionComboBox;
	private InlineHyperlink removeLink;
	private EmailTextBox emailTextBox;
	private CustomTextBox customTextBox;
	private TextArea addressTextArea;
	private final String _TYPE;

	public BoxAndLabelWidget(String type) {

		_TYPE = type;
		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSize("350", "");
		initWidget(horizontalPanel);

		if (type.equals(EMAIL_WIDGET_TYPE)) {

			emailTextBox = new EmailTextBox();
			horizontalPanel.add(emailTextBox);
			emailTextBox.setWidth("180");
		}
		if (type.equals(PHONE_WIDGET_TYPE)) {

			customTextBox = new CustomTextBox((String) null);
			horizontalPanel.add(customTextBox);
			customTextBox.setWidth("180");
		}
		if (type.equals(ADDRESS_WIDGET_TYPE)) {
			addressTextArea = new TextArea();
			horizontalPanel.add(addressTextArea);
			addressTextArea.setWidth("180");
		}

		selectionComboBox = new ListBox();
		selectionComboBox.setHeight("22");
		horizontalPanel.add(selectionComboBox);
		horizontalPanel.setCellVerticalAlignment(selectionComboBox,
				HasVerticalAlignment.ALIGN_MIDDLE);
		removeLink = new InlineHyperlink();
		removeLink.setText("supprimer");
		removeLink.setStyleName(HYPERLINK_STYLE);
		horizontalPanel.add(removeLink);
		horizontalPanel.setCellVerticalAlignment(removeLink,
				HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(removeLink,
				HasHorizontalAlignment.ALIGN_RIGHT);
		removeLink.setWidth("90px");
	}

	public TextArea getAddressTextArea() {
		return addressTextArea;
	}

	public String get_TYPE() {
		return _TYPE;
	}

	protected EmailTextBox getEmailTextBox() {
		return emailTextBox;
	}

	protected CustomTextBox getCustomTextBox() {
		return customTextBox;
	}

	protected void setCustomTextBox(CustomTextBox customTextBox) {
		this.customTextBox = customTextBox;
	}

	public ListBox getSelectionComboBox() {
		return selectionComboBox;
	}

	public InlineHyperlink getRemoveLink() {
		return removeLink;
	}

}
