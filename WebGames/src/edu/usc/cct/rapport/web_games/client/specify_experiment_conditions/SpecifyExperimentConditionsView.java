package edu.usc.cct.rapport.web_games.client.specify_experiment_conditions;

import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.AgentEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.TradingObjectSetEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.AlgorithmicCounterpartDecisionMakingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionModellingStrategyEnum;
//import java.util.Random;

public class SpecifyExperimentConditionsView extends WebGamesView implements ISpecifyExperimentConditionsView {

	//static final private ExperimentConditions defaultExperimentConditions = new ExperimentConditions(FacialExpressionStyleEnum.drama_masks, TradingObjectSetEnum.enhanced_squiggles, 32, 50, true, true, true, 24, AgentEnum.counterpart, AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconcederFirstOfferFixed, EmotionModellingStrategyEnum.chosenUniformlyAtRandom,true,true,true,1,0,0,0,0,0,0,0,0,0,0,0,0,"");
	//static final private ExperimentConditions defaultExperimentConditions = new ExperimentConditions(FacialExpressionStyleEnum.drama_masks, TradingObjectSetEnum.sacredObjects, 32, 50, false, false, true, true, 24, AgentEnum.player, AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconceder, EmotionModellingStrategyEnum.randomEveryOtherTurnSadOrAngryOrNeutral,true,false,false,1);
	//static final private ExperimentConditions defaultExperimentConditions = new ExperimentConditions(FacialExpressionStyleEnum.drama_masks, TradingObjectSetEnum.sacredObjects, 32, 50, false, false, true, true, 24, AgentEnum.player, AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy, EmotionModellingStrategyEnum.randomAfter134SadOrAngryOrNeutral,true,false,false,1);
	static final private ExperimentConditions defaultExperimentConditions = new ExperimentConditions(FacialExpressionStyleEnum.drama_masks, TradingObjectSetEnum.veggie, 32, 50, true, true, true, true, 24, AgentEnum.player, AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedAgentForTrial, EmotionModellingStrategyEnum.alwaysNeutral,true,true,true);
	static final private String largeFontSizeStyleName = "ict-rapport-largeFontSize";

	static final private SafeHtml separatingLineFeed = SafeHtmlUtils.fromSafeConstant("<br/>");

	final private ExperimentConditions experimentConditions;

	final private SimpleLayoutPanel anchorPanel;
	final private FlowPanel viewBasePanel;
	final private boolean showExperimentalConditions= true;

	@Inject
	public SpecifyExperimentConditionsView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new FlowPanel();

		
		anchorPanel.add(viewBasePanel);

		experimentConditions = defaultExperimentConditions;
		
//		Random random = new Random();
//		final boolean whichEmotion = random.nextBoolean();
		
		final Label labelQueryFacialExpressionIconStyleUsed = new Label("Which facial expression icon style will be used?");
		labelQueryFacialExpressionIconStyleUsed.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelQueryFacialExpressionIconStyleUsed);
		final VerticalPanel verticalPanelSelectFacialExpressionStyle = new VerticalPanel();
		for (final FacialExpressionStyleEnum facialExpressionStyleEnum: FacialExpressionStyleEnum.values()) {
			final RadioButton radioButton = new RadioButton(FacialExpressionStyleEnum.class.getName(), facialExpressionStyleEnum.name());
			radioButton.addStyleName(largeFontSizeStyleName);
			radioButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(final ClickEvent event) {
					experimentConditions.setFacialExpressionStyleEnum(facialExpressionStyleEnum);
				};
			});
			verticalPanelSelectFacialExpressionStyle.add(radioButton);
			if (facialExpressionStyleEnum.equals(defaultExperimentConditions.getFacialExpressionStyleEnum())) {
				radioButton.setValue(true, true);
			} else {
				radioButton.setValue(false, false);
			};
		};
		viewBasePanel.add(verticalPanelSelectFacialExpressionStyle);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelQueryTradingObjectsUsed = new Label("Which trading objects and values will be used?");
		labelQueryTradingObjectsUsed.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelQueryTradingObjectsUsed);
		final ListBox listBoxSelectTradingObjectSetEnum = new ListBox();
		for (final TradingObjectSetEnum tradingObjectSetEnum: TradingObjectSetEnum.values()) {
			if (TradingObjectSetEnum.placeholder_to_allow_initialization_prior_to_trading_object_set_selection.equals(tradingObjectSetEnum)) continue;
			listBoxSelectTradingObjectSetEnum.addItem(tradingObjectSetEnum.toString(), tradingObjectSetEnum.name());
		};
		listBoxSelectTradingObjectSetEnum.setSelectedIndex(1);
		viewBasePanel.add(listBoxSelectTradingObjectSetEnum);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelQueryCounterpartBATNAValue = new Label("What is the lack of a deal worth to the counterpart?");
		labelQueryCounterpartBATNAValue.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelQueryCounterpartBATNAValue);
		final TextBox textBoxCounterpartBATNAValue = new TextBox();
		textBoxCounterpartBATNAValue.setText(new Integer(defaultExperimentConditions.getCounterpartBATNA()).toString());
		textBoxCounterpartBATNAValue.setVisibleLength(3);
		viewBasePanel.add(textBoxCounterpartBATNAValue);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelQueryPlayerBATNAValue = new Label("What is the lack of a deal worth to the experiment participant?");
		labelQueryPlayerBATNAValue.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelQueryPlayerBATNAValue);
		final TextBox textBoxPlayerBATNAValue = new TextBox();
		textBoxPlayerBATNAValue.setText(new Integer(defaultExperimentConditions.getPlayerBATNA()).toString());
		textBoxPlayerBATNAValue.setVisibleLength(3);
		viewBasePanel.add(textBoxPlayerBATNAValue);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

