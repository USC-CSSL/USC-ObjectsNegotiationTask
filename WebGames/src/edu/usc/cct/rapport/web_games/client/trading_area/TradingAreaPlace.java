package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.WebGamesPlace;

public class TradingAreaPlace extends WebGamesPlace implements ITradingAreaPlace {

	static final String placeName = "tradingArea";

	@Inject
	public TradingAreaPlace(final EventBus eventBus, @Assisted final String token) {
		super(eventBus, placeName, token, false);
	};

/*
	@Override
	public WebGamesActivity getActivity(final WebGamesGinjector webGamesGinjector) {
		final WebGamesActivity result = null;
		webGamesGinjector.setTradingAreaPlace(this);
		final WebGamesActivity result = webGamesGinjector.getTradingAreaActivity();
		return result;
	};
*/
};
