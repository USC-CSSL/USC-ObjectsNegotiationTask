package edu.usc.cct.rapport.web_games.client.language_selection;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEventHandler;


public class SelectLanguageActivity extends WebGamesActivity {

//	private boolean languageConfirmed = false;


	final private class RetrieveExperimentConditions implements ExperimentConditionsDecodedEventHandler {
		@Override
		public void onExperimentConditionsDecoded(final ExperimentConditionsDecodedEvent event) {
			SelectLanguageActivity.this.experimentConditions = event.getExperimentConditions();
//			final String language = SelectLanguageActivity.this.experimentConditions.getLanguage();
//			SelectLanguageActivity.this.view.focusLanguage(language);
		};
	};

/*
	final private class EncodeExperimentConditions implements LanguageSelectedEventHandler, LanguageConfirmedEventHandler {
		@Override
		public void onLanguageSelection(final LanguageSelectedEvent event) {
			SelectLanguageActivity.this.experimentConditions.setLanguage(event.getSelectedLanguage());
			@SuppressWarnings("unused") final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, SelectLanguageActivity.this.experimentConditions);
		};

		@Override
		public void onLanguageConfirmed(LanguageConfirmedEvent event) {
			SelectLanguageActivity.this.languageConfirmed = true;
			@SuppressWarnings("unused") final ExperimentConditionsEncoder encoder = new ExperimentConditionsEncoder(resettableEventBus, SelectLanguageActivity.this.experimentConditions);
		};
	};
*/

/*
	final private class GoToObtainConsentPlaceUponConfirmationButReloadThisPlaceOtherwise implements ExperimentConditionsEncodedEventHandler {
		@Override
		public void onExperimentConditionsEncoded(final ExperimentConditionsEncodedEvent event) {
			final String encodedExperimentConditions = event.getEncodedExperimentConditions();
			final WebGamesPlace newPlace;
			if (SelectLanguageActivity.this.languageConfirmed) {
				newPlace = new ObtainConsentPlace(resettableEventBus, encodedExperimentConditions);
			} else {
				newPlace = new SelectLanguagePlace(resettableEventBus, encodedExperimentConditions);
			};
			placeController.goTo(newPlace);
		};
	};
*/

	final private ISelectLanguageView view;

	final private String encodedExperimentConditions;
	@SuppressWarnings("unused") private ExperimentConditions experimentConditions;


	@Inject
	public SelectLanguageActivity(final EventBus eventBus, final PlaceController placeController, final ISelectLanguagePlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.experimentConditions = null;
		this.encodedExperimentConditions = this.webGamesPlace.getExperimentConditionsDecoder().getEncodedExperimentCondition();
		this.view = new SelectLanguageView(this.resettableEventBus, this.placeController, this.encodedExperimentConditions);
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
		resettableEventBus.addHandler(ExperimentConditionsDecodedEvent.TYPE, new RetrieveExperimentConditions());
//		resettableEventBus.addHandler(LanguageSelectedEvent.TYPE, new EncodeExperimentConditions());
//		resettableEventBus.addHandler(ExperimentConditionsEncodedEvent.TYPE, new GoToObtainConsentPlaceUponConfirmationButReloadThisPlaceOtherwise());
//		resettableEventBus.addHandler(LanguageConfirmedEvent.TYPE, new EncodeExperimentConditions());
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
