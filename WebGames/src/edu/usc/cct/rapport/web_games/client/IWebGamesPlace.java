package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.event.shared.EventBus;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecoder;


public interface IWebGamesPlace {

	public boolean equals(final Object otherObject);
	public int hashCode();
	public String toString();

	public String getPlaceName();
	public ExperimentConditionsDecoder getExperimentConditionsDecoder();
	public EventBus getEventBus();

};
