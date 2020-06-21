/**
 * 
 */
package com.logos.contacts.client.view.widget;

import com.google.gwt.user.client.ui.TextBox;

/**
 * @author cweber
 * 
 *         This class redefines the behaviour of the TextBox
 * 
 */
public abstract class AbstractCustomTextBox extends TextBox {

	protected String text;

	public String getCustomText() {
		if (!super.getText().equals(text))
			return super.getText();
		return "";
	}

	public String getCustomValue() {
		if (!super.getText().equals(text))
			return super.getText();
		return "";
	}

	@Override
	/**
	 * Redirect getText to get a conditional Text <br>
	 * Because we have the label into it <br>
	 * We check if the value is different from the label
	 */
	public String getText() {
		return getCustomText();
	}

	@Override
	/**
	 * redirect fom HasValue interface to a custom getValue
	 */
	public String getValue() {
		return getCustomValue();
	}

	/**
	 * custom clear method
	 */
	public abstract void clear ();
	
}
