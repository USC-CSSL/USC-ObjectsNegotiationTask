/*
package edu.usc.cct.rapport.web_games.client.testing;

import java.util.Iterator;
import java.util.Random;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentDealValuationWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentObjectValuationWidget;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectSetEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.ValuationCategoryEnum;

public class TestingAgentDealAndObjectCompositesView extends Composite implements HasWidgets, ITestingView {

	static final private String ictRapportDefaultFontSize = "ict-rapport-defaultFontSize";

	final private EventBus eventBus;
	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;

	final private AgentDealValuationWidget counterpartDealValuation;
	final private AgentObjectValuationWidget counterpartObjectValuation;


	public TestingAgentDealAndObjectCompositesView(final EventBus eventBus) {
		super();
		this.eventBus = eventBus;

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();
		anchorPanel.add(viewBasePanel);

		counterpartDealValuation = new AgentDealValuationWidget(AgentEnum.counterpart, 433);
		viewBasePanel.add(counterpartDealValuation);

		final TradingObjectSetEnum tradingObjectSetEnum = TradingObjectSetEnum.squiggles;
		counterpartObjectValuation = new AgentObjectValuationWidget(AgentEnum.counterpart, tradingObjectSetEnum, "100px");
		viewBasePanel.add(counterpartObjectValuation);
		
		final Button buttonTest = new Button("Test button");
		buttonTest.addStyleName(ictRapportDefaultFontSize);
		buttonTest.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentDealAndObjectCompositesView.this.eventBus.fireEvent(new TestingEvent());
			};
		});
		viewBasePanel.add(buttonTest);

		final Button buttonTestComplete = new Button("Test complete");
		buttonTestComplete.addClickHandler(new ClickHandler() {				
			@Override
			public void onClick(final ClickEvent event) {
				TestingAgentDealAndObjectCompositesView.this.eventBus.fireEvent(new TestingCompleteEvent());
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
		counterpartDealValuation.setDealValue(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, rng.nextInt(100));
		counterpartDealValuation.setDealValue(ValuationCategoryEnum.proposalAsDiagrammed, rng.nextInt(100));
		counterpartObjectValuation.setObjectValue(TradingObjectEnum.squiggle_1, rng.nextInt(20));
		counterpartObjectValuation.setObjectValue(TradingObjectEnum.squiggle_2, rng.nextInt(20));
		counterpartObjectValuation.setObjectValue(TradingObjectEnum.squiggle_3, rng.nextInt(20));
		counterpartObjectValuation.setObjectValue(TradingObjectEnum.squiggle_4, rng.nextInt(20));
	};

};
*/
