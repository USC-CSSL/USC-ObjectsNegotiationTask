package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.usc.cct.rapport.web_games.client.factory.WebGamesGinjector;
import edu.usc.cct.rapport.web_games.client.factory.WebGamesGinjectorAccess;
import edu.usc.cct.rapport.web_games.client.factory.WebGamesPlaceFactory;
import edu.usc.cct.rapport.web_games.client.mvp_mapping.AppActivityMapper;
import edu.usc.cct.rapport.web_games.client.mvp_mapping.AppPlaceHistoryMapper;


public class WebGames implements EntryPoint {

	@Override
	public void onModuleLoad() {

	    GWT.setUncaughtExceptionHandler(new DisplayUncaughtExceptionsOnClient());

	    final WebGamesGinjector webGamesGinjector = new WebGamesGinjectorAccess().get();

	    final EventBus eventBus = webGamesGinjector.getEventBus();
		final PlaceController placeController = webGamesGinjector.getPlaceController();

		final ActivityMapper activityMapper = new AppActivityMapper(webGamesGinjector);
		final ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);

		final SimpleLayoutPanel simpleLayoutPanelBase = new SimpleLayoutPanel();
		activityManager.setDisplay(simpleLayoutPanelBase);

		final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		// TODO: finish.
//		final DeterBackingUpThroughPlaceHistoryHandler deterBackingUpHandler = new DeterBackingUpThroughPlaceHistoryHandler();
//		History.addValueChangeHandler(deterBackingUpHandler);
//		Window.addWindowClosingHandler(deterBackingUpHandler);

		final WebGamesPlace defaultPlace = new WebGamesPlaceFactory(eventBus).getDefaultPlace();
		historyHandler.register(placeController, eventBus, defaultPlace);

		final RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		rootLayoutPanel.add(simpleLayoutPanelBase);

		historyHandler.handleCurrentHistory();
	};

};
