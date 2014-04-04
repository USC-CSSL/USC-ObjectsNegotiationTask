package edu.usc.cct.rapport.web_games.client.testing;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.SpecifyExperimentConditionsPlace;

public class TestingActivity extends WebGamesActivity {

	final private ITestingView view;

	@Inject
	public TestingActivity(final EventBus eventBus, final PlaceController placeController, final ITestingPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.view = new TestingImageDisplayManagementView(resettableEventBus, placeController);
//		this.view = new TestingAgentFacialExpressionView(eventBus, placeController);
//		this.view = new TestingAgentFacialExpressionSelectionView(resettableEventBus, placeController);
		bind();
	};


	private void bind() {
		resettableEventBus.addHandler(TestingEvent.TYPE, new TestingEventHandler() {
			@Override
			public void onTestingEvent(final TestingEvent event) {
				view.setValuesRandomly();
			};
		});

		resettableEventBus.addHandler(TestingCompleteEvent.TYPE, new TestingCompleteEventHandler() {
			@Override
			public void onTestingCompleteEvent(final TestingCompleteEvent event) {
				goTo(new SpecifyExperimentConditionsPlace(resettableEventBus, null));
			};
		});
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(view.asWidget());
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

};
