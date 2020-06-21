package com.logos.contacts.client.view.widget;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;

public class CustomPushButton extends PushButton {

	public static int ADD_CONTACT_STYLE = 0;
	public static int DELETE_STYLE = 1;
	public static int ADD_ROW_STYLE = 2;

	/**
	 * Initializes button with the appropriate image
	 * 
	 * @param style
	 * <br>
	 *            ADD_STYLE <br>
	 *            DELETE_STYLE
	 */
	public CustomPushButton(final int style) {

		if (style == ADD_CONTACT_STYLE)
			getUpFace().setImage(new Image("images/AddContactIcon.png"));
		if (style == DELETE_STYLE)
			getUpFace().setImage(new Image("images/DeleteIcon.png"));
		if (style == ADD_ROW_STYLE)
			getUpFace().setImage(new Image("images/ajouter.gif"));
		setSize("18px", "18px");
	}
}
