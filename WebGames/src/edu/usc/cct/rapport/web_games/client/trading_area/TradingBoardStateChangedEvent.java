package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class TradingBoardStateChangedEvent extends GwtEvent<TradingBoardStateChangedEventHandler> {

	static final Type<TradingBoardStateChangedEventHandler> TYPE = new Type<TradingBoardStateChangedEventHandler>();

	@Override
	public Type<TradingBoardStateChangedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final TradingBoardStateChangedEventHandler handler) {
		handler.onTradingBoardStateChange(this);
	};

};
