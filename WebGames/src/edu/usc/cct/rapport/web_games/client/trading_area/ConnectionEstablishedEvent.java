package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ConnectionEstablishedEvent extends GwtEvent<ConnectionEstablishedEventHandler> {

	static final Type<ConnectionEstablishedEventHandler> TYPE = new Type<ConnectionEstablishedEventHandler>();


	final private TradingAction tradingAction;


	public ConnectionEstablishedEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.connectionEstablished == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ConnectionEstablishedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ConnectionEstablishedEventHandler handler) {
		handler.onConnectionEstablished(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
