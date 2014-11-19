package edu.usc.cct.rapport.web_games.client.trading_area;

public enum ValuationCategoryEnum {
//	bestAlternativeToNegotiatedAgreement,
	proposalAsDiagrammed;


	public String getValuationDescription(final AgentEnum agentEnum) {
		final String result = agentEnum.getValuationDescription(this);
		return result;
	};

};
