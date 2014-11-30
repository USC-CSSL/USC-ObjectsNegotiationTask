package edu.usc.cct.rapport.web_games.client.obtain_consent;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;

public class ObtainConsentView extends WebGamesView implements IObtainConsentView {

	
//	static final private String largeFontSizeStyleName = "ict-rapport-largeFontSize";

	final private SimpleLayoutPanel anchorPanel;
	final private AbsolutePanel viewBasePanel;
	
	final private ObtainConsentInternationalizationConstants constants = GWT.create(ObtainConsentInternationalizationConstants.class);



	@Inject
	public ObtainConsentView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);
		
		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new AbsolutePanel();

		anchorPanel.add(viewBasePanel);
		
//		if (Window.Navigator.getUserAgent().contains("Firefox")) {
			populate(eventBus, placeController);
/*		} else {
			final RichTextArea textAreaConsentInquiryText = new RichTextArea();
			textAreaConsentInquiryText.setHTML("Please use Firefox to participate in this experiment. Thank you.");
			textAreaConsentInquiryText.setHeight("40px");
			textAreaConsentInquiryText.setWidth("600px");
		
			viewBasePanel.add(textAreaConsentInquiryText);
		}*/
		
		viewBasePanel.setVisible(true);
		initWidget(viewBasePanel);
	};
	
	public void populate(final EventBus eventBus, final PlaceController placeController) {
		
/*		final RichTextArea textAreaConsentInquiryText = new RichTextArea();
		textAreaConsentInquiryText.setHTML(constants.textAreaConsentInquiry());
//		textAreaConsentInquiryText.setHTML("Please click the enter button below to proceed");
		textAreaConsentInquiryText.setHeight("460px");
		textAreaConsentInquiryText.setWidth("600px");
	
		viewBasePanel.add(textAreaConsentInquiryText);*/
		
/*		Button openWindow = new Button(constants.openInformationSheet());
		
		
		openWindow.addClickHandler(new ClickHandler() {

	        public void onClick(final ClickEvent clickEvent) {
	        	String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
	        	if (localName == "en")
	        		Window.open("http://shiraz.usc.edu/negotiation/forms/InformationSheetEnglish.pdf", "_blank", null);
	        	if (localName == "fa")
	        		Window.open("http://shiraz.usc.edu/negotiation/forms/InformationSheetFarsi.pdf", "_blank", null);
	        	if (localName == "ko")
	        		Window.open("http://shiraz.usc.edu/negotiation/forms/InformationSheetKorean.pdf", "_blank", null);
	        }
	    });
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		if(localName== "fa")
			viewBasePanel.add(openWindow,250,470);
		else
			viewBasePanel.add(openWindow,190,470);*/
	    
	    
//		final Button buttonUserConsents = new Button(constants.userConsents());
/*		final Button buttonUserConsents = new Button("START");
		buttonUserConsents.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {

						ObtainConsentView.this.eventBus.fireEvent(new UserConsentsEvent());
			};
		});
		
		
//		viewBasePanel.add(buttonUserConsents,128,520);
		buttonUserConsents.setSize("500px", "100px");
		buttonUserConsents.setStylePrimaryName("BigLabel-style");
		viewBasePanel.add(buttonUserConsents, 100, 300);*/

//		viewBasePanel.
		
//		FocusPanel focus = new FocusPanel();
		
//		viewBasePanel.addDomHandler(handler, KeyDownEvent.getType());
	//	focus.addDomHandler(new KeyDownHandler() {
//		anchorPanel.addDomHandler(new KeyDownHandler() {
		Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
			
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				// TODO Auto-generated method stub
				System.out.println("key: " + Integer.toString(event.getNativeEvent().getKeyCode()));
				if(event.getNativeEvent().getKeyCode() == 53)	
					ObtainConsentView.this.eventBus.fireEvent(new UserConsentsEvent());
//					Window.alert("Hello");
				
//				String Str = Integer.toString(event.getNativeEvent().getKeyCode());
//		        System.out.println("key: " + Str);

//				if(event.getNativeEvent().getKeyCode() == 60)
//					Window.alert("Hello");
//				Window.alert(Integer.toString(event.getNativeEvent().getKeyCode()));
				
			}
		});

/*		@Override
			public void onKeyDown(KeyDownEvent event) {
///*				if((int)event.getNativeKeyCode() == 5) {
//					ObtainConsentView.this.eventBus.fireEvent(new UserDoesNotConsentEvent());
				}
				String Str = Integer.toString(event.getNativeKeyCode());
				Window.alert(Str);
		        System.out.println("key: " + Str);
		        System.out.println("keypressed :"+ event.getNativeKeyCode());
			}
			
		}, KeyDownEvent.getType());
		
		
		
		public static void enableEnterSubmit(final FormPanel form){
			  Event.addNativePreviewHandler(new NativePreviewHandler(){
			    public void onPreviewNativeEvent(    NativePreviewEvent event){
			      if (!event.isCanceled() && event.getTypeInt() == Event.ONKEYDOWN) {
			        int keyCode=event.getNativeEvent().getKeyCode();
			        if (keyCode == KeyCodes.KEY_ENTER) {
			          form.submit();
			          event.cancel();
			        }
			      }
			    }
			  }
			);
			}*/
		
//		viewBasePanel.add(focus);
/*		viewBasePanel.addKeyDownHandler(new KeyDownHandler() {
		     @Override
		     public void onKeyDown(KeyDownEvent event) {
		        int code = event.getNativeKeyCode();
		        if (KeyCodes.KEY_UP == code) {
		           GWT.log("Bed goes up");
		        } else if (KeyCodes.KEY_DOWN == code) {
		           GWT.log("Bed goes down");
		        }
		     }
		  });*/
/*		nameField.addKeyDownHandler(new KeyDownHandler() {

		    @Override
		    public void onKeyDown(KeyDownEvent event) {
		        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
		            Window.alert("hello");
		        }

		    }

		});*/
/*
		final Button buttonUserDoesNotConsent = new Button(constants.userDoesNotConsent());
		buttonUserDoesNotConsent.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
						ObtainConsentView.this.eventBus.fireEvent(new UserDoesNotConsentEvent());
			};
		});
		viewBasePanel.add(buttonUserDoesNotConsent,318,520);*/
		Label lbl = new Label("We will start shortly.");
		lbl.setStyleName("BigLabel-style");
		viewBasePanel.add(lbl, 250, 300);;

//		viewBasePanel.setVisible(true);
//		initWidget(viewBasePanel);
	};
	
/*	@Override
	public void onKeyPress(KeyPressEvent event) {
	    int keyCode = event.getUnicodeCharCode();
	    if (keyCode == 0) {
	        // Probably Firefox
	        keyCode = event.getNativeEvent().getKeyCode();
	    }
	    if (keyCode == KeyCodes.KEY_ENTER) {
	        // Do something when Enter is pressed.
	    }
	}*/
	
/*	@Override
	private class SubmitListener extends KeyboardListenerAdapter {
		public void onKeyPress(Widget sender, char key, int mods) {
			if (KeyboardListener.KEY_ENTER == key)
				ObtainConsentView.this.eventBus.fireEvent(new UserConsentsEvent());
		}
	}*/


	@Override
	public void add(final Widget w) {
		viewBasePanel.add(w);
	};


	@Override
	public void clear() {
		viewBasePanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = viewBasePanel.iterator();
		return result;
	};


	@Override
	public boolean remove(final Widget w) {
		final boolean result = viewBasePanel.remove(w);
		return result;
	};

};
