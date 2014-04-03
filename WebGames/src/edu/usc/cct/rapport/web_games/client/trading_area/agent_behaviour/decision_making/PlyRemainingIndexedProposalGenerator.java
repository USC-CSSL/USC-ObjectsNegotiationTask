package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public interface PlyRemainingIndexedProposalGenerator {

	public Proposal getPrespecifiedPotentialCounterproposal(final EnumSet<TradingObjectEnum> setOfTradingObjectEnum, final int plyRemaining);
};
