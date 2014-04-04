package edu.usc.cct.rapport.web_games.client.testing;

import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEmotionSelectionWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class TestingAgentFacialExpressionSelectionView extends WebGamesView implements ITestingView {

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;

	final private AgentEmotionSelectionWidget usingDramaMasks;
	final private AgentEmotionSelectionWidget usingEmoticons;


	@Inject
	public TestingAgentFacialExpressionSelectionView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();
		anchorPanel.add(viewBasePanel);

		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{FacialExpressionEnum.happy, FacialExpressionEnum.content, FacialExpressionEnum.neutral, FacialExpressionEnum.angry, FacialExpressionEnum.sad};
		final FacialExpressionEnum originalSelection = FacialExpressionEnum.neutral;
		this.usingDramaMasks = new AgentEmotionSelectionWidget(eventBus, FacialExpressionStyleEnum.drama_masks, desiredImagePresentationOrder, originalSelection);
		this.viewBasePanel.add(usingDramaMasks);
		this.usingEmoticons = new AgentEmotionSelectionWidget(eventBus, FacialExpressionStyleEnum.emoticons, desiredImagePresentationOrder, originalSelection);
		this.viewBasePanel.add(usingEmoticons);

/*
		final Button buttonTest = new Button("Test button");
		buttonTest.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentFacialExpressionSelectionView.this.eventBus.fireEvent(new TestingEvent());
			};
		});
		viewBasePanel.add(buttonTest);
*/

		final Button buttonTestComplete = new Button("Test complete");
		buttonTestComplete.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentFacialExpressionSelectionView.this.eventBus.fireEvent(new TestingCompleteEvent());
			};
		});
		viewBasePanel.add(buttonTestComplete);

		viewBasePanel.setVisible(true);
		initWidget(viewBasePanel);
	};


	@Override
	public void add(final Widget w) {
		viewBasePanel.add(w);
	};


	@Override
	public void clear() {
		viewBasePanel.clear();
	};


	@Override
	public Iterator<Widget> iterator() {
		final Iterator<Widget> result = viewBasePanel.iterator();
		return result;
	};


	@Override
	public boolean remove(final Widget w) {
		final boolean result = viewBasePanel.remove(w);
		return result;
	};


	@Override
	public void setValuesRandomly() {
/*
		final Random rng = new Random();
		final Integer randomCounterpartEmotionAsInteger = rng.nextInt(AgentFacialExpressionEnum.values().length);
		final Integer randomPlayerEmotionAsInteger = rng.nextInt(AgentFacialExpressionEnum.values().length);

		for (final AgentFacialExpressionEnum agentEmotionEnum: AgentFacialExpressionEnum.values()) {
			if (agentEmotionEnum.ordinal() == randomCounterpartEmotionAsInteger) {
				counterpartEmotionExpression.setValue(agentEmotionEnum);
			};
			if (agentEmotionEnum.ordinal() == randomPlayerEmotionAsInteger) {
				playerEmotionExpression.setValue(agentEmotionEnum);
			};
		};
*/
	};

};
