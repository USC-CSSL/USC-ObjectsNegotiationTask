package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class DecidingOfferAcceptanceEvent extends GwtEvent<DecidingOfferAcceptanceEventHandler> {

	static final Type<DecidingOfferAcceptanceEventHandler> TYPE = new Type<DecidingOfferAcceptanceEventHandler>();


	final private TradingAction tradingAction;


	public DecidingOfferAcceptanceEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.decidingOfferAcceptance == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<DecidingOfferAcceptanceEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final DecidingOfferAcceptanceEventHandler handler) {
		handler.onDecidingOfferAcceptance(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
