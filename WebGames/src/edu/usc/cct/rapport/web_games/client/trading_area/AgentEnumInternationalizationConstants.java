package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.i18n.client.Constants;

public interface AgentEnumInternationalizationConstants extends Constants {

	@DefaultStringValue("[TRANSLATION MISSING] Counterpart's Name")
	String counterpartDisplayName();
	
	@DefaultStringValue("[TRANSLATION MISSING] Republican Party")
	String republican_counterpartDisplayName();

	@DefaultStringValue("[TRANSLATION MISSING] Democratic Party")
	String democratic_counterpartDisplayName();
	
	@DefaultStringValue("[TRANSLATION MISSING] Computer Partner")
	String counterpartDisplayName_computer();

	@DefaultStringValue("[TRANSLATION MISSING] Human Partner")
	String counterpartDisplayName_human();

	@DefaultStringValue("[TRANSLATION MISSING] Player's Name")
	String playerDisplayName();

	@DefaultStringValue("[TRANSLATION MISSING] If no agreement is reached, then your counterpart will earn")
	String counterpartBATNAValuationDescription();

	@DefaultStringValue("[TRANSLATION MISSING] If no agreement is reached, then you will earn")
	String playerBATNAValuationDescription();

	@DefaultStringValue("[TRANSLATION MISSING] The current proposal earns your counterpart")
	String counterpartDiagrammedProposalValuationDescription();

	@DefaultStringValue("[TRANSLATION MISSING] The current proposal earns you")
	String playerDiagrammedProposalValuationDescription();
};
