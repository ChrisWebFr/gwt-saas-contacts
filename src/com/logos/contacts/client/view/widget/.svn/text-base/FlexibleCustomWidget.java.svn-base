package com.logos.contacts.client.view.widget;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.logos.contacts.shared.ComplexField;
import com.logos.contacts.shared.ContactsConstants;
import com.logos.contacts.shared.ContactsParameters;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class FlexibleCustomWidget extends VerticalPanel implements
		ContactsConstants {
	private Label titleLabel;
	private InlineHyperlink addLink;
	private final String _TYPE;
	private final String _TITLE;
	private List<ComplexField> content = null;
	private BoxAndLabelWidget firstWidget = null;

	public FlexibleCustomWidget(String title, String type) {
		_TYPE = type;
		_TITLE = title;
		setSize("400px", "51px");
		createDefaultWidget(title, type);
		content = new Vector<ComplexField>();
	}

	@SuppressWarnings("deprecation")
	synchronized BoxAndLabelWidget addRow() {
		BoxAndLabelWidget boxAndLabelWidget = new BoxAndLabelWidget(_TYPE);
		boxAndLabelWidget.getRemoveLink().addClickHandler(
				new ClickHandler() {
					public void onClick(final ClickEvent event) {
						deleteRow(event);
					}
				});
		//fill comboBox
		if (_TYPE.equals(EMAIL_WIDGET_TYPE) || _TYPE.equals(ADDRESS_WIDGET_TYPE)) {
			Vector<String> v = new Vector<String>(ContactsParameters
					.getInstance().getEmailOrAddressParameters());
			for (int i = 0; i < v.size(); i++)
				boxAndLabelWidget.getSelectionComboBox().addItem(v.get(i));
		}
		if (_TYPE.equals(PHONE_WIDGET_TYPE)){
			Vector<String> v = new Vector<String>(ContactsParameters
					.getInstance().getPhoneParameters());
			for (int i = 0; i < v.size(); i++)
				boxAndLabelWidget.getSelectionComboBox().addItem(v.get(i));
		}
		
		add(boxAndLabelWidget);
		return boxAndLabelWidget;
	}

	public void clear() {
		Iterator<Widget> it = iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		content.clear();
		createDefaultWidget(_TITLE, _TYPE);
	}

	@SuppressWarnings("deprecation")
	private void createDefaultWidget(String title, String type) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		add(horizontalPanel);
		horizontalPanel.setWidth("40");

		titleLabel = new Label(_TITLE);
		horizontalPanel.add(titleLabel);
		titleLabel.setWidth("60");
		horizontalPanel.setCellVerticalAlignment(titleLabel,
				HasVerticalAlignment.ALIGN_MIDDLE);

		addLink = new InlineHyperlink();
		addLink.setText("ajouter");
		addLink.setStyleName(HYPERLINK_STYLE);
		addLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addRow();
			}
		});
		horizontalPanel.add(addLink);
		horizontalPanel.setCellVerticalAlignment(addLink, HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel.setCellHorizontalAlignment(addLink, HasHorizontalAlignment.ALIGN_RIGHT);
		addLink.setWidth("100px");
		firstWidget = addRow();
	}
	
	synchronized void deleteRow(ClickEvent event) {
		// count the number of BoxAndLabel rows in the widgets
		Iterator<Widget> it = iterator();
		int i = 0;
		while (it.hasNext()) {
			if (it.next() instanceof BoxAndLabelWidget) {
				i++;
			}

		}
		// if more than one we delete otherwise we keep always 1 line at least
		if (i > 1)
			((InlineHyperlink) event.getSource()).getParent().getParent()
					.removeFromParent();
	}

	public BoxAndLabelWidget getBoxAndLabelWidget(){
		Iterator<Widget> it = iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof BoxAndLabelWidget) {
				return (BoxAndLabelWidget)o;
			}
		}
		return null;
	}

	public InlineHyperlink getAddLink (){
		return addLink;
	}

	/**
	 * return content of the Widget <br>
	 * Basically it has two parameters: the key or label, and the value
	 * 
	 * @return
	 */
	public List<ComplexField> getContent() {
		Iterator<Widget> it = iterator();
		while (it.hasNext()) {
			Object o = it.next();
			BoxAndLabelWidget w = null;
			String key = "";
			String value = "";
			if (o instanceof BoxAndLabelWidget) {
				w = (BoxAndLabelWidget) o;
				
				//we get the value of the corresponding custom textBox
				if (_TYPE.equals(EMAIL_WIDGET_TYPE))
					value = w.getEmailTextBox().getCustomText();
				if (_TYPE.equals(PHONE_WIDGET_TYPE))
					value = w.getCustomTextBox().getCustomText();
				if (_TYPE.equals(ADDRESS_WIDGET_TYPE))
					value = w.getAddressTextArea().getText();

				// if value not empty we continue
				if (!value.equals("")) {
					// if we have an email Type
					if (_TYPE.equals(EMAIL_WIDGET_TYPE)
							|| _TYPE.equals(ADDRESS_WIDGET_TYPE))
						// get the corresponding key by the selected value
						key = ContactsParameters.getInstance()
								.getEmailOrAddressTypeByLabel(
										w.getSelectionComboBox().getValue(
												w.getSelectionComboBox()
														.getSelectedIndex()));
					if (_TYPE.equals(PHONE_WIDGET_TYPE))
						key = ContactsParameters.getInstance()
								.getPhoneTypeByLabel(
										w.getSelectionComboBox().getValue(
												w.getSelectionComboBox()
														.getSelectedIndex()));

					// put int the content map
					content.add(new ComplexField(key, value));
				}
			}
		}
			
		return content;
	}
	
	public void setContent (List <ComplexField> iContent){
		fillWidget (iContent);
	}

	private void fillWidget(List<ComplexField> iContent) {
		clear();
		//first Widget to set set
		BoxAndLabelWidget currentWidget = firstWidget;
		for (int i = 0; i < iContent.size(); i++) {
			ComplexField item = iContent.get(i);
			if (_TYPE.equals(EMAIL_WIDGET_TYPE)) {
				currentWidget.getEmailTextBox().setText(item.getValue());
				String type = item.getType();
				currentWidget.getSelectionComboBox().setSelectedIndex(
						ContactsParameters.getInstance().getIndexOfEmailOrAddressType(
								type));
			}
			if (_TYPE.equals(PHONE_WIDGET_TYPE)) {
				currentWidget.getCustomTextBox().setText(item.getValue());
				String type = item.getType();
				currentWidget.getSelectionComboBox().setSelectedIndex(
						ContactsParameters.getInstance().getIndexOfPhoneType(
								type));
			}
			if (_TYPE.equals(ADDRESS_WIDGET_TYPE)) {
				currentWidget.getAddressTextArea().setText(item.getValue());
				String type = item.getType();
				currentWidget.getSelectionComboBox().setSelectedIndex(
						ContactsParameters.getInstance().getIndexOfEmailOrAddressType(
								type));
			}
			// next widget to be set
			if (i+1 < iContent.size())currentWidget = addRow();
		}
	}
}
