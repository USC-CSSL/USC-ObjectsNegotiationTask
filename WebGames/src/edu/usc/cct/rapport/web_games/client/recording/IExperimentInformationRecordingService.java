package edu.usc.cct.rapport.web_games.client.recording;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.usc.cct.rapport.web_games.client.trading_area.ExperimentInformationDS;

@RemoteServiceRelativePath("ExperimentInformationRecordingService")
public interface IExperimentInformationRecordingService extends RemoteService {
	public void recordFinalExperimentInformation(final ExperimentInformationDS finalExperimentInformation);
};
