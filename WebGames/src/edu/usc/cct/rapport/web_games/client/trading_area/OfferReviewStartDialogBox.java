package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;


//public class OfferReviewStartDialogBox extends DialogBox implements ClickHandler {
public class OfferReviewStartDialogBox extends DialogBox {

	@SuppressWarnings("unused")
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);

	public OfferReviewStartDialogBox(final EventBus eventBus, final int partnerLabel, final TradingAction tradingAction) {
		super(false, true);
		this.eventBus = eventBus;
		
//		String titleDiscription = constants.help_Window_Title();
//		this.setText(titleDiscription);
//		setHTML(constants.help_Window_Title());
		setHTML(constants.blank());

		String okButtonString = constants.ok_button();
//		final Button okButton = new Button(okButtonString, this);
		final Button okButton = new Button(okButtonString);
		okButton.setSize("200px", "50px");
		okButton.setStylePrimaryName("MiddleButton-style");
		
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double timestamp = Duration.currentTimeMillis();
		    	tradingAction.setTimestamp(timestamp);
				okButton.setEnabled(false);
				eventBus.fireEvent(new ProposalMadeEvent(tradingAction));
				hide();
			}
		});


				
/*		Label lblOfferReviewStart = new Label("");

		if(partnerLabel==0)
			lblOfferReviewStart = new Label(constants.offer_review_start_computer());
		else if(partnerLabel==1)
			lblOfferReviewStart = new Label(constants.offer_review_start_human());
		else
			lblOfferReviewStart = new Label(constants.offer_review_start());*/
		
		HTML offerReviewStart = new HTML("");
		if(partnerLabel==0)
			offerReviewStart.setHTML(constants.offer_review_start_computer());
		else if(partnerLabel==1)
			offerReviewStart.setHTML(constants.offer_review_start_human());
		else
			offerReviewStart.setHTML(constants.offer_review_start());


		FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
//		flexTable.setSize("250px", "100px");
		flexTable.setSize("800px", "565px");
				
//		lblOfferReviewStart.setStylePrimaryName("BiggerLabel-style");
//		flexTable.setWidget(0, 0, lblOfferReviewStart);
		flexTable.setWidget(0, 0, offerReviewStart);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.setWidget(1, 0, okButton);
		flexTable.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
	};
	
/*	@Override
	public void onClick(final ClickEvent event) {
//		okButton.setEnabled(false);
		final double timestamp = Duration.currentTimeMillis();
		eventBus.fireEvent(new ProposalMadeEvent(tradingAction));

//		final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, TradingActionEnum.acceptProposal, null);
//		eventBus.fireEvent(new ProposalMadeEvent(newTradingAction));
		hide();
		
/*		Timer timer = new Timer() {
			public void run() {
				hide();
			}
		};
	    timer.schedule(1000); 		// 1sec delay  

	};*/
}
