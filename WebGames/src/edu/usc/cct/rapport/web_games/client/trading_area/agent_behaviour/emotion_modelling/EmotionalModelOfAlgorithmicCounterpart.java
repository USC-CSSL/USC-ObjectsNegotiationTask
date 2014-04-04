package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;
import edu.usc.cct.rapport.web_games.client.trading_area.Proposal;


public class EmotionalModelOfAlgorithmicCounterpart {

	final private EmotionModellingStrategy emotionModellingPolicy;

	final private int playerBATNA;
	final private int counterpartBATNA;
	final private RelativePowerEnum relativePowerEnum;

	final private NegotiationSession negotiationSession;

	private double emotionValue;
	private FacialExpressionEnum facialExpressionEnum;

	final EmotionModellingStrategyEnum emotionModellingPolicyEnum;

	public EmotionalModelOfAlgorithmicCounterpart(final double initialEmotionValue, final EmotionModellingStrategy emotionModellingPolicy, final NegotiationSession newlyInitializedNegotiationSession, final int playerBATNA, final int counterpartBATNA,final EmotionModellingStrategyEnum emotionModellingPolicyEnum) {

		if (false == newlyInitializedNegotiationSession.isEmpty()) {
			final IllegalArgumentException e = new IllegalArgumentException("The negotiation session must be fresh.");
			throw e;
		};

		this.playerBATNA = playerBATNA;
		this.counterpartBATNA = counterpartBATNA;
		this.negotiationSession = newlyInitializedNegotiationSession;
		this.emotionValue = initialEmotionValue;
		this.emotionModellingPolicy = emotionModellingPolicy;
		this.relativePowerEnum = this.emotionModellingPolicy.computeRelativePower(this.counterpartBATNA, this.playerBATNA);
		final Pair<FacialExpressionEnum, Double> initialFacialExpressionAndIntensity = this.emotionModellingPolicy.computeFacialExpressionAndIntensityDelegate.computeFacialExpressionAndIntensity(this.emotionValue, this.relativePowerEnum);
		this.facialExpressionEnum = this.emotionModellingPolicy.computeFlattenedFacialExpression(initialFacialExpressionAndIntensity);
		this.emotionModellingPolicyEnum = emotionModellingPolicyEnum;
	};


	public double getEmotionValue() {
		return emotionValue;
	};


	public FacialExpressionEnum getFacialExpressionEnum() {
		final FacialExpressionEnum result = FacialExpressionEnum.valueOf(this.facialExpressionEnum.name());
		return result;
	};


	public void update(final Proposal proposal) {
		if (proposal.getAgentWhoMadeProposal() == AgentEnum.player) {
			final double proposalUtilityAsPerceivedByAlgorithmicCounterpart = proposal.getProposalValueFromAgentPerspective(AgentEnum.counterpart);
			final NegotiationSession immediatelyPriorNegotiationSession = new NegotiationSession(this.negotiationSession, 1);
			final double proposalUtilityAnticipatedByAlgorithmicCounterpart = this.emotionModellingPolicy.computeAnticipatedProposalUtility(playerBATNA, counterpartBATNA, immediatelyPriorNegotiationSession);
			final double expectationDeviation = proposalUtilityAsPerceivedByAlgorithmicCounterpart - proposalUtilityAnticipatedByAlgorithmicCounterpart;
			final double changeInEmotion = this.emotionModellingPolicy.computeChangeInEmotion(emotionValue, expectationDeviation, relativePowerEnum);
			this.emotionValue = this.emotionValue + changeInEmotion;
			if (this.emotionModellingPolicyEnum.toString()== "everyOtherTurnSad" || this.emotionModellingPolicyEnum.toString()== "everyOtherTurnAngry" ||
					this.emotionModellingPolicyEnum.toString()== "after134Sad" || this.emotionModellingPolicyEnum.toString()== "after134Angry"){
				final Pair<FacialExpressionEnum, Double> facialExpressionAndIntensity = this.emotionModellingPolicy.computeFacialExpressionAndIntensity(immediatelyPriorNegotiationSession.getPlyRemaining(),relativePowerEnum);
				this.facialExpressionEnum = this.emotionModellingPolicy.computeFlattenedFacialExpression(facialExpressionAndIntensity);
			}
			else {
				final Pair<FacialExpressionEnum, Double> facialExpressionAndIntensity = this.emotionModellingPolicy.computeFacialExpressionAndIntensity(this.emotionValue, relativePowerEnum);
				this.facialExpressionEnum = this.emotionModellingPolicy.computeFlattenedFacialExpression(facialExpressionAndIntensity);};
			
			
		};
	};

};
