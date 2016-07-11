package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class EndWaitingForAgentsOfferAcceptanceEvent extends GwtEvent<EndWaitingForAgentsOfferAcceptanceEventHandler> {

	static final Type<EndWaitingForAgentsOfferAcceptanceEventHandler> TYPE = new Type<EndWaitingForAgentsOfferAcceptanceEventHandler>();


	final private TradingAction tradingAction;


	public EndWaitingForAgentsOfferAcceptanceEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.endWaitingForAgentsOfferAcceptance == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<EndWaitingForAgentsOfferAcceptanceEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final EndWaitingForAgentsOfferAcceptanceEventHandler handler) {
		handler.onEndWaitingForAgentsOfferAcceptance(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
