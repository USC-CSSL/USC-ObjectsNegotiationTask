package edu.usc.cct.rapport.web_games.client.parting;

import java.util.Iterator;
import java.util.Random;
import java.math.BigInteger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentInternationalizationConstants;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentView;
import edu.usc.cct.rapport.web_games.client.obtain_consent.UserConsentsEvent;
import edu.usc.cct.rapport.web_games.client.obtain_consent.UserDoesNotConsentEvent;

public class PartingView extends WebGamesView implements IPartingView {

/*	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;
	static final private String largeFontSizeStyleName = "ict-rapport-largeFontSize";
	static final private SafeHtml separatingLineFeed = SafeHtmlUtils.fromSafeConstant("<br/>");
	
	final private PartingInternationalizationConstants constants = GWT.create(PartingInternationalizationConstants.class);

	@Inject
	public PartingView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);
		
		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();

		
		anchorPanel.add(viewBasePanel);

	//	final RichTextArea textAreaConsentInquiryText = new RichTextArea();
	//	textAreaConsentInquiryText.setHTML("Please click on the following link to complete the experiment:");
	//	textAreaConsentInquiryText.setHeight("100px");
	//	textAreaConsentInquiryText.setWidth("200px");
	
		//viewBasePanel.add(textAreaConsentInquiryText);
	
		//final Label departText = new Label("Please click on the following link to complete the experiment:");
		//final Label departText = new Label("Thank you for participating in our experiment. Please continue the questionnaire opened in the other window.");
		Random random = new Random();

		String uuid = new BigInteger(130, random).toString(32);

		//final Label departText = new Label("Please make sure to copy and paste the following completion code in the box provided on the next page:\n" + uuid) ;
		final Label departText = new Label("Please copy your completion code:\n\n b04rmoij0umhn");
		departText.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(departText);
			
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		final Label departTextt = new Label("Please return to the Qualtrics survey page from which you were directed, press the next button and enter your completion code.") ;
		departTextt.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(departTextt);
		
		
//		Button openWindow = new Button("Continue Experiment");
//		openWindow.addStyleName(largeFontSizeStyleName);
//		
//		openWindow.addClickHandler(new ClickHandler() {
//
//	        public void onClick(final ClickEvent clickEvent) {
//	        	String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
//	        	if (localName == "en")
//	        		//Window.open("https://usc.qualtrics.com/SE/?SID=SV_8w6VIY1oPigrrZq", "qualtrics", "resizable=yes,scrollbars=yes");
//	        		Window.open("https://usc.qualtrics.com/SE/?SID=SV_8w6VIY1oPigrrZq", "_blank", "");
//	        	if (localName == "fa")
//	        		Window.open("https://usc.qualtrics.com/SE/?SID=SV_8w6VIY1oPigrrZq", "_blank", null);
//	        }
//	    });
//	
//		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
//		
//		if(localName== "fa")
//			viewBasePanel.add(openWindow);
//		else
//			viewBasePanel.add(openWindow);
	    
			viewBasePanel.setVisible(true);
		initWidget(viewBasePanel);
	};


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
*/
	
	static final private String largeFontSizeStyleName = "ict-rapport-largeFontSize";

	final private SimpleLayoutPanel basePanel;

	final private PartingInternationalizationConstants constants = GWT.create(PartingInternationalizationConstants.class);


	@Inject
	public PartingView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		
		basePanel = new SimpleLayoutPanel();
		final Label partingLabel = new Label(constants.partingMessage());
		partingLabel.addStyleName(largeFontSizeStyleName);
		if (localName == "en"){
			Random random = new Random();
//			String uuid = UUID.randomUUID().toString();
			String uuid = new BigInteger(130, random).toString(32);
//			partingLabel.setText(constants.partingMessage() + "\nPlease make sure to copy and paste the following completion code in the box provided on the Mechanical Turk HIT page:\n" + uuid);
			//random.toString();
		}
		
		if (localName == "fa"){
			partingLabel.setText(constants.partingMessage(),Direction.RTL);
		}
		
		add(partingLabel);
		basePanel.setVisible(true);

		initWidget(basePanel);
	};


	@Override
	public void add(Widget w) {
		basePanel.add(w);
	};


	@Override
	public void clear() {
		basePanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = basePanel.iterator();
		return result;
	};


	@Override
	public boolean remove(Widget w) {
		final boolean result = basePanel.remove(w);
		return result;
	};

};
