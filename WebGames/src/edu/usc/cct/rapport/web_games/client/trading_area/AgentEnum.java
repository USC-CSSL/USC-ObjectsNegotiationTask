package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public enum AgentEnum {
//	system,
	counterpart,
	player;


	// This variable is lazy-initialized, because its initialization via GWT.create is valid client-side but illegal server-side.
	static private AgentEnumInternationalizationConstants constants = null;


	void initializeClientInternationalizationConstantsIfNecessary() {
		if (null == AgentEnum.constants) {
			AgentEnum.constants = GWT.create(AgentEnumInternationalizationConstants.class);
		};
	};


/*	String getDisplayName() {

		final String result;

		initializeClientInternationalizationConstantsIfNecessary();

		switch (this) {
		case counterpart:
			result = constants.counterpartDisplayName();
			break;
		case player:
			result = constants.playerDisplayName();
			break;
		default:
			throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getName()");			
		};

		return result;
	};*/
	
	
/*	String getDisplayName(final Integer expScenario) {

		final String result;

		initializeClientInternationalizationConstantsIfNecessary();

		switch (this) {
		case counterpart:
			if(expScenario == 1 || expScenario == 4)
				result = constants.republican_counterpartDisplayName();
			else if (expScenario == 2 || expScenario == 5)
				result = constants.democratic_counterpartDisplayName();
			else		
				result = constants.counterpartDisplayName();
			break;
		case player:
			result = constants.playerDisplayName();
			break;
		default:
			throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getName()");			
		};

		return result;
	};*/

	String getDisplayName(final Integer partnerLabel) {

		final String result;

		initializeClientInternationalizationConstantsIfNecessary();

		switch (this) {
		case counterpart:
			if(partnerLabel == 0) {
				result = constants.counterpartDisplayName_computerHTML();
//				result = constants.counterpartDisplayName_computer();
			} else if (partnerLabel == 1) {
				result = constants.counterpartDisplayName_humanHTML();
//				result = constants.counterpartDisplayName_human();
			} else {	
				result = constants.counterpartDisplayName();
			}
			break;
		case player:
			result = constants.playerDisplayNameHTML();
//			result = constants.playerDisplayName();
			break;
		default:
			throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getName()");			
		};

		return result;
	};

	String getValuationDescription(final ValuationCategoryEnum valuationCategoryEnum) {

		String result;

		initializeClientInternationalizationConstantsIfNecessary();

		switch (valuationCategoryEnum) {
/*		case bestAlternativeToNegotiatedAgreement:
			{
				switch (this) {
				case counterpart:
//					result = constants.counterpartBATNAValuationDescription();
					result = "";
					break;
				case player:
//					result = constants.playerBATNAValuationDescription();
					result = "";
					break;
				default:
					throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getValuationDescription()");
				};
			};
			break;*/
		case proposalAsDiagrammed:
			{
				switch (this) {
				case counterpart:
					result = constants.counterpartDiagrammedProposalValuationDescription();
					break;
				case player:
					result = constants.playerDiagrammedProposalValuationDescription();
					break;
				default:
					throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getValuationDescription().");
				};
			}
			break;
		default:
			throw new IllegalStateException("Unhandled ValuationCategoryEnum in AgentEnum.getValuationDescription().");
		};

		return result;
	};


	static int getTradingBoardRowIndex(final AgentEnum agentEnum) {

		final int result;

		if (null == agentEnum) {
			result = 1;
		} else {
			switch (agentEnum) {
			case counterpart:
				result = 0;
				break;
			case player:
				result = 2;
				break;
			default:
				throw new IllegalStateException("Unhandled AgentEnum in AgentEnum.getTradingBoardRowIndex(AgentEnum).");
			};
		};

		return result;
	};


	static AgentEnum getFromTradingBoardRowIndex(final int index) {

		final AgentEnum result;
		if (0 == index) {
			result = AgentEnum.counterpart;
		} else if (1 == index) {
			result = null;
		} else if (2 == index) {
			result = AgentEnum.player;
		} else {
			throw new IllegalArgumentException("Unhandled index value in AgentEnum.getFromTradingBoardRowIndex().");
		};

		return result;
	};


	static AgentEnum getOtherAgent(final AgentEnum agentEnum) {

		AgentEnum result = null;
		if (AgentEnum.player.equals(agentEnum)) {
			result = AgentEnum.counterpart;
		} else if (AgentEnum.counterpart.equals(agentEnum)) {
			result = AgentEnum.player;
		} else if (null == agentEnum) {
			throw new IllegalArgumentException("Unhandled agentEnum passed to AgentEnum.getOtherAgent().");
		};

		return result;
	};

};
