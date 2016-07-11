package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ShowAgentsOfferAcceptanceResultEvent extends GwtEvent<ShowAgentsOfferAcceptanceResultEventHandler> {

	static final Type<ShowAgentsOfferAcceptanceResultEventHandler> TYPE = new Type<ShowAgentsOfferAcceptanceResultEventHandler>();


	final private TradingAction tradingAction;


	public ShowAgentsOfferAcceptanceResultEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.showAgentsOfferAcceptanceResult == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ShowAgentsOfferAcceptanceResultEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ShowAgentsOfferAcceptanceResultEventHandler handler) {
		handler.onShowAgentsOfferAcceptanceResult(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
