package edu.usc.cct.rapport.web_games.client.trading_area;


public interface ProposalRejectedEventHandler extends TradingActionEventHandler {

	void onProposalRejection(final ProposalRejectedEvent event);
};
