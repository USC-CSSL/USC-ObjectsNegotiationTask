package edu.usc.cct.rapport.web_games.client.obtain_consent;

import com.google.gwt.core.client.Duration;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
//import edu.usc.cct.rapport.web_games.client.instructions.InstructionsPlace;
//import edu.usc.cct.rapport.web_games.client.instructions.InstructionsView;
//import edu.usc.cct.rapport.web_games.client.instructions.UserConfirmsInstructionsReadEvent;
import edu.usc.cct.rapport.web_games.client.parting.PartingPlace;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEventHandler;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncodedEventHandler;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncoder;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaPlace;


public class ObtainConsentActivity extends WebGamesActivity {
	int hack;
	
	final private class RetrieveExperimentConditions implements ExperimentConditionsDecodedEventHandler {
		@Override
		public void onExperimentConditionsDecoded(final ExperimentConditionsDecodedEvent event) {
			ObtainConsentActivity.this.experimentConditions = event.getExperimentConditions();

//			final double timestamp = Duration.currentTimeMillis();
//			ObtainConsentActivity.this.experimentConditions.setStartTimestamp(timestamp);
		//	hack=ObtainConsentActivity.this.experimentConditions.getExpScenario();
		};
	};
 

	final private class GoToInstructionsPlace implements ExperimentConditionsEncodedEventHandler {
		@Override
		public void onExperimentConditionsEncoded(final ExperimentConditionsEncodedEvent event) {
//		public void onExperimentConditionsEncoded(final ExperimentConditionsEncodedEvent event, final double timestamp) {
			final String encodedExperimentConditions = event.getEncodedExperimentConditions();
			//final InstructionsPlace newPlace = new InstructionsPlace(resettableEventBus, encodedExperimentConditions);
			final TradingAreaPlace newPlace = new TradingAreaPlace(resettableEventBus, encodedExperimentConditions);
//			final TradingAreaPlace newPlace = new TradingAreaPlace(resettableEventBus, encodedExperimentConditions, timestamp);
			goTo(newPlace);
		};
	};


	final private class EncodeExperimentConditions implements UserConsentsEventHandler {
		@Override
		public void onUserConsenting(final UserConsentsEvent event) {
			@SuppressWarnings("unused") 
//			final double timestamp = Duration.currentTimeMillis();
//			ObtainConsentActivity.this.experimentConditions.setStartTimestamp(timestamp);
			final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, ObtainConsentActivity.this.experimentConditions);
//			final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, ObtainConsentActivity.this.experimentConditions, timestamp);
		};
	};


	final private class GoToPartingPlace implements UserDoesNotConsentEventHandler {
		@Override
		public void onUserNotConsenting(final UserDoesNotConsentEvent event) {
			final PartingPlace newPlace = new PartingPlace(resettableEventBus, false);
			goTo(newPlace);
		};
	};


	final private IObtainConsentView view;

	private ExperimentConditions experimentConditions;


	public ObtainConsentActivity(final EventBus eventBus, final PlaceController placeController, final IObtainConsentPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
			this.view = new ObtainConsentView(eventBus, placeController);
		bind();
	};


	private void bind() {
		resettableEventBus.addHandler(ExperimentConditionsDecodedEvent.TYPE, new RetrieveExperimentConditions());
		resettableEventBus.addHandler(UserConsentsEvent.TYPE, new EncodeExperimentConditions());
		resettableEventBus.addHandler(ExperimentConditionsEncodedEvent.TYPE, new GoToInstructionsPlace());
		resettableEventBus.addHandler(UserDoesNotConsentEvent.TYPE, new GoToPartingPlace());
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
