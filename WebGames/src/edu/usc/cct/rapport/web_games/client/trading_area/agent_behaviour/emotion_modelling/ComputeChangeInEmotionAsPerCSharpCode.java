package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

public class ComputeChangeInEmotionAsPerCSharpCode implements IComputeChangeInEmotion {

	final private ComputeChangeInEmotionAsPerAntosReport computerOfAdjustmentBasedUponExpectationDeviationAndRelativePower;


	public ComputeChangeInEmotionAsPerCSharpCode() {
		this.computerOfAdjustmentBasedUponExpectationDeviationAndRelativePower = new ComputeChangeInEmotionAsPerAntosReport();
	};


	@Override
	public double computeChangeInEmotion(final double currentEmotionValue, final double expectationDeviation, final RelativePowerEnum relativePowerEnum) {
		final double adjustmentBasedUponExpectationDeviationAndRelativePower = this.computerOfAdjustmentBasedUponExpectationDeviationAndRelativePower.computeChangeInEmotion(currentEmotionValue, expectationDeviation, relativePowerEnum);
		final double adjustmentBasedUponFadingOfEmotionIntensityOverTime = currentEmotionValue * -0.1;
		final double result = adjustmentBasedUponFadingOfEmotionIntensityOverTime + adjustmentBasedUponExpectationDeviationAndRelativePower;
		return result;
	};

};
