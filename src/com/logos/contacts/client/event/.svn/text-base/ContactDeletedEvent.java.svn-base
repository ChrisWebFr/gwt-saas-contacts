package com.logos.contacts.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ContactDeletedEvent extends GwtEvent<ContactDeletedEventHandler>{
  public static Type<ContactDeletedEventHandler> TYPE = new Type<ContactDeletedEventHandler>();
  
  private final boolean hasToDelete;
  
  public ContactDeletedEvent (boolean hasToDelete){
	  this.hasToDelete = hasToDelete;
  }
  
  public boolean hasToDelete () {
	  return hasToDelete;
  }
  
  @Override
  public Type<ContactDeletedEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ContactDeletedEventHandler handler) {
    handler.onContactDeleted(this);
  }
}
