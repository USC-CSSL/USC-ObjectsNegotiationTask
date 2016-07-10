package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class EndWaitingForAgentsOfferReviewEvent extends GwtEvent<EndWaitingForAgentsOfferReviewEventHandler> {

	static final Type<EndWaitingForAgentsOfferReviewEventHandler> TYPE = new Type<EndWaitingForAgentsOfferReviewEventHandler>();


	final private TradingAction tradingAction;


	public EndWaitingForAgentsOfferReviewEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.endWaitingForAgentsOfferReview == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<EndWaitingForAgentsOfferReviewEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final EndWaitingForAgentsOfferReviewEventHandler handler) {
		handler.onEndWaitingForAgentsOfferReview(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
