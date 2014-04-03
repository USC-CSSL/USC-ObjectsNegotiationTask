package edu.usc.cct.rapport.web_games.client.parting;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;

public class PartingActivity extends WebGamesActivity {

	final private IPartingView view;

	@Inject
	public PartingActivity(final EventBus eventBus, final PlaceController placeController, final IPartingPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.view = new PartingView(eventBus, placeController);
		bind();
	};


	private void bind() {
		// There is nothing to do here.
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
	};

};
