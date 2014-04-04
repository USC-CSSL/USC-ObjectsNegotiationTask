package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
import edu.usc.cct.rapport.web_games.client.url_provision.URLProvisionPlace;

public class SpecifyExperimentConditionsActivity extends WebGamesActivity {

	final private class EncodeExperimentConditions implements ExperimentConditionsSpecifiedEventHandler {
		@Override
		public void onExperimentConditionsSpecified(final ExperimentConditionsSpecifiedEvent event) {
			final ExperimentConditions experimentConditions = event.getExperimentConditions();
			@SuppressWarnings("unused") final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, experimentConditions);
		};
	};


	final private class GoToURLProvisionPlace implements ExperimentConditionsEncodedEventHandler {
		@Override
		public void onExperimentConditionsEncoded(final ExperimentConditionsEncodedEvent event) {
			final String encodedExperimentConditions = event.getEncodedExperimentConditions();
			final URLProvisionPlace newPlace = new URLProvisionPlace(resettableEventBus, encodedExperimentConditions);
			goTo(newPlace);
		};
	};


	final private ISpecifyExperimentConditionsView view;

	public SpecifyExperimentConditionsActivity(final EventBus eventBus, final PlaceController placeController, final ISpecifyExperimentConditionsPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.view = new SpecifyExperimentConditionsView(this.resettableEventBus, this.placeController);
		bind();
	};


	@Override
	protected void setRootLayoutPanelSize() {
		int windowWidth = 800;
		if (Window.getClientWidth() > windowWidth) {
			windowWidth = Window.getClientWidth();
		};
		int windowHeight = 1600;
		if (Window.getClientHeight() > windowHeight) {
			windowHeight = Window.getClientHeight();
		};
		RootLayoutPanel.get().setPixelSize(windowWidth, windowHeight);
	};


	private void bind() {
		final EncodeExperimentConditions encodeExperimentConditions = new EncodeExperimentConditions();
		resettableEventBus.addHandler(ExperimentConditionsSpecifiedEvent.TYPE, encodeExperimentConditions);
		final GoToURLProvisionPlace goToObtainConsentActivity = new GoToURLProvisionPlace();
		resettableEventBus.addHandler(ExperimentConditionsEncodedEvent.TYPE, goToObtainConsentActivity);
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
