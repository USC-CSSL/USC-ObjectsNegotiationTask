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
	
		viewBasePanel.add(textAreaConsentInquiryText);
		
		Button openWindow = new Button(constants.openInformationSheet());
		
		
		openWindow.addClickHandler(new ClickHandler() {

	        public void onClick(final ClickEvent clickEvent) {
	        	String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
	        	if (localName == "en")
	        		Window.open("http://shiraz.usc.edu/negotiation/forms/InformationSheetEnglish2016.pdf", "_blank", null);
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
			viewBasePanel.add(openWindow,190,470);
	    
	    
		final Button buttonUserConsents = new Button(constants.userConsents());
//		final Button buttonUserConsents = new Button("START");
		buttonUserConsents.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {

						ObtainConsentView.this.eventBus.fireEvent(new UserConsentsEvent());
			};
		});
		
		
		viewBasePanel.add(buttonUserConsents,128,520);
//		buttonUserConsents.setSize("500px", "100px");
//		buttonUserConsents.setStylePrimaryName("BigLabel-style");
//		viewBasePanel.add(buttonUserConsents, 100, 300);
		
//		FocusPanel focus = new FocusPanel();
		
//		viewBasePanel.addDomHandler(handler, KeyDownEvent.getType());
	//	focus.addDomHandler(new KeyDownHandler() {
//		anchorPanel.addDomHandler(new KeyDownHandler() {*/ // 07/05/2016: Commented out. This is for MTurk experiment.
		Event.addNativePreviewHandler(new Event.NativePreviewHandler() { // for fMRI recording
			
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				// TODO Auto-generated method stub
				System.out.println("key: " + Integer.toString(event.getNativeEvent().getKeyCode()));
				if(event.getNativeEvent().getKeyCode() == 53)	
					ObtainConsentView.this.eventBus.fireEvent(new UserConsentsEvent());				
			}
		});	


/*		final Button buttonUserDoesNotConsent = new Button(constants.userDoesNotConsent());
		buttonUserDoesNotConsent.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
						ObtainConsentView.this.eventBus.fireEvent(new UserDoesNotConsentEvent());
			};
		});
		viewBasePanel.add(buttonUserDoesNotConsent,318,520);*/
		
		Label lbl = new Label("We will start shortly.");	// for fMRI recording
		lbl.setStyleName("BigLabel-style");
		viewBasePanel.add(lbl, 250, 300);

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
