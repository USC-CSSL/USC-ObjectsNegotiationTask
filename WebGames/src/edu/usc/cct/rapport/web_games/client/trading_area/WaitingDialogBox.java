package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class WaitingDialogBox extends DialogBox {

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	@SuppressWarnings("unused")
	final private EventBus eventBus;
	
	public WaitingDialogBox(final EventBus eventBus, final String explanation, final int partnerLabel) {
		super(false, true);
		this.eventBus = eventBus;
		
//		setHTML(constants.waiting());
		setHTML(constants.blank());
			
		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
//		flexTable.setSize("250px", "100px");
		flexTable.setSize("800px", "565px");
		
		/*
//		Label lblWaiting = new Label(constants.waiting_msg());
		Label lblWaiting = new Label();
		
		if(explanation.equals("waitAfterRejection")) {
//			lblWaiting.setText("Please wait...");
			if(partnerLabel==0) {
				lblWaiting.setText(constants.waiting_msg_after_rejecting_computers_offer());
			} else if(partnerLabel==1) {
				lblWaiting.setText(constants.waiting_msg_after_rejecting_humans_offer());
			} else {
				lblWaiting.setText(constants.waiting_msg());
			}
		} else if(explanation.equals("coinTossing")) {
			lblWaiting.setText("Tossing a coin...");
		} else if(explanation.equals("waitBeforeOfferAcceptance")) {
			lblWaiting.setText(constants.waiting_msg_beforeOfferAcceptance());
		} else {
			if(partnerLabel==0) {
				lblWaiting.setText(constants.waiting_msg_computer());
			} else if(partnerLabel==1) {
				lblWaiting.setText(constants.waiting_msg_human());
			} else {
				lblWaiting.setText(constants.waiting_msg());
			}
		}
			

//		lblWaiting.setStylePrimaryName("BigLabel-style");
		lblWaiting.setStylePrimaryName("BiggerLabel-style");
		flexTable.setWidget(0, 0, lblWaiting);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(1, 0, loadingImage); // image
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);*/
		
		HTML waiting = new HTML("");

		
		if(explanation.equals("waitAfterRejection")) {
			if(partnerLabel==0) {
				waiting.setHTML(constants.waiting_msg_after_rejecting_computers_offer());
			} else if(partnerLabel==1) {
				waiting.setHTML(constants.waiting_msg_after_rejecting_humans_offer());
			} else {
				waiting.setHTML(constants.waiting_msg());
			}
		} else if(explanation.equals("waitBeforeOfferAcceptance")) {
			waiting.setHTML(constants.waiting_msg_beforeOfferAcceptance());
		} else {
			if(partnerLabel==0) {
				waiting.setHTML(constants.waiting_msg_computer());
			} else if(partnerLabel==1) {
				waiting.setHTML(constants.waiting_msg_human());
			} else {
				waiting.setHTML(constants.waiting_msg());
			}
		}
		
		flexTable.setWidget(0, 0, waiting);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		Image loadingImage = new Image();
		loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");
		flexTable.setWidget(1, 0, loadingImage); // image
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
	}
}
	

