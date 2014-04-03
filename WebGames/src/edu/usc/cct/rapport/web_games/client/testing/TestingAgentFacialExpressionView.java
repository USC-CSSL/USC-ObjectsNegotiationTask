package edu.usc.cct.rapport.web_games.client.testing;

import java.util.Iterator;
import java.util.Random;

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
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEmotionExpressionWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class TestingAgentFacialExpressionView extends WebGamesView implements ITestingView {

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;

	final private AgentEmotionExpressionWidget counterpartEmotionExpression;
	final private AgentEmotionExpressionWidget playerEmotionExpression;


	@Inject
	public TestingAgentFacialExpressionView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();
		anchorPanel.add(viewBasePanel);

		this.counterpartEmotionExpression = new AgentEmotionExpressionWidget(AgentEnum.counterpart, FacialExpressionEnum.neutral, FacialExpressionStyleEnum.drama_masks, 150);
		this.viewBasePanel.add(counterpartEmotionExpression);
		this.playerEmotionExpression = new AgentEmotionExpressionWidget(AgentEnum.player, FacialExpressionEnum.neutral, FacialExpressionStyleEnum.emoticons, 200);
		this.viewBasePanel.add(playerEmotionExpression);

		final Button buttonTest = new Button("Test button");
		buttonTest.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentFacialExpressionView.this.eventBus.fireEvent(new TestingEvent());
			};
		});
		viewBasePanel.add(buttonTest);

		final Button buttonTestComplete = new Button("Test complete");
		buttonTestComplete.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentFacialExpressionView.this.eventBus.fireEvent(new TestingCompleteEvent());
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
		final Random rng = new Random();
		final Integer randomCounterpartEmotionAsInteger = rng.nextInt(FacialExpressionEnum.values().length);
		final Integer randomPlayerEmotionAsInteger = rng.nextInt(FacialExpressionEnum.values().length);

		for (final FacialExpressionEnum agentEmotionEnum: FacialExpressionEnum.values()) {
			if (agentEmotionEnum.ordinal() == randomCounterpartEmotionAsInteger) {
				counterpartEmotionExpression.setFacialExpression(agentEmotionEnum);
			};
			if (agentEmotionEnum.ordinal() == randomPlayerEmotionAsInteger) {
				playerEmotionExpression.setFacialExpression(agentEmotionEnum);
			};
		};
	};

};
