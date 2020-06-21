package com.logos.contacts.client.view.widget;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.Widget;
import com.logos.contacts.shared.ContactsConstants;

/**
 * Custom TextBox for emails
 * 
 * @author cweber
 * 
 */
@SuppressWarnings("deprecation")
public class EmailTextBox extends AbstractCustomTextBox implements ContactsConstants{
	

	public EmailTextBox() {
		this.text = "E-mail";
		this.setText("E-mail");
		this.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {

				validate();

			}
		});

		this.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				validate();

			}
		});

		this.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				validate();

			}
		});
		
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void onLostFocus(final Widget sender) {
				if (getText().trim().equals("")){
					setText("Email");
					setStyleName(TEXT_BOX_LABEL_STYLE);
				} else 
				removeStyleName(TEXT_BOX_INVALID_STYLE);
				
			}
			
			@Override
			public void onFocus(final Widget sender) {
				if (getText().trim().equals(text))
					setText("");
				
			}
		});
		setStyleName(TEXT_BOX_LABEL_STYLE);
	}

	/**
	 * Validates text matching email pattern
	 */
	private void validate() {
		boolean matchFound = getText().matches(".+@.+\\.[a-z]+");

		if (matchFound)
			removeStyleName(TEXT_BOX_INVALID_STYLE);
		else
			setStyleName(TEXT_BOX_INVALID_STYLE);

	}
	
	public void clear() {
		setText("E-mail");
	}
}
