package edu.usc.cct.rapport.web_games.client.trading_area;


public interface ConnectionEstablishedEventHandler extends TradingActionEventHandler {

	void onConnectionEstablished(final ConnectionEstablishedEvent event);
};
