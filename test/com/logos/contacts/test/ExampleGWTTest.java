package com.logos.contacts.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.junit.client.GWTTestCase;
import com.logos.contacts.client.SharedContactsService;
import com.logos.contacts.client.SharedContactsServiceAsync;
import com.logos.contacts.client.presenter.ContactsPresenter;
import com.logos.contacts.client.presenter.Display;
import com.logos.contacts.client.view.ContactsView;
import com.logos.contacts.shared.Contact;

import java.util.ArrayList;

public class ExampleGWTTest extends GWTTestCase {
  private ContactsPresenter contactsPresenter;
  private SharedContactsServiceAsync rpcService;
  private HandlerManager eventBus;
  private Display display;
  
  public String getModuleName() {
    return "com.google.gwt.sample.contacts.Contacts";
  }
  
  public void gwtSetUp() {
    rpcService = GWT.create(SharedContactsService.class);
    eventBus = new HandlerManager(null);
    display = new ContactsView();
    contactsPresenter = new ContactsPresenter(rpcService, eventBus, display);
  }
  
  public void testContactSort(){
    ArrayList<Contact> contactDetails = new ArrayList<Contact>();
    contactDetails.add(new Contact("0", "c_contact"));
    contactDetails.add(new Contact("1", "b_contact"));
    contactDetails.add(new Contact("2", "a_contact"));
    contactsPresenter.setContactDetails(contactDetails);
    contactsPresenter.sortContactDetails();
    assertTrue(contactsPresenter.getContactDetail(0).getLastName().equals("a_contact"));
    assertTrue(contactsPresenter.getContactDetail(1).getLastName().equals("b_contact"));
    assertTrue(contactsPresenter.getContactDetail(2).getLastName().equals("c_contact"));
  }
}
