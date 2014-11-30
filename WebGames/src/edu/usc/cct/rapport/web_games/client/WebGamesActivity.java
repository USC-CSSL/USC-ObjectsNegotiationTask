package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.ResettableEventBus;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;


abstract public class WebGamesActivity implements IWebGamesActivity {

	final protected ResettableEventBus resettableEventBus;
	final protected PlaceController placeController;
	final protected IWebGamesPlace webGamesPlace;

	private boolean activityCancelled;
	private boolean activityStopped;


	@Inject
	public WebGamesActivity(final EventBus eventBus, final PlaceController placeController, final IWebGamesPlace webGamesPlace) {
		this.resettableEventBus = new ResettableEventBus(eventBus);
		this.placeController = placeController;
		this.webGamesPlace = webGamesPlace;
		this.activityCancelled = false;
		this.activityStopped = false;
		this.setRootLayoutPanelSize();
	};


	protected void setRootLayoutPanelSize() {
		RootLayoutPanel.get().setPixelSize(800,600);
		RootLayoutPanel.get().setStylePrimaryName("Fixed-Position");
//		RootLayoutPanel.get().setPixelSize(850,600);
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
		resettableEventBus.removeHandlers();
	};


	public boolean activityCancelled() {
		return activityCancelled;
	};


	public boolean activityStopped() {
		return activityStopped;
	};


	protected void goTo(final WebGamesPlace newPlace) {
		try {
			placeController.goTo(newPlace);
		} catch (final UmbrellaException e) {
			if ((e.getCauses().size() == 1) && (e.getCause() instanceof JavaScriptException) && (e.getCause().getMessage().equals("Access is denied.\r\n"))) {
				/* The use of Internet Explorer 8 and 9 cause this error to occur.  However, when
				 * the exception is suppressed in this manner, the application appears to continue
				 * to execute normally, when running against a deployed .war file.  Unfortunately,
				 * under debug (development) mode, execution does not continue.
				 * 
				 * It is possible that replacing the PlaceHistoryMapper with a custom one will solve this issue.
				 */
				// The next line is simply a placeholder for a debugging breakpoint.
				for (int i = 0; i != 1; ++i) {};
			};
		};
	};

};
