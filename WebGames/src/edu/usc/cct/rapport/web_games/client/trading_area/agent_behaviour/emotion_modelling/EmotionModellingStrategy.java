package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.NegotiationSession;

public class EmotionModellingStrategy implements IComputeAnticipatedProposalUtility, IComputeChangeInEmotion, IComputeFacialExpressionAndIntensity {

	final IComputeAnticipatedProposalUtility computeAnticipatedProposalUtilityDelegate;
	final IComputeChangeInEmotion computeChangeInEmotionDelegate;
	final IComputeFacialExpressionAndIntensity computeFacialExpressionAndIntensityDelegate;


	public EmotionModellingStrategy(final IComputeAnticipatedProposalUtility computeAnticipatedProposalUtility, final IComputeChangeInEmotion computeChangeInEmotion, final IComputeFacialExpressionAndIntensity computeFacialExpressionAndIntensity) {
		this.computeAnticipatedProposalUtilityDelegate = computeAnticipatedProposalUtility;
		this.computeChangeInEmotionDelegate = computeChangeInEmotion;
		this.computeFacialExpressionAndIntensityDelegate = computeFacialExpressionAndIntensity;
	};


	@Override
	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum) {
		final Pair<FacialExpressionEnum, Double> result = this.computeFacialExpressionAndIntensityDelegate.computeFacialExpressionAndIntensity(emotionValue, relativePowerEnum);
		return result;
	};


	@Override
	public double computeChangeInEmotion(final double currentEmotionValue, final double expectationDeviation, final RelativePowerEnum relativePowerEnum) {
		final double result = this.computeChangeInEmotionDelegate.computeChangeInEmotion(currentEmotionValue, expectationDeviation, relativePowerEnum);
		return result;
	};


	@Override
	public double computeAnticipatedProposalUtility(final int playerBATNA, final int counterpartBATNA, final NegotiationSession negotiationSession) {
		final double result = this.computeAnticipatedProposalUtilityDelegate.computeAnticipatedProposalUtility(playerBATNA, counterpartBATNA, negotiationSession);
		return result;
	};


	// TODO: Consider hoisting this into an interface also.
	public RelativePowerEnum computeRelativePower(final int myBATNA, final int opponentBATNA) {

		final RelativePowerEnum result;

		// Implemented to match the C# code (exact BATNA equality required), not the Antos report (which refers to approximately equal BATNA).
		// Verified that this is desired behaviour with Morteza.

		if (myBATNA > opponentBATNA) {
			result = RelativePowerEnum.high;
		} else if (myBATNA < opponentBATNA) {
			result = RelativePowerEnum.low;
		} else {
			result = RelativePowerEnum.balanced;
		};

		return result;
	};


	// TODO: Consider hoisting this into an interface also.
	public FacialExpressionEnum computeFlattenedFacialExpression(final Pair<FacialExpressionEnum, Double> facialExpressionAndIntensity) {

		final FacialExpressionEnum result;

		// Implemented so as to accord with February 25, 2011 email correspondence between Dave and Morteza.
		switch (facialExpressionAndIntensity.getFirst()) {
		case happy:
		case content:
			if (facialExpressionAndIntensity.getSecond() >= 0.75) {
				result = FacialExpressionEnum.happy;
			} else {
				result = FacialExpressionEnum.content;
			};
			break;
		default:
			result = facialExpressionAndIntensity.getFirst();
		};

		return result;
	};

};
