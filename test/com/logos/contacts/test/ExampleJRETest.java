package com.logos.contacts.test;

import com.google.gwt.event.shared.HandlerManager;
import com.logos.contacts.client.SharedContactsServiceAsync;
import com.logos.contacts.client.presenter.ContactsPresenter;
import com.logos.contacts.client.presenter.Display;
import com.logos.contacts.shared.Contact;

import java.util.ArrayList;
import junit.framework.TestCase;

import static org.easymock.EasyMock.createStrictMock;

public class ExampleJRETest extends TestCase {
  private ContactsPresenter contactsPresenter;
  private SharedContactsServiceAsync mockRpcService;
  private HandlerManager eventBus;
  private Display mockDisplay;
  
  protected void setUp() {
    mockRpcService = createStrictMock(SharedContactsServiceAsync.class);
    eventBus = new HandlerManager(null);
    mockDisplay = createStrictMock(Display.class);
    contactsPresenter = new ContactsPresenter(mockRpcService, eventBus, mockDisplay);
  }
  
  public void testContactSort() {
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
