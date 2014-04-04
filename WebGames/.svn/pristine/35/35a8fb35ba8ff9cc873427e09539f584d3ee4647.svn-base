package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAction;

public interface ProposalDecisionMakingStrategy {

	/**
	 * Given a proposal history, determines whether to accept the latest
	 * proposal, to take the BATNA score, or to offer a (specified)
	 * counterproposal.
	 */
	public TradingAction determineAction(final int valueOfBestAlternativeToNegotiatedAction, final NegotiationSession negotiationSession);

};
