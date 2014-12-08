package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class EndProposalReviewEvent extends GwtEvent<EndProposalReviewEventHandler> {

	static final Type<EndProposalReviewEventHandler> TYPE = new Type<EndProposalReviewEventHandler>();


	final private TradingAction tradingAction;


	public EndProposalReviewEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.endProposalReview == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<EndProposalReviewEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final EndProposalReviewEventHandler handler) {
		handler.onEndProposalReview(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
