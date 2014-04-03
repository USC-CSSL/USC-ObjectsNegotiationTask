package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import edu.usc.cct.rapport.web_games.client.IWebGamesActivity;

interface ITradingAreaActivity extends IWebGamesActivity {

	public void bind();

	public void updateTradingArea(final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession);

	public void executeCounterpartTurnIfNecessary(final int playerBATNA, final int counterpartBATNA, final NegotiationSession negotiationSession);

	public void start(final AcceptsOneWidget container, final EventBus eventBus);

};
