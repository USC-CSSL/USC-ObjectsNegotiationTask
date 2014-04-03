package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;

import com.google.gwt.core.client.Duration;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAction;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingActionEnum;

public class RationalProposalDecisionMakingStrategy implements ProposalDecisionMakingStrategy {

	final private ProposalDecisionMakingTactic tactic;


	public RationalProposalDecisionMakingStrategy(final ProposalDecisionMakingTactic tactic) {
		this.tactic = tactic;
	};


	@Override
	public TradingAction determineAction(final int counterpartBestAlternativeToNegotiatedActionValue, final NegotiationSession negotiationSession) {

		final Pair<TradingActionEnum, Proposal> action;

		final int plyRemaining = negotiationSession.getPlyRemaining();
		if (1 == plyRemaining) {
			if (negotiationSession.isEmpty()) {
				action = acceptOrClaimBATNAValue(null, counterpartBestAlternativeToNegotiatedActionValue);
			} else {
				final Proposal mostRecentlyReceivedProposal = negotiationSession.get(negotiationSession.size()-1).getProposal();
				action = acceptOrClaimBATNAValue(mostRecentlyReceivedProposal, counterpartBestAlternativeToNegotiatedActionValue);
			};
		} else {
			action = tactic.acceptProposalOrOfferCounterproposal(negotiationSession, counterpartBestAlternativeToNegotiatedActionValue);
		};

		final double timestamp = Duration.currentTimeMillis();
		final TradingAction result = new TradingAction(AgentEnum.counterpart, timestamp, action.getFirst(), action.getSecond());
		return result;
	};


	private Pair<TradingActionEnum, Proposal> acceptOrClaimBATNAValue(final Proposal proposalToAcceptOrReject, final int counterpartBestAlternativeToNegotiatedActionValue) {

		final int valueOfMostRecentlyReceivedProposal;
		if (proposalToAcceptOrReject == null) {
			valueOfMostRecentlyReceivedProposal = Integer.MIN_VALUE;
		} else {
			valueOfMostRecentlyReceivedProposal = proposalToAcceptOrReject.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
		};

		final Pair<TradingActionEnum, Proposal> result;
		if (valueOfMostRecentlyReceivedProposal >= counterpartBestAlternativeToNegotiatedActionValue) {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.acceptProposal, null);
		} else {
			result = new Pair<TradingActionEnum, Proposal>(TradingActionEnum.claimBATNAValue, null);
		};

		return result;
	};

};
