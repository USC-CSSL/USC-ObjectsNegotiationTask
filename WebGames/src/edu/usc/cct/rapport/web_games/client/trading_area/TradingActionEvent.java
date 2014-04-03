package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class TradingActionEvent extends GwtEvent<TradingActionEventHandler> {

	static final Type<TradingActionEventHandler> TYPE = new Type<TradingActionEventHandler>();


	final private TradingAction tradingAction;


	public TradingActionEvent(final TradingAction tradingAction) {
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<TradingActionEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final TradingActionEventHandler handler) {
//		handler.onTradingAction(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
