/**
 * Copyright 2010 University of Southern California.
 * All rights reserved.
 */
package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.i18n.client.Constants;

/**
 * @author <a href="mailto:gomboc@ict.usc.edu">Dave Gomboc</a>
 */
public interface TradingAreaInternationalizationConstants extends Constants {

	/* Payoff matrices. */

	@DefaultStringValue("[TRANSLATION MISSING] Counterpart's Payoff Matrix")
	String labelCounterpartsPayoffMatrix();

	@DefaultStringValue("[TRANSLATION MISSING] Player's Payoff Matrix")
	String labelPlayersPayoffMatrix();

	/* Post-negotiation dialog box. */

	@DefaultStringValue("[TRANSLATION MISSING] Negotiation Recap")
	String negotiationSummaryDialogBoxTitle();

	@DefaultStringValue("[TRANSLATION MISSING] Dismiss")
	String negotiationSummaryDialogBoxButtonLabel();

};
