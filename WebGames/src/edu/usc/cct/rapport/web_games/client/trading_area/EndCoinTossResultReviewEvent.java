package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class EndCoinTossResultReviewEvent extends GwtEvent<EndCoinTossResultReviewEventHandler> {

	static final Type<EndCoinTossResultReviewEventHandler> TYPE = new Type<EndCoinTossResultReviewEventHandler>();


	final private TradingAction tradingAction;


	public EndCoinTossResultReviewEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.endCoinTossResultReview == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<EndCoinTossResultReviewEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final EndCoinTossResultReviewEventHandler handler) {
		handler.onEndCoinTossResultReview(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
