package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class ComputeFacialExpressionAndIntensityAsPerAntosReport implements IComputeFacialExpressionAndIntensity {

	static final private int emotionValueBracketCount = 7;
	static final private int relativePowerCategoryCount = RelativePowerEnum.values().length;

	static final private FacialExpressionEnum[/*emotionValueBracketCount*/][/*relativePowerCategoryCount*/] facialExpressionTableLookup = {
		{FacialExpressionEnum.happy, FacialExpressionEnum.happy, FacialExpressionEnum.happy},
		{FacialExpressionEnum.happy, FacialExpressionEnum.happy, FacialExpressionEnum.happy},
		{FacialExpressionEnum.happy, FacialExpressionEnum.happy, FacialExpressionEnum.happy},
		{FacialExpressionEnum.neutral, FacialExpressionEnum.neutral, FacialExpressionEnum.neutral},
		{FacialExpressionEnum.angry, FacialExpressionEnum.angry, FacialExpressionEnum.sad},
		{FacialExpressionEnum.angry, FacialExpressionEnum.angry, FacialExpressionEnum.sad},
		{FacialExpressionEnum.angry, FacialExpressionEnum.angry, FacialExpressionEnum.sad},
	};

	static final private double[/*emotionValueBracketCount*/][/*relativePowerCategoryCount*/] facialExpressionIntensityTableLookup = {
		{1.0, 1.0, 1.0},
		{0.8, 0.7, 1.0},
		{0.6, 0.7, 0.8},
		{1.0, 1.0, 1.0},
		{0.6, 0.7, 0.6},
		{0.8, 0.7, 0.8},
		{1.0, 1.0, 1.0},
	};


	private int getEmotionValueBracket(final double emotionValue) {
	
		final int result;

		if (0.25 <= emotionValue) {
			result = 0;
		} else if (0.1 <= emotionValue) {
			result = 1;
		} else if (0.0 < emotionValue) {
			result = 2;
		} else if (0.0 <= emotionValue) {
			result = 3;
		} else if (-0.05 <= emotionValue) {
			result = 4;
		} else if (-0.15 <= emotionValue) {
			result = 5;
		} else {
			result = 6;
		};

		assert (0 <= result) && (result < emotionValueBracketCount);
		return result;
	};


	private int getRelativePowerOffset(final RelativePowerEnum relativePowerEnum) {
		final int result = relativePowerEnum.ordinal();
		assert (0 <= result) && (result < relativePowerCategoryCount);
		return result;
	};


	@Override
	public Pair<FacialExpressionEnum, Double> computeFacialExpressionAndIntensity(final double emotionValue, final RelativePowerEnum relativePowerEnum) {

		final int emotionValueIndex = getEmotionValueBracket(emotionValue);
		final int relativePowerIndex = getRelativePowerOffset(relativePowerEnum);
		final FacialExpressionEnum facialExpressionEnum = facialExpressionTableLookup[emotionValueIndex][relativePowerIndex];
		final Double facialExpressionIntensity = facialExpressionIntensityTableLookup[emotionValueIndex][relativePowerIndex];
		final Pair<FacialExpressionEnum, Double> result = new Pair<FacialExpressionEnum, Double>(facialExpressionEnum, facialExpressionIntensity);
		return result;
	};

};
