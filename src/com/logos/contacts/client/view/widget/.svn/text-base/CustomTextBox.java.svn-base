package com.logos.contacts.client.view.widget;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.Widget;
import com.logos.contacts.shared.ContactsConstants;

/**
 * 
 * Custom styled textBox
 * 
 * @author cweber
 * 
 */
@SuppressWarnings("deprecation")
public class CustomTextBox extends AbstractCustomTextBox implements ContactsConstants {

	public CustomTextBox(String iText) {
		this.text = iText;
		setText(text);
		addFocusListener(new FocusListener() {

			@Override
			public void onLostFocus(Widget sender) {
				if (getText().trim().equals("")) {
					setText(text);
					setStyleName(TEXT_BOX_LABEL_STYLE);
				}

			}

			@Override
			public void onFocus(Widget sender) {
				if (getText().trim().equals(text))
					setText("");

			}
		});
		addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				removeStyleName(TEXT_BOX_LABEL_STYLE);

			}
		});
		setStyleName(TEXT_BOX_LABEL_STYLE);
		
	}

	public void clear() {
		setText(text);
	}
	
		
}
