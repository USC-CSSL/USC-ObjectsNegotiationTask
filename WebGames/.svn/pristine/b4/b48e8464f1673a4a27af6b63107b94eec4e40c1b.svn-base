package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingActionEnum;

public interface ProposalDecisionMakingTactic {

	/* Not all strategies will necessarily use the counterpart BATNA value, but some may choose to. */
	Pair<TradingActionEnum, Proposal> acceptProposalOrOfferCounterproposal(final NegotiationSession negotiationSession, final int counterpartBestAlternativeToNegotiatedActionValue);
};
