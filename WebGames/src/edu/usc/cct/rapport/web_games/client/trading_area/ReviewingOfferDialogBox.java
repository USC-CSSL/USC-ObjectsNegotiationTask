package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ReviewingOfferDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public ReviewingOfferDialogBox(final EventBus eventBus) {
		super(false, true);
		this.eventBus = eventBus;

		setHTML(constants.reviewingOffer());
		
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("445px", "50px");
		
		Label lblWaiting = new Label(constants.reviewingOffer_msg());
		lblWaiting.setStylePrimaryName("BigLabel-style");
		flexTable.setWidget(0, 0, lblWaiting);		
		
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(1, 0, loadingImage); // image
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
	}
}
	

