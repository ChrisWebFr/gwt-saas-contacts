package com.logos.contacts.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface ContactUpdatedEventHandler extends EventHandler{
  void onContactUpdated(ContactUpdatedEvent event);
}