//		final CheckBox checkBoxCounterpartDealValueVisible = new CheckBox("Are the counterpart BATNA non-deal and diagrammed deal values visible to the player?");
		final CheckBox checkBoxCounterpartDealValueVisible = new CheckBox("Are the counterpart diagrammed deal values visible to the player?");
		final boolean defaultCounterpartDealValueVisible = defaultExperimentConditions.getCounterpartDealValueVisible();
		checkBoxCounterpartDealValueVisible.setValue(defaultCounterpartDealValueVisible);
		viewBasePanel.add(checkBoxCounterpartDealValueVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final CheckBox checkBoxCounterpartPayoffMatrixVisible = new CheckBox("Is the counterpart's payoff matrix visible to the player?");
		final boolean defaultCounterpartPayoffMatrixVisible = defaultExperimentConditions.getCounterpartPayoffMatrixVisible();
		checkBoxCounterpartPayoffMatrixVisible.setValue(defaultCounterpartPayoffMatrixVisible);
		viewBasePanel.add(checkBoxCounterpartPayoffMatrixVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
		final CheckBox checkBoxCounterpartEmotionExpressionVisible = new CheckBox("Is the counterpart's emotion expression visible to the player?");
		final boolean defaultCounterpartEmotionExpression = defaultExperimentConditions.getCounterpartEmotionExpressionVisible();
		checkBoxCounterpartEmotionExpressionVisible.setValue(defaultCounterpartEmotionExpression);
		viewBasePanel.add(checkBoxCounterpartEmotionExpressionVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
//		final CheckBox checkBoxPlayerDealValueVisible = new CheckBox("Are the player BATNA non-deal and diagrammed deal values visible to the player?");
		final CheckBox checkBoxPlayerDealValueVisible = new CheckBox("Are the player diagrammed deal values visible to the player?");
		final boolean defaultPlayerDealValueVisible = defaultExperimentConditions.getPlayerDealValueVisible();
		checkBoxPlayerDealValueVisible.setValue(defaultPlayerDealValueVisible);
		viewBasePanel.add(checkBoxPlayerDealValueVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
		final CheckBox checkBoxPlayerPayoffMatrixVisible = new CheckBox("Is the player's payoff matrix visible?");
		final boolean defaultPlayerPayoffMatrixVisible = defaultExperimentConditions.getPlayerPayoffMatrixVisible();
		checkBoxPlayerPayoffMatrixVisible.setValue(defaultPlayerPayoffMatrixVisible);
		viewBasePanel.add(checkBoxPlayerPayoffMatrixVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
		final CheckBox checkBoxPlayerEmotionExpressionVisible = new CheckBox("Is the player's emotion expression visible to the player?");
		final boolean defaultPlayerEmotionExpression = defaultExperimentConditions.getPlayerEmotionExpressionVisible();
		checkBoxPlayerEmotionExpressionVisible.setValue(defaultPlayerEmotionExpression);
		viewBasePanel.add(checkBoxPlayerEmotionExpressionVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
		
		final CheckBox checkBoxHelpWindowsVisible = new CheckBox("Should the help windows popup?");
		final boolean defaultHelpWindowsVisible = defaultExperimentConditions.getHelpWindowsVisible();
		checkBoxHelpWindowsVisible.setValue(defaultHelpWindowsVisible);
		viewBasePanel.add(checkBoxHelpWindowsVisible);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelQueryNegotiationSessionPlyCount = new Label("How many ply (half-turns) should the negotiation session contain?  This number must be positive.");
		labelQueryNegotiationSessionPlyCount.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelQueryNegotiationSessionPlyCount);
		final ListBox listBoxNegotiationSessionPlyCount = new ListBox();
		listBoxNegotiationSessionPlyCount.addItem("1 ply (only option is to claim BATNA -- useful for debugging)", Integer.toString(1));
		listBoxNegotiationSessionPlyCount.addItem("2 ply (one offer by one agent, the other can accept or claim BATNA)", Integer.toString(2));
		listBoxNegotiationSessionPlyCount.addItem("3 ply (each agent has a chance to offer an object-allocating proposal)", Integer.toString(3));
		listBoxNegotiationSessionPlyCount.addItem("5 ply (each agent has up to two chances to offer an object-allocating proposal)", Integer.toString(5));
		listBoxNegotiationSessionPlyCount.addItem("7 ply (each agent has up to three chances to offer object-allocating proposals)", Integer.toString(7));
//		listBoxNegotiationSessionPlyCount.addItem("13 ply (each agent has up to six chances to offer object-allocating proposals)", Integer.toString(13));
		listBoxNegotiationSessionPlyCount.addItem("13 ply (each agent has up to six chances to offer object-allocating proposals)", Integer.toString(19));
		listBoxNegotiationSessionPlyCount.addItem("25 ply (each agent has up to twelve chances to offer object-allocating proposals)", Integer.toString(25));
		listBoxNegotiationSessionPlyCount.setSelectedIndex(5);
		viewBasePanel.add(listBoxNegotiationSessionPlyCount);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelSelectAgentWhoGetsToActLast = new Label("Which agent will get the last decision, if negotiation is unsuccessful?");
		labelSelectAgentWhoGetsToActLast.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelSelectAgentWhoGetsToActLast);
		final VerticalPanel verticalPanelSelectAgentWhoGetsToActLast = new VerticalPanel();
		for (final AgentEnum agentWhoActsLastIfNoAgreementIsReached: AgentEnum.values()) {
			final RadioButton radioButton = new RadioButton(AgentEnum.class.getName(), agentWhoActsLastIfNoAgreementIsReached.name());
			radioButton.addStyleName(largeFontSizeStyleName);
			radioButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(final ClickEvent event) {
					experimentConditions.setAgentWhoActsLastIfNoAgreementIsReached(agentWhoActsLastIfNoAgreementIsReached);
				};
			});
			verticalPanelSelectAgentWhoGetsToActLast.add(radioButton);
			if (agentWhoActsLastIfNoAgreementIsReached.equals(defaultExperimentConditions.getAgentWhoActsLastIfNoAgreementIsReached())) {
				radioButton.setValue(true, true);
			} else {
				radioButton.setValue(false, false);
			};
		};
		viewBasePanel.add(verticalPanelSelectAgentWhoGetsToActLast);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelSelectAlgorithmicCounterpartDecisionMakingStrategy = new Label("Which decision-making strategy will the algorithmic counterpart follow?");
		labelSelectAlgorithmicCounterpartDecisionMakingStrategy.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelSelectAlgorithmicCounterpartDecisionMakingStrategy);
		final ListBox listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy = new ListBox();
		for (final AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart: AlgorithmicCounterpartDecisionMakingStrategyEnum.values()) {
			listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy.addItem(decisionMakingStrategyOfAlgorithmicCounterpart.toString(), decisionMakingStrategyOfAlgorithmicCounterpart.name());
		};
		listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy.setSelectedIndex(AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconceder.ordinal());
		viewBasePanel.add(listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));

		final Label labelSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy = new Label("Which emotional reaction determination strategy will the algorithmic counterpart follow?");
		labelSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy);
		final ListBox listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy = new ListBox();
		for (final EmotionModellingStrategyEnum emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart: EmotionModellingStrategyEnum.values()) {
			listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.addItem(emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart.toString(), emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart.name());
		};
		listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.setSelectedIndex(EmotionModellingStrategyEnum.alwaysNeutral.ordinal());
