package edu.usc.cct.rapport.web_games.client.recording;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.usc.cct.rapport.web_games.client.trading_area.ExperimentInformationDS;

public interface IExperimentInformationRecordingServiceAsync {
	Request recordFinalExperimentInformation(final ExperimentInformationDS finalExperimentInformation, final AsyncCallback<Void> callback);
};
