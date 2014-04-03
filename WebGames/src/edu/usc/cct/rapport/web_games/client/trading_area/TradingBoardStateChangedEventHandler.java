package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.EventHandler;

public interface TradingBoardStateChangedEventHandler extends EventHandler {

	void onTradingBoardStateChange(final TradingBoardStateChangedEvent event);

};
