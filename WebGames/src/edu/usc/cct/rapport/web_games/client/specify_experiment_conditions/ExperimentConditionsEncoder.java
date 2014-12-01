package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import java.util.Iterator;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.usc.cct.rapport.web_games.client.base64.IBase64EncodingService;
import edu.usc.cct.rapport.web_games.client.base64.IBase64EncodingServiceAsync;

public class ExperimentConditionsEncoder implements AsyncCallback<String> {

	static final private IBase64EncodingServiceAsync encoder = (IBase64EncodingServiceAsync)GWT.create(IBase64EncodingService.class);

	final private EventBus eventBus;
	@SuppressWarnings("unused") final private Request encodingRequest;
	//@SuppressWarnings("unused")
//	final private ExperimentConditions experimentConditions;
	private ExperimentConditions experimentConditions;
/*//	final private double timestamp;


//	public ExperimentConditionsEncoder(final EventBus eventBus, final ExperimentConditions experimentConditions) {
	public ExperimentConditionsEncoder(final EventBus eventBus, final ExperimentConditions experimentConditions, final double timestamp) {
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;
//		this.timestamp = timestamp;
		this.experimentConditions.setStartTimestamp(timestamp);

		String encodedstring = "";
		{
		final StringBuilder builder = new StringBuilder();

		final Iterator<String> iterator = this.experimentConditions.getObjectFieldData().iterator();
		assert (iterator.hasNext());

		builder.append(iterator.next());
		while (iterator.hasNext()) {
			builder.append("|");
			builder.append(iterator.next());
		};

		encodedstring = builder.toString();
		}

		encodingRequest = this.getEncoder().encode2(encodedstring, this);
		//encodingRequest = this.getEncoder().encode(this.experimentConditions, this);
	};*/
	
	public ExperimentConditionsEncoder(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;
		
//		double timestamp = Duration.currentTimeMillis();
//		this.experimentConditions.setStartTimestamp(timestamp);
//		this.experimentConditions.setStartTimestamp(30);
//		this.timestamp = Duration.currentTimeMillis();

		String encodedstring = "";
		{
		final StringBuilder builder = new StringBuilder();

		final Iterator<String> iterator = this.experimentConditions.getObjectFieldData().iterator();
		assert (iterator.hasNext());

		builder.append(iterator.next());
		while (iterator.hasNext()) {
			builder.append("|");
			builder.append(iterator.next());
		};

		encodedstring = builder.toString();
		}

		encodingRequest = this.getEncoder().encode2(encodedstring, this);
		//encodingRequest = this.getEncoder().encode(this.experimentConditions, this);
	};


	private IBase64EncodingServiceAsync getEncoder() {
		return encoder;
	};


	@Override
	public void onFailure(final Throwable caught) {
		throw new RuntimeException(caught);
	};


	@Override
	public void onSuccess(final String encodedExperimentConditions) {
		final ExperimentConditionsEncodedEvent newEvent = new ExperimentConditionsEncodedEvent(encodedExperimentConditions);
//		final ExperimentConditionsEncodedEvent newEvent = new ExperimentConditionsEncodedEvent(encodedExperimentConditions, timestamp);
		eventBus.fireEvent(newEvent);
	};

};
