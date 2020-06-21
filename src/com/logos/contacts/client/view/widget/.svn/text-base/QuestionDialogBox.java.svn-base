package com.logos.contacts.client.view.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;

/**
 * Confirmation dialogBox
 * @author cweber
 *
 */
public class QuestionDialogBox extends DialogBox {
	
	private boolean isOK = false;

	public QuestionDialogBox () {
		setText("Confirmation");
		setGlassEnabled(true);
		setSize("220", "100");
		setAnimationEnabled(true);
		setModal(true);
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("220", "100");
		
		Label questionLabel = new Label("Are You sure you want to delete selected contact(s)?");
		questionLabel.setSize("100%", "100%");
		verticalPanel.add(questionLabel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("100%", "100%");
		
		Button okButton = new Button("New button");
		okButton.setText("OK");
		horizontalPanel.add(okButton);
		okButton.setSize("80", "30");
		horizontalPanel.setCellVerticalAlignment(okButton, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(okButton, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button cancelButton = new Button("New button");
		cancelButton.setText("Cancel");
		horizontalPanel.add(cancelButton);
		cancelButton.setSize("80", "30");
		horizontalPanel.setCellVerticalAlignment(cancelButton, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_CENTER);
		center();
		
		//events
		okButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				isOK = true;
				hide();
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				isOK = false;
				hide();
				
			}
		});
	}

	/**
	 * get the answer
	 * @return
	 */
	public boolean isOK () {
		return isOK ;
	}
}
