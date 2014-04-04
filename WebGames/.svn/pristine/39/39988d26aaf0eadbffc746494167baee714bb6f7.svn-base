package edu.usc.cct.rapport.web_games.client.instructions;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEventHandler;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncodedEventHandler;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsEncoder;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingAreaPlace;

public class InstructionsActivity extends WebGamesActivity {

	//int hack;
	
	final private class RetrieveExperimentConditions implements ExperimentConditionsDecodedEventHandler {
		@Override
		public void onExperimentConditionsDecoded(final ExperimentConditionsDecodedEvent event) {
			InstructionsActivity.this.experimentConditions = event.getExperimentConditions();
		//	hack=event.getExperimentConditions().getExpScenario();
		};
	};


	final private class EncodeExperimentConditions implements UserConfirmsInstructionsReadEventHandler {
		@Override
		public void onUserConfirmationThatInstructionsRead(final UserConfirmsInstructionsReadEvent event) {
			@SuppressWarnings("unused") final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, InstructionsActivity.this.experimentConditions);
		};
	};


	final private class GoToTradingAreaPlace implements ExperimentConditionsEncodedEventHandler {
		@Override
		public void onExperimentConditionsEncoded(final ExperimentConditionsEncodedEvent event) {
			final String encodedExperimentConditions = event.getEncodedExperimentConditions();
			final TradingAreaPlace newPlace = new TradingAreaPlace(resettableEventBus, encodedExperimentConditions);
			goTo(newPlace);
		};
	};


	final private IInstructionsView view;

	private ExperimentConditions experimentConditions;


	@Inject
	public InstructionsActivity(final EventBus eventBus, final PlaceController placeController, final IInstructionsPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		//resettableEventBus.addHandler(ExperimentConditionsDecodedEvent.TYPE, new RetrieveExperimentConditions());
		//eventBus.fireEvent(new ExperimentConditionsDecodedEvent(experimentConditions));
		this.view = new InstructionsView(eventBus, placeController);
		
		
		bind();
	};


	private void bind() {
		resettableEventBus.addHandler(ExperimentConditionsDecodedEvent.TYPE, new RetrieveExperimentConditions());
		resettableEventBus.addHandler(UserConfirmsInstructionsReadEvent.TYPE, new EncodeExperimentConditions());
		resettableEventBus.addHandler(ExperimentConditionsEncodedEvent.TYPE, new GoToTradingAreaPlace());
		//resettableEventBus.addHandler(ExperimentConditionsEncodedEvent.TYPE, new GoToPreQuestionnairePlace());
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
