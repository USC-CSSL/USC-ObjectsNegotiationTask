package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class FixedEmotionalReaction implements IComputeFacialExpressionAndIntensity {

	final FacialExpressionEnum facialExpressionEnum;
	final double intensity;

	final Pair<FacialExpressionEnum, Double> facialExpressionAndIntensity;


	public FixedEmotionalReaction(final FacialExpressionEnum constantFacialExpressionEnum) {

		this.facialExpressionEnum = FacialExpressionEnum.valueOf(constantFacialExpressionEnum.name());

		if (FacialExpressionEnum.content.equals(facialExpressionEnum)) {
			this.intensity = 0.7;
		} else {
			this.intensity = 1.0;
		};

		this.facialExpressionAndIntensity = new Pair<FacialExpressionEnum, Double>(facialExpressionEnum, intensity);
	};


	@Override
	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum) {
		final Pair<FacialExpressionEnum, Double> result = new Pair<FacialExpressionEnum, Double>(this.facialExpressionEnum, this.intensity);
		return result;
	};

};
