/**
 * Copyright 2010 University of Southern California.
 * All rights reserved.
 */
package edu.usc.cct.rapport.web_games.client.obtain_consent;

import com.google.gwt.i18n.client.Constants;

/**
 * @author <a href="mailto:gomboc@ict.usc.edu">Dave Gomboc</a>
 */
public interface ObtainConsentInternationalizationConstants extends Constants {

	@DefaultStringValue("[TRANSLATION MISSING] Consent text is missing!")
	public String textAreaConsentInquiry();

	@DefaultStringValue("[TRANSLATION MISSING] I consent.")
	public String userConsents();

	@DefaultStringValue("[TRANSLATION MISSING] I do not consent.")
	public String userDoesNotConsent();
	
	@DefaultStringValue("[TRANSLATION MISSING] Open the Experiment Information Sheet.")
	public String openInformationSheet();

};
