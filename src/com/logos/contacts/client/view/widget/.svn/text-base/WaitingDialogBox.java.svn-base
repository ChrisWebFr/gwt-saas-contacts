package com.logos.contacts.client.view.widget;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class WaitingDialogBox extends DialogBox {
	
	public WaitingDialogBox(){
		setText("Please Wait...");
		setGlassEnabled(true);
		setSize("200", "90");
		setAnimationEnabled(true);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("200", "90");
		
		Image image = new Image("images/wait.gif");
		verticalPanel.add(image);
		verticalPanel.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
		image.setSize("", "");
		center();		
	}
	



}
