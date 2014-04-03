package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.WebGamesPlace;

public class SpecifyExperimentConditionsPlace extends WebGamesPlace implements ISpecifyExperimentConditionsPlace {

	static final String placeName = "specifyExperimentConditions";

	@Inject
	public SpecifyExperimentConditionsPlace(final EventBus eventBus, @Assisted final String token) {
		super(eventBus, placeName, token, false);
	};

};
