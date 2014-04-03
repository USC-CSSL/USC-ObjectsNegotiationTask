package edu.usc.cct.rapport.web_games.client.factory;

import javax.inject.Inject;

import com.google.gwt.event.shared.EventBus;

import edu.usc.cct.rapport.web_games.client.WebGamesPlace;
import edu.usc.cct.rapport.web_games.client.instructions.InstructionsPlace;
import edu.usc.cct.rapport.web_games.client.language_selection.SelectLanguagePlace;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentPlace;
import edu.usc.cct.rapport.web_games.client.parting.PartingPlace;
//import edu.usc.cct.rapport.web_games.client.preGameQuestionnaire.PreGameQuestionnairePlace;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.SpecifyExperimentConditionsPlace;
import edu.usc.cct.rapport.web_games.client.testing.TestingPlace;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaPlace;
import edu.usc.cct.rapport.web_games.client.url_provision.URLProvisionPlace;

public class WebGamesPlaceFactory implements IWebGamesPlaceFactory {

	final private EventBus eventBus;

	@Inject
	public WebGamesPlaceFactory(final EventBus eventBus) {
		this.eventBus = eventBus;
	};


	@Override
	public SelectLanguagePlace createLanguageSelectionPlace(final String token) {
		final SelectLanguagePlace result = new SelectLanguagePlace(eventBus, token);
		return result;
	};


	@Override
	public ObtainConsentPlace createObtainConsentPlace(final String token) {
		final ObtainConsentPlace result = new ObtainConsentPlace(eventBus, token);
		return result;
	};


	@Override
	public SpecifyExperimentConditionsPlace createSpecifyExperimentConditionsPlace(final String token) {
		final SpecifyExperimentConditionsPlace result = new SpecifyExperimentConditionsPlace(eventBus, token);
		return result;
	};


	@Override
	public URLProvisionPlace createURLProvisionPlace(final String token) {
		final URLProvisionPlace result = new URLProvisionPlace(eventBus, token);
		return result;
	};


	@Override
	public InstructionsPlace createInstructionsPlace(final String token) {
		final InstructionsPlace result = new InstructionsPlace(eventBus, token);
		return result;
	};


	@Override
	public TradingAreaPlace createTradingAreaPlace(final String token) {
		final TradingAreaPlace result = new TradingAreaPlace(eventBus, token);
		return result;
	};


	@Override
	public PartingPlace createPartingPlace(final String token) {
		final PartingPlace result = new PartingPlace(eventBus, Boolean.parseBoolean(token));
		return result;
	};


	@Override
	public TestingPlace createTestingPlace(final String token) {
		final TestingPlace result = new TestingPlace(eventBus, token);
		return result;
	};


	public WebGamesPlace getDefaultPlace() {
		final SpecifyExperimentConditionsPlace result = this.createSpecifyExperimentConditionsPlace(null);
		//final TestingPlace result = this.createTestingPlace(null);
		return result;
	};
	
/*
	@Override
	public PreGameQuestionnairePlace createPreGameQuestionnairePlace(final String token) {
		final PreGameQuestionnairePlace result = new PreGameQuestionnairePlace(eventBus, token);
		return result;
	};
*/
};
