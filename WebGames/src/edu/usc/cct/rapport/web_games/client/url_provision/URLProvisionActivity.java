package edu.usc.cct.rapport.web_games.client.url_provision;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;


public class URLProvisionActivity extends WebGamesActivity {

	final private IURLProvisionView view;

	private String encodedExperimentConditions;


	@Inject
	public URLProvisionActivity(final EventBus eventBus, final PlaceController placeController, final IURLProvisionPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.encodedExperimentConditions = this.webGamesPlace.getExperimentConditionsDecoder().getEncodedExperimentCondition();
		this.view = new URLProvisionView(this.resettableEventBus, this.placeController, this.encodedExperimentConditions);
		bind();
	};


	private void bind() {};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
