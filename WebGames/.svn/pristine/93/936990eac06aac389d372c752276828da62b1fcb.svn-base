/*
package edu.usc.cct.rapport.web_games.client.presenter;

import java.util.LinkedList;
import java.util.Queue;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.Command;


public class WebGamesAsyncActivityProxy implements AsyncProxy<WebGamesActivity>, Activity {

	final protected EventBus eventBus;
	final protected PlaceController placeController;

//	final protected IBase64EncodingServiceAsync base64EncodingService;
//	final protected IBase64DecodingServiceAsync base64DecodingService;

	private boolean activityStarted;
	private boolean activityCancelled;
	private boolean activityStopped;

	private WebGamesActivity proxiedActivity;
	private Queue<Command> commandQueue;

	protected WebGamesAsyncActivityProxy(final boolean startActivityAsSoonAsPossible) {
		this.commandQueue = new LinkedList<Command>();
		if (startActivityAsSoonAsPossible) {
			ensureActivityStarted();
		};
	};


	private void ensureActivityStarted() {
		if (false == this.activityStarted) {
			if (false == this.activityCancelled) {
				this.activityStarted = true;
				runAsync();
			};
		};
	};


	final public String mayStop() {

		final String result;

		if (null == proxiedActivity) {
			result = null;
		} else {
			result = proxiedActivity.mayStop();
		};

		return result;
	};



	public WebGamesAsyncActivityProxy(final ClientFactory clientFactory) {
		this.activityCancelled = false;
		this.activityStopped = false;
		this.eventBus = clientFactory.getEventBus();
		this.placeController = clientFactory.getPlaceController();
//		this.base64EncodingService = clientFactory.getBase64EncodingService();
//		this.base64DecodingService = clientFactory.getBase64DecodingService();
	};


	@Override
	public String mayStop() {
		// Allow the activity to be stopped.
		return null;
	};


	@Override
	public void onCancel() {
		activityCancelled = true;
	};


	@Override
	public void onStop() {
		activityStopped = true;
	};


	public boolean activityCancelled() {
		return activityCancelled;
	};


	public boolean activityStopped() {
		return activityStopped;
	};

};
*/