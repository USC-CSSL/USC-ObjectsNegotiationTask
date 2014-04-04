/*
package edu.usc.cct.rapport.web_games.client.testing;

import java.util.EnumMap;
import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentDealValuationWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingBoardWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingBoardState;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectSetEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.ValuationCategoryEnum;

public class TestingTradingBoardView extends Composite implements HasWidgets, ITestingView {

	final private EventBus eventBus;
	final private SimpleLayoutPanel anchorPanel;
	final private AbsolutePanel viewBasePanel;
	final private TradingBoardState tradingBoardState;
	final private TradingBoardWidget tradingBoardWidget;
	final private AgentDealValuationWidget counterpartDealValuation;
	final private AgentDealValuationWidget playerDealValuation;


	public TestingTradingBoardView(final EventBus eventBus) {
		super();
		this.eventBus = eventBus;

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new AbsolutePanel();
		viewBasePanel.setWidth("800px");
		viewBasePanel.setHeight("600px");
		anchorPanel.add(viewBasePanel);
		tradingBoardState = new TradingBoardState(TradingObjectSetEnum.mixture_1);
		tradingBoardWidget = new TradingBoardWidget(eventBus, tradingBoardState);
		viewBasePanel.add(tradingBoardWidget);

		counterpartDealValuation = new AgentDealValuationWidget(AgentEnum.counterpart, 440);
		viewBasePanel.add(counterpartDealValuation);
		playerDealValuation = new AgentDealValuationWidget(AgentEnum.player, 440);
		viewBasePanel.add(playerDealValuation);

		final Button buttonTest = new Button("Test button");
		buttonTest.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingTradingBoardView.this.eventBus.fireEvent(new TestingEvent());
			};
		});
		viewBasePanel.add(buttonTest);

		final Button buttonTestComplete = new Button("Test complete");
		buttonTestComplete.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingTradingBoardView.this.eventBus.fireEvent(new TestingCompleteEvent());
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
		tradingBoardState.setToRandomProposal();
		tradingBoardWidget.setState(tradingBoardState);
		final EnumMap<AgentEnum, Integer> proposalValue = tradingBoardState.getProposalValue();
		counterpartDealValuation.setDealValue(ValuationCategoryEnum.proposalAsDiagrammed, proposalValue.get(AgentEnum.counterpart));
		playerDealValuation.setDealValue(ValuationCategoryEnum.proposalAsDiagrammed, proposalValue.get(AgentEnum.player));
	};

};
*/