//		listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.setSelectedIndex(EmotionModellingStrategyEnum.randomEveryOtherTurnSadOrAngryOrNeutral.ordinal());
//		listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.setSelectedIndex(EmotionModellingStrategyEnum.randomAfter134SadOrAngryOrNeutral.ordinal());
		viewBasePanel.add(listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		
/*		final Label labelWhichScienario = new Label("Choose which experimental scenario should be chosen");
		labelWhichScienario.addStyleName(largeFontSizeStyleName);
		viewBasePanel.add(labelWhichScienario);
		final ListBox ListlabelWhichScienario = new ListBox();
//		ListlabelWhichScienario.addItem("NSA scenario", Integer.toString(1));
		ListlabelWhichScienario.addItem("Democratic scenario", Integer.toString(1));
		ListlabelWhichScienario.addItem("Republican scenario", Integer.toString(2));
		ListlabelWhichScienario.addItem("Random", Integer.toString(3));
//		ListlabelWhichScienario.addItem("Scenario 1", Integer.toString(2));
//		ListlabelWhichScienario.addItem("Scenario 2", Integer.toString(3));
//		ListlabelWhichScienario.addItem("Scenario 3", Integer.toString(4));
		ListlabelWhichScienario.setSelectedIndex(3);
		viewBasePanel.add(ListlabelWhichScienario);
		viewBasePanel.add(new InlineHTML(separatingLineFeed));
		viewBasePanel.add(new InlineHTML(separatingLineFeed));*/

		final Button buttonSpecifyTheseExperimentConditions = new Button("Specify These Experiment Conditions");
		buttonSpecifyTheseExperimentConditions.addStyleName(largeFontSizeStyleName);
		buttonSpecifyTheseExperimentConditions.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final TradingObjectSetEnum tradingObjectSetEnum = Enum.valueOf(TradingObjectSetEnum.class, listBoxSelectTradingObjectSetEnum.getValue(listBoxSelectTradingObjectSetEnum.getSelectedIndex()));
				experimentConditions.setTradingObjectSetEnum(tradingObjectSetEnum);
				experimentConditions.setCounterpartDealValueVisible(checkBoxCounterpartDealValueVisible.getValue());
				experimentConditions.setCounterpartEmotionVisible(checkBoxCounterpartEmotionExpressionVisible.getValue());
				experimentConditions.setPlayerEmotionVisible(checkBoxPlayerEmotionExpressionVisible.getValue());
				experimentConditions.setCounterpartPayoffMatrixVisible(checkBoxCounterpartPayoffMatrixVisible.getValue());
				experimentConditions.setPlayerBATNA(Integer.parseInt(textBoxPlayerBATNAValue.getValue()));
				experimentConditions.setCounterpartBATNA(Integer.parseInt(textBoxCounterpartBATNAValue.getValue()));
				experimentConditions.setHelpWindowsVisible(checkBoxHelpWindowsVisible.getValue());
				experimentConditions.setPlayerPayoffMatrixVisible(checkBoxPlayerPayoffMatrixVisible.getValue());
				experimentConditions.setPlayerDealValueVisible(checkBoxPlayerDealValueVisible.getValue());
				final int plyRemaining = Integer.parseInt(listBoxNegotiationSessionPlyCount.getValue(listBoxNegotiationSessionPlyCount.getSelectedIndex()));
				experimentConditions.setNegotiationSessionPlyCount(plyRemaining);
				final AlgorithmicCounterpartDecisionMakingStrategyEnum decisionMakingStrategyOfAlgorithmicCounterpart = AlgorithmicCounterpartDecisionMakingStrategyEnum.valueOf(listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy.getValue(listBoxSelectAlgorithmicCounterpartDecisionMakingStrategy.getSelectedIndex()));
				experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(decisionMakingStrategyOfAlgorithmicCounterpart);
				
			    EmotionModellingStrategyEnum emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart = EmotionModellingStrategyEnum.valueOf(listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.getValue(listBoxSelectAlgorithmicCounterpartEmotionalReactionDeterminationStrategy.getSelectedIndex()));
				experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionalReactionDeterminationStrategyOfAlgorithmicCounterpart);
				
//				final int expscenario = Integer.parseInt(ListlabelWhichScienario.getValue(ListlabelWhichScienario.getSelectedIndex()));
//				experimentConditions.setExpScenario(expscenario);
				SpecifyExperimentConditionsView.this.eventBus.fireEvent(new ExperimentConditionsSpecifiedEvent(experimentConditions));
				
			};
		});
		
		
		
		viewBasePanel.add(buttonSpecifyTheseExperimentConditions);
		if(showExperimentalConditions)
			viewBasePanel.setVisible(true);
		else
			viewBasePanel.setVisible(false);
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

};
