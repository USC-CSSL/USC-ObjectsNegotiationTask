package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import java.util.EnumSet;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingActionEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;

public class PrespecifiedPotentialCounterproposalTactic implements ProposalDecisionMakingTactic {

	final private PlyRemainingIndexedProposalGenerator proposalGenerator;
	final private int plyAdjustmentOffset;


	PrespecifiedPotentialCounterproposalTactic(final PlyRemainingIndexedProposalGenerator proposalGenerator, final int plyAdjustmentOffset) {
		this.proposalGenerator = proposalGenerator;
		this.plyAdjustmentOffset = plyAdjustmentOffset;
	};


	public Pair<TradingActionEnum, Proposal> acceptProposalOrOfferCounterproposal(final NegotiationSession negotiationSession, final int counterpartBestAlternativeToNegotiatedActionValue) {

		final EnumSet<TradingObjectEnum> setOfTradingObjectEnum = negotiationSession.getTradingObjectSetEnum().getSetOfTradingObjectEnum();
		final Proposal potentialCounterproposal = proposalGenerator.getPrespecifiedPotentialCounterproposal(setOfTradingObjectEnum, negotiationSession.getPlyRemaining() + plyAdjustmentOffset);
		final int valueOfPotentialCounterproposal = potentialCounterproposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
		final Proposal mostRecentlyOfferedProposal = negotiationSession.getMostRecentProposal();
/*		final int valueOfMostRecentlyOfferedProposal;
		if (null == mostRecentlyOfferedProposal) {
			valueOfMostRecentlyOfferedProposal = Integer.MIN_VALUE;
		} else {
			valueOfMostRecentlyOfferedProposal = mostRecentlyOfferedProposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
		};

		final Pair<TradingActionEnum, Proposal> result;
		if (valueOfMostRecentlyOfferedProposal >= valueOfPotentialCounterproposal) {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.acceptProposal, null);
		} else {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.makeCounterproposal, potentialCounterproposal);
		};*/
		
		final int valueOfMostRecentlyOfferedProposalForAgent;
		final int valueOfMostRecentlyOfferedProposalForPlayer;
		
		if (null == mostRecentlyOfferedProposal) {
			valueOfMostRecentlyOfferedProposalForAgent = Integer.MIN_VALUE;
			valueOfMostRecentlyOfferedProposalForPlayer = 0;
		} else {
			valueOfMostRecentlyOfferedProposalForAgent  = mostRecentlyOfferedProposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
			valueOfMostRecentlyOfferedProposalForPlayer = mostRecentlyOfferedProposal.getProposalValueFromAgentPerspective(AgentEnum.player);
		};

		final Pair<TradingActionEnum, Proposal> result;
		if ((valueOfMostRecentlyOfferedProposalForAgent - valueOfMostRecentlyOfferedProposalForPlayer) > 15) {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.acceptProposal, null);
		} else {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.makeCounterproposal, potentialCounterproposal);
		};

		return result;
	};

};
