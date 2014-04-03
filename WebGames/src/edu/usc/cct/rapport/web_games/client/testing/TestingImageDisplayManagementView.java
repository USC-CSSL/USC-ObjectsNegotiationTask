package edu.usc.cct.rapport.web_games.client.testing;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesClientBundle;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.trading_area.ImageDisplayManagementWidget;

public class TestingImageDisplayManagementView extends WebGamesView implements ITestingView {

	static final private WebGamesClientBundle webGamesClientBundle = GWT.create(WebGamesClientBundle.class);

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;


	@Inject
	public TestingImageDisplayManagementView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		this.anchorPanel = new SimpleLayoutPanel();
		this.viewBasePanel = new FlowPanel();
		this.anchorPanel.add(viewBasePanel);

		final ImageDisplayManagementWidget emoticonBigAspectRatioNotPreserved = new ImageDisplayManagementWidget(250, 200, false, webGamesClientBundle.iconsland_large_neutral(), "a");
		this.viewBasePanel.add(emoticonBigAspectRatioNotPreserved);
		final ImageDisplayManagementWidget emoticonBigAspectRatioPreserved = new ImageDisplayManagementWidget(250, 200, true, webGamesClientBundle.iconsland_large_neutral(), "b");
		this.viewBasePanel.add(emoticonBigAspectRatioPreserved);
		final ImageDisplayManagementWidget emoticonSmallAspectRatioNotPreserved = new ImageDisplayManagementWidget(50, 40, false, webGamesClientBundle.iconsland_large_neutral(), "c");
		this.viewBasePanel.add(emoticonSmallAspectRatioNotPreserved);
		final ImageDisplayManagementWidget emoticonSmallAspectRatioPreserved = new ImageDisplayManagementWidget(50, 40, true, webGamesClientBundle.iconsland_large_neutral(), "d");
		this.viewBasePanel.add(emoticonSmallAspectRatioPreserved);
		final ImageDisplayManagementWidget dramaMaskBigAspectRatioNotPreserved = new ImageDisplayManagementWidget(250, 200, false, webGamesClientBundle.drama_face_mask_neutral(), "e");
		this.viewBasePanel.add(dramaMaskBigAspectRatioNotPreserved);
		final ImageDisplayManagementWidget dramaMaskBigAspectRatioPreserved = new ImageDisplayManagementWidget(250, 200, true, webGamesClientBundle.drama_face_mask_neutral(), "f");
		this.viewBasePanel.add(dramaMaskBigAspectRatioPreserved);
		final ImageDisplayManagementWidget dramaMaskSmallAspectRatioNotPreserved = new ImageDisplayManagementWidget(50, 40, false, webGamesClientBundle.drama_face_mask_neutral(), "g");
		this.viewBasePanel.add(dramaMaskSmallAspectRatioNotPreserved);
		final ImageDisplayManagementWidget dramaMaskSmallAspectRatioPreserved = new ImageDisplayManagementWidget(50, 40, true, webGamesClientBundle.drama_face_mask_neutral(), "h");
		this.viewBasePanel.add(dramaMaskSmallAspectRatioPreserved);

		final Button buttonTest = new Button("Test button");
		buttonTest.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingImageDisplayManagementView.this.eventBus.fireEvent(new TestingEvent());
			};
		});
		this.viewBasePanel.add(buttonTest);

		final Button buttonTestComplete = new Button("Test complete");
		buttonTestComplete.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingImageDisplayManagementView.this.eventBus.fireEvent(new TestingCompleteEvent());
			};
		});
		this.viewBasePanel.add(buttonTestComplete);

		this.viewBasePanel.setVisible(true);
		initWidget(this.viewBasePanel);
	};


	@Override
	public void add(final Widget w) {
		this.viewBasePanel.add(w);
	};


	@Override
	public void clear() {
		this.viewBasePanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = this.viewBasePanel.iterator();
		return result;
	};


	@Override
	public boolean remove(final Widget w) {
		final boolean result = viewBasePanel.remove(w);
		return result;
	}


	@Override
	public void setValuesRandomly() {
		// Not applicable.
	};

};
