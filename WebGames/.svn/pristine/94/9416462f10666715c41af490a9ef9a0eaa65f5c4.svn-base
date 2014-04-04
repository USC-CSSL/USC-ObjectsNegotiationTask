package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecoder;


abstract public class WebGamesPlace extends Place implements IWebGamesPlace {

	final private String placeName;
	final private ExperimentConditionsDecoder experimentConditionsDecoder;
	final protected EventBus eventBus;


	@Inject
	protected WebGamesPlace(final EventBus eventBus, @Assisted final String placeName, @Assisted final String base64EncodedObject, final boolean stripLanguageFirst) {
		this.eventBus = eventBus;
		this.placeName = placeName;
		if (null == base64EncodedObject) {
			this.experimentConditionsDecoder = null;
		} else {
			this.experimentConditionsDecoder = new ExperimentConditionsDecoder(eventBus, base64EncodedObject, stripLanguageFirst);
		};
	};


	public String getPlaceName() {
		return this.placeName;
	};


	public ExperimentConditionsDecoder getExperimentConditionsDecoder() {
		return this.experimentConditionsDecoder;
	};


	public String getToken() {
		final String result;
		if (null == this.getExperimentConditionsDecoder()) {
			result = null;
		} else {
			result = this.getExperimentConditionsDecoder().getEncodedExperimentCondition();
		};
		return result;
	};


	public EventBus getEventBus() {
		return this.eventBus;
	};


	@Override
	public boolean equals(final Object otherObject) {

		if (this == otherObject) {
			return true;
		};

		if (null == otherObject) {
			return false;
		};

		if (getClass() != otherObject.getClass()) {
			return false;
		};

		final Place other = (Place)otherObject;

		if (this != other) {
			return false;
		};

		return true;
	};


	@Override
	public int hashCode() {
		return this.placeName.hashCode();
	};


	@Override
	public String toString() {
		final StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(this.getPlaceName());
		if (null != this.getExperimentConditionsDecoder()) {
			tokenBuilder.append(':');
			tokenBuilder.append(this.getExperimentConditionsDecoder().getEncodedExperimentCondition());
		};

		final String result = tokenBuilder.toString();
		return result;
	};

};
