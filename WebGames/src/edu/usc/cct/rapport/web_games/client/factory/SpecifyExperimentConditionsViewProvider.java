package edu.usc.cct.rapport.web_games.client.factory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.SpecifyExperimentConditionsView;

public class SpecifyExperimentConditionsViewProvider implements Provider<SpecifyExperimentConditionsView> {

	final private EventBus eventBus;
	final private PlaceController placeController;


	@Inject
	public SpecifyExperimentConditionsViewProvider(final EventBus eventBus, final PlaceController placeController) {
		this.eventBus = eventBus;
		this.placeController = placeController;
	};


	@Override
	public SpecifyExperimentConditionsView get() {
		final SpecifyExperimentConditionsView result = new SpecifyExperimentConditionsView(eventBus, placeController);
		return result;
	};

};
