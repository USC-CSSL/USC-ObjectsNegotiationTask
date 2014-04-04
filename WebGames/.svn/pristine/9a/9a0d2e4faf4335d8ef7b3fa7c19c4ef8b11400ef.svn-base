package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import java.util.Iterator;

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
	final private ExperimentConditions experimentConditions;


	public ExperimentConditionsEncoder(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		this.eventBus = eventBus;
		this.experimentConditions = experimentConditions;
		

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
		eventBus.fireEvent(newEvent);
	};

};
