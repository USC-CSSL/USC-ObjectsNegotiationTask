package edu.usc.cct.rapport.web_games.client.mvp_mapping;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.IWebGamesActivity;
import edu.usc.cct.rapport.web_games.client.IWebGamesPlace;
import edu.usc.cct.rapport.web_games.client.WebGamesPlace;
import edu.usc.cct.rapport.web_games.client.factory.WebGamesGinjector;
import edu.usc.cct.rapport.web_games.client.instructions.IInstructionsPlace;
import edu.usc.cct.rapport.web_games.client.instructions.InstructionsActivity;
import edu.usc.cct.rapport.web_games.client.language_selection.ISelectLanguagePlace;
import edu.usc.cct.rapport.web_games.client.language_selection.SelectLanguageActivity;
import edu.usc.cct.rapport.web_games.client.obtain_consent.IObtainConsentPlace;
import edu.usc.cct.rapport.web_games.client.obtain_consent.ObtainConsentActivity;
import edu.usc.cct.rapport.web_games.client.parting.IPartingPlace;
import edu.usc.cct.rapport.web_games.client.parting.PartingActivity;
//import edu.usc.cct.rapport.web_games.client.preGameQuestionnaire.IPreGameQuestionnairePlace;
//import edu.usc.cct.rapport.web_games.client.preGameQuestionnaire.PreGameQuestionnaireActivity;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ISpecifyExperimentConditionsPlace;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.SpecifyExperimentConditionsActivity;
import edu.usc.cct.rapport.web_games.client.testing.ITestingPlace;
import edu.usc.cct.rapport.web_games.client.testing.TestingActivity;
import edu.usc.cct.rapport.web_games.client.trading_area.ITradingAreaPlace;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaActivity;
import edu.usc.cct.rapport.web_games.client.url_provision.IURLProvisionPlace;
import edu.usc.cct.rapport.web_games.client.url_provision.URLProvisionActivity;

public class AppActivityMapper implements ActivityMapper {

	final private EventBus eventBus;
	final private PlaceController placeController;

	public AppActivityMapper(final WebGamesGinjector webGamesGinjector) {
		this.eventBus = webGamesGinjector.getEventBus();
		this.placeController = webGamesGinjector.getPlaceController();
	};


	@Inject
	public AppActivityMapper(final EventBus eventBus, final PlaceController placeController) {
		this.eventBus = eventBus;
		this.placeController = placeController;
	};


	@Override
	public IWebGamesActivity getActivity(final Place place) {
		if (false == place instanceof WebGamesPlace) {
			final IllegalStateException e = new IllegalStateException("Place |" + place.toString() + "| is not a |" + WebGamesPlace.class.getName() + "|.");
			throw e;
		};
		final IWebGamesPlace webGamesPlace = (IWebGamesPlace)place;

		GWT.log("WebGamesPlace called: |" + webGamesPlace + "|.");

		final IWebGamesActivity result;
		if (webGamesPlace instanceof ISpecifyExperimentConditionsPlace) {
			result = new SpecifyExperimentConditionsActivity(eventBus, placeController, (ISpecifyExperimentConditionsPlace)webGamesPlace);
		} else if (webGamesPlace instanceof ISelectLanguagePlace) {
			result = new SelectLanguageActivity(eventBus, placeController, (ISelectLanguagePlace)webGamesPlace);
		} else if (webGamesPlace instanceof IObtainConsentPlace) {
			result = new ObtainConsentActivity(eventBus, placeController, (IObtainConsentPlace)webGamesPlace);
		} else if (webGamesPlace instanceof IInstructionsPlace) {
			result = new InstructionsActivity(eventBus, placeController, (IInstructionsPlace)webGamesPlace);
		} else if (webGamesPlace instanceof ITradingAreaPlace) {
			result = new TradingAreaActivity(eventBus, placeController, (ITradingAreaPlace)webGamesPlace);
		} else if (webGamesPlace instanceof IPartingPlace) {
			result = new PartingActivity(eventBus, placeController, (IPartingPlace)webGamesPlace);
		} else if (webGamesPlace instanceof IURLProvisionPlace) {
			result = new URLProvisionActivity(eventBus, placeController, (IURLProvisionPlace)webGamesPlace);
		} else if (webGamesPlace instanceof ITestingPlace) {
			result = new TestingActivity(eventBus, placeController, (ITestingPlace)webGamesPlace);
		/*} else if (webGamesPlace instanceof IPreGameQuestionnairePlace) {
			result = new PreGameQuestionnaireActivity(eventBus, placeController, (IPreGameQuestionnairePlace)webGamesPlace);*/
		} else {
			final IllegalStateException e = new IllegalStateException("Unhandled place |" + place.toString() + "| in |" + WebGamesPlace.class.getName() + "|.getActivity().");
			throw e;			
		};

		return result;
	};

};
