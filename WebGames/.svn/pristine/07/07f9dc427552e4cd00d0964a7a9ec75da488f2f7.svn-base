package edu.usc.cct.rapport.web_games.client.factory;

import edu.usc.cct.rapport.web_games.client.instructions.InstructionsPlace;
import edu.usc.cct.rapport.web_games.client.language_selection.SelectLanguagePlace;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentPlace;
import edu.usc.cct.rapport.web_games.client.parting.PartingPlace;
//import edu.usc.cct.rapport.web_games.client.preGameQuestionnaire.PreGameQuestionnairePlace;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.SpecifyExperimentConditionsPlace;
import edu.usc.cct.rapport.web_games.client.testing.TestingPlace;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaPlace;
import edu.usc.cct.rapport.web_games.client.url_provision.URLProvisionPlace;


public interface IWebGamesPlaceFactory {
	SpecifyExperimentConditionsPlace createSpecifyExperimentConditionsPlace(final String token);
	URLProvisionPlace createURLProvisionPlace(final String token);
	SelectLanguagePlace createLanguageSelectionPlace(final String token);
	ObtainConsentPlace createObtainConsentPlace(final String token);
	InstructionsPlace createInstructionsPlace(final String token);
//	PreGameQuestionnairePlace createPreGameQuestionnairePlace (final String token); 
	TradingAreaPlace createTradingAreaPlace(final String token);
	PartingPlace createPartingPlace(final String token);
	TestingPlace createTestingPlace(final String token);
};
