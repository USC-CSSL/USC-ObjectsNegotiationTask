package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class FixedSadNeutralReactionEveryOtherTurn implements IComputeFacialExpressionAndIntensity {

	final FacialExpressionEnum facialExpressionEnum;
	final double intensity;

	final Pair<FacialExpressionEnum, Double> facialExpressionAndIntensity;
	
	public FixedSadNeutralReactionEveryOtherTurn(final FacialExpressionEnum constantFacialExpressionEnum) {
		
		this.facialExpressionEnum = FacialExpressionEnum.valueOf(constantFacialExpressionEnum.name());

		//junk
		this.intensity = 0.7;
		
		this.facialExpressionAndIntensity = new Pair<FacialExpressionEnum, Double>(facialExpressionEnum, intensity);
	};
	
	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum) {
		final FixedEmotionalReaction fixedEmotionalReaction;
		if (emotionValue % 4 == 1) {
			fixedEmotionalReaction = new FixedEmotionalReaction(FacialExpressionEnum.sad_neutral);
		}
		else {
		fixedEmotionalReaction = new FixedEmotionalReaction(FacialExpressionEnum.neutral); 
		};
		
		final Pair<FacialExpressionEnum, Double> result = fixedEmotionalReaction.computeFacialExpressionAndIntensity(emotionValue, relativePowerEnum);
		return result;
	};
};
