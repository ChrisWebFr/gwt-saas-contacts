/**
 *  @project : Obnet20
 *  @author : myyk8505
 *  @date : 17 mars 2010
 *  $Id: ExtendedDialogBox.java,v 1.1 2010/10/04 14:52:51 cvsuser Exp $
 *  $LastChangedRevision$
 *  $LastChangedDate$
 *  $LastChangedBy$
 * 
 */
package com.logos.contacts.client.view.widget;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author myyk8505
 *
 */
public class ExtendedDialogBox extends DialogBox {
	
	private Label title;
	private Image close;
	
	private SimplePanel simplePanel;
	
	private HorizontalPanel pn;
	
	private VerticalPanel vp;
	
   public ExtendedDialogBox() {

	      // Set the dialog box's caption.
	   	title = new Label("Title");
	   	close = new Image("images/close.gif");
	   	close.addClickHandler(new ClickHandler() {
	   			public void onClick(ClickEvent event) {
					hide();
				}
			});
	   	
	   	pn = new HorizontalPanel();
	   	pn.add(title);
	   	pn.add(close);
	   	
	   	vp = new VerticalPanel();
	   	vp.add(pn);
	   	
	   	
    }

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.SimplePanel#add(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void add(Widget w) {
		if (null != vp && vp.getWidgetCount()>1){
			vp.remove(vp.getWidgetCount()-1);
		}
		vp.add(w);
		super.setWidget(vp);
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.SimplePanel#add(com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void setWidget(Widget w) {
		if (null != vp && vp.getWidgetCount()>1){
			vp.remove(vp.getWidgetCount()-1);
		}
		vp.add(w);
		super.setWidget(vp);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.DialogBox#hide()
	 */
	@Override
	public void hide() {
		System.out.println("ExtendedDialogBox.hide()");
		super.hide();
	}

	public void setTitle(String title)
	{
		this.title.setText(title);
	}
	
	public void setSize(int width,int height)
	{
		super.setWidth(width+"px");
		super.setHeight(height+"px");
	}

	public void setSimplePanel(SimplePanel simplePanel) {
		this.simplePanel = simplePanel;
	}

	public SimplePanel getSimplePanel() {
		return simplePanel;
	}
	
	
}
