package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import edu.usc.cct.rapport.web_games.client.recording.IExperimentInformationRecordingService;
import edu.usc.cct.rapport.web_games.client.recording.IExperimentInformationRecordingServiceAsync;

public class ExperimentInformationRecorder implements AsyncCallback<Void> {

	static final private IExperimentInformationRecordingServiceAsync recorder = (IExperimentInformationRecordingServiceAsync)GWT.create(IExperimentInformationRecordingService.class);

	@SuppressWarnings("unused") final private EventBus eventBus;
	final private ExperimentInformation experimentInformation;
	@SuppressWarnings("unused") private Request recordingRequest;


	@Inject
	public ExperimentInformationRecorder(final EventBus eventBus, @Assisted final ExperimentInformation experimentInformation) {
		this.eventBus = eventBus;
		this.experimentInformation = experimentInformation;
		final ExperimentInformationDS finalExperimentInformation = this.experimentInformation.generateDoublySerializable();
		this.recordingRequest = this.getRecorder().recordFinalExperimentInformation(finalExperimentInformation, this);
	};


	private IExperimentInformationRecordingServiceAsync getRecorder() {
		return recorder;
	};


	@Override
	public void onFailure(final Throwable caught) {
		//throw new RuntimeException(caught);
		final ExperimentInformationDS finalExperimentInformation = this.experimentInformation.generateDoublySerializable();
		this.recordingRequest = this.getRecorder().recordFinalExperimentInformation(finalExperimentInformation, this);
		
		Timer timer = new Timer() {
			public void run() {
				//this.recordingRequest = this.getRecorder().recordFinalExperimentInformation(finalExperimentInformation, this);
				//final LastRoundHelpWindowDialogBox dialogBox = new LastRoundHelpWindowDialogBox(eventBus, temp);
		    	 // dialogBox.center();
				assert(true);
				
		      }
		};
		timer.schedule(500);
	}
	

	@Override
	public void onSuccess(final Void dummyPlaceholder) {
		// There is not really anything to do here.
		assert(true);
	};

};
