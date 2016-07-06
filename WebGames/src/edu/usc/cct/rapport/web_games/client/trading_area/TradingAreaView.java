package edu.usc.cct.rapport.web_games.client.trading_area;

//import java.awt.Point;
//import java.awt.Toolkit;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Random;

import com.google.gwt.core.client.Duration;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.SimpleLayoutPanel;
import edu.usc.cct.rapport.web_games.client.WebGamesView;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
//import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionModellingStrategyEnum;


public class TradingAreaView extends WebGamesView implements ITradingAreaView {

	static final private String debuggingBorderStyle = "ict-rapport-debuggingBorderStyle";

	static final private int desiredEmotionSelectionImageWidthInPixels = 65;
	static final private int desiredEmotionSelectionImageHeightInPixels = 65;
	static final public ImageDimensionCalculator desiredEmotionSelectionImageDimensionCalculator = new ImageDimensionCalculator(desiredEmotionSelectionImageWidthInPixels, desiredEmotionSelectionImageHeightInPixels);	

	final private SimpleLayoutPanel anchorPanel;
	final private DockLayoutPanel viewBasePanel;

	final private EnumMap<AgentEnum, AgentDealValuationWidget> agentDealValuationWidgets;
	final private EnumMap<TradingActionEnum, Button> tradingActionButtons;
	final private TradingBoardWidget tradingBoardWidget;
	final private DockLayoutPanel dockLayoutPanelCounterpartArea;
	final private DockLayoutPanel dockLayoutPanelPlayerArea;
	final private AgentObjectValuationWidget counterpartObjectValuation;
	final private AgentObjectValuationWidget playerObjectValuation;
	final private AgentEmotionExpressionWidget counterpartEmotionExpressionWidget;
	final AgentEmotionSelectionWidget playerEmotionSelection;
	final private FacialExpressionStyleEnum facialExpressionStyleEnum;
	final private RoundInformationWidget roundInformationWidget;
	
	private boolean counterpartDealValueVisible;
	private boolean counterpartObjectValuationVisible;
	private boolean counterpartEmotionExpressionVisible;
	
	private boolean playerEmotionExpressionVisible;
	private boolean playerDealValueVisible;
	private boolean playerDealValuationVisible;
	
	private int counterpartBATNA;
	private int playerBATNA;
	private int	expScenario;
	private int partnerLabel;

	@Inject
	public TradingAreaView(final EventBus eventBus, final PlaceController placeController) {
		super(eventBus, placeController);

		// These are garbage values that are overridden later, during state updates.
		this.counterpartDealValueVisible = false;
		this.counterpartObjectValuationVisible = false;
		this.counterpartEmotionExpressionVisible = false;
		this.counterpartBATNA = Integer.MIN_VALUE;
		this.playerBATNA = Integer.MIN_VALUE;
		this.playerEmotionExpressionVisible = false;
		this.facialExpressionStyleEnum = FacialExpressionStyleEnum.drama_masks;
		this.expScenario = 0;
//		this.partnerLabel = 0;

		anchorPanel = new SimpleLayoutPanel();
		viewBasePanel = new DockLayoutPanel(Unit.PX);
		anchorPanel.add(viewBasePanel);
		
		roundInformationWidget = new RoundInformationWidget();
		viewBasePanel.addNorth(roundInformationWidget, 32.0);

		final DockLayoutPanel dockLayoutPanelDragDropHoldingArea = new DockLayoutPanel(Unit.PX);
		dockLayoutPanelDragDropHoldingArea.addStyleName(debuggingBorderStyle);
		viewBasePanel.addWest(dockLayoutPanelDragDropHoldingArea, 465.0);
//		viewBasePanel.addWest(dockLayoutPanelDragDropHoldingArea, 355.0);

		dockLayoutPanelCounterpartArea = new DockLayoutPanel(Unit.PX);
		
/*		final Button reviewScenarioBtn = new Button("Review scenario");
		reviewScenarioBtn.setVisible(true);
		reviewScenarioBtn.setEnabled(true);

		reviewScenarioBtn.addClickHandler(new ClickHandler() {				
			public void onClick(final ClickEvent event) {
				reviewScenarioDialogBox();
			};
		});*/
		
		FlexTable wrapper = new FlexTable();
		wrapper.setSize("100%", "100%");
//		wrapper.setWidget(0, 0, reviewScenarioBtn);
//		wrapper.getFlexCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
//		dockLayoutPanelDragDropHoldingArea.addNorth(wrapper, 30);
		
		
		final Button item1_up = new Button("^");
		final Button item2_up = new Button("^");
		final Button item3_up = new Button("^");
		final Button item4_up = new Button("^");

		item1_up.addClickHandler(new ClickHandler() {				
			public void onClick(final ClickEvent event) {
//				reviewScenarioDialogBox();
			};
		});

		
//		dockLayoutPanelDragDropHoldingArea.addNorth(dockLayoutPanelCounterpartArea, 1);  // when there are 5 items each
//		dockLayoutPanelDragDropHoldingArea.addNorth(dockLayoutPanelCounterpartArea, 30);
		dockLayoutPanelDragDropHoldingArea.addNorth(dockLayoutPanelCounterpartArea, 55);
//		dockLayoutPanelDragDropHoldingArea.addNorth(dockLayoutPanelCounterpartArea, 110); // when there are 3 items each
//		dockLayoutPanelDragDropHoldingArea.addNorth(wrapper_up, 210);*/

		dockLayoutPanelPlayerArea = new DockLayoutPanel(Unit.PX);		

//		dockLayoutPanelDragDropHoldingArea.addSouth(wrapper_down, 210);
//		dockLayoutPanelDragDropHoldingArea.addSouth(dockLayoutPanelPlayerArea, 1);  // when there are 5 items each
//		dockLayoutPanelDragDropHoldingArea.addSouth(dockLayoutPanelPlayerArea, 30);
		dockLayoutPanelDragDropHoldingArea.addSouth(dockLayoutPanelPlayerArea, 55);
//		dockLayoutPanelDragDropHoldingArea.addSouth(dockLayoutPanelPlayerArea, 110); // when there are 3 items each
		
		agentDealValuationWidgets = new EnumMap<AgentEnum, AgentDealValuationWidget>(AgentEnum.class);
//		final AgentDealValuationWidget counterpartDealValuation = new AgentDealValuationWidget(AgentEnum.counterpart, 440);
		final AgentDealValuationWidget counterpartDealValuation = new AgentDealValuationWidget(AgentEnum.counterpart, 480);
		dockLayoutPanelCounterpartArea.add(counterpartDealValuation);
		agentDealValuationWidgets.put(AgentEnum.counterpart, counterpartDealValuation);
//		final AgentDealValuationWidget playerDealValuation = new AgentDealValuationWidget(AgentEnum.player, 440);
		final AgentDealValuationWidget playerDealValuation = new AgentDealValuationWidget(AgentEnum.player, 480);
		dockLayoutPanelPlayerArea.add(playerDealValuation);
		agentDealValuationWidgets.put(AgentEnum.player, playerDealValuation);

		final TradingObjectSetEnum tradingObjectSetEnum = TradingObjectSetEnum.placeholder_to_allow_initialization_prior_to_trading_object_set_selection;
		tradingObjectSetEnum.getSetOfTradingObjectEnum();

		final TradingBoardState initialTradingBoardState = new TradingBoardState(tradingObjectSetEnum);
		tradingBoardWidget = new TradingBoardWidget(eventBus, initialTradingBoardState);
		dockLayoutPanelDragDropHoldingArea.add(tradingBoardWidget);
		tradingBoardWidget.setState(initialTradingBoardState);
		
		final DockLayoutPanel dockLayoutPanelRightPeriphery = new DockLayoutPanel(Unit.PX);
		dockLayoutPanelRightPeriphery.addStyleName(debuggingBorderStyle);
		viewBasePanel.addEast(dockLayoutPanelRightPeriphery, 225.0);

		counterpartEmotionExpressionWidget = new AgentEmotionExpressionWidget(AgentEnum.counterpart, FacialExpressionEnum.neutral, this.facialExpressionStyleEnum, 215);
//		counterpartEmotionExpressionWidget = new AgentEmotionExpressionWidget(AgentEnum.counterpart, FacialExpressionEnum.neutral, this.facialExpressionStyleEnum, 215, this.expScenario);
//		dockLayoutPanelRightPeriphery.addNorth(counterpartEmotionExpressionWidget, 180);
		dockLayoutPanelRightPeriphery.addNorth(counterpartEmotionExpressionWidget, 230);

		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{}; // EK 10/08/14: no emotion change is allowed for participants.
//		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{FacialExpressionEnum.happy, FacialExpressionEnum.content, FacialExpressionEnum.neutral, FacialExpressionEnum.angry, FacialExpressionEnum.sad};
//		final FacialExpressionEnum[] desiredImagePresentationOrder = new FacialExpressionEnum[]{FacialExpressionEnum.neutral, FacialExpressionEnum.angry, FacialExpressionEnum.sad};
		final FacialExpressionEnum originalSelection = FacialExpressionEnum.neutral;
		playerEmotionSelection = new AgentEmotionSelectionWidget(eventBus, FacialExpressionStyleEnum.drama_masks, desiredImagePresentationOrder, originalSelection);
//		dockLayoutPanelRightPeriphery.addSouth(playerEmotionSelection, 166.0+180.0);
		dockLayoutPanelRightPeriphery.addSouth(playerEmotionSelection, 230.0);	// showing only the player's name
//		dockLayoutPanelRightPeriphery.addSouth(playerEmotionSelection, 250.0);	// showing the player's name + the player's emotion
//		dockLayoutPanelRightPeriphery.addSouth(playerEmotionSelection, 260.0);	// showing the player's name + the player's emotion + (small) emotion selection
				
		final HorizontalPanel horizontalPanelButtons = new HorizontalPanel();
		horizontalPanelButtons.setHeight("72px");
		horizontalPanelButtons.setWidth("100%");
		horizontalPanelButtons.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		horizontalPanelButtons.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanelButtons.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);

		tradingActionButtons = new EnumMap<TradingActionEnum, Button>(TradingActionEnum.class);
		for (final TradingActionEnum tradingActionEnum: TradingActionEnum.values()) {
			final Button button = new Button(tradingActionEnum.getButtonDescription());
			button.setHeight("72px");
			button.setWidth("100%");
			button.setVisible(true);
			button.setEnabled(true);
//			final WaitingDialogBox dialogBox = new WaitingDialogBox (eventBus, "waitForCounterpart", partnerLabel);

			switch (tradingActionEnum) {
			case makeInitialProposal:
			case makeCounterproposal:
				button.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {						
						final double timestamp = Duration.currentTimeMillis();
						final Proposal newProposal = new Proposal(AgentEnum.player, tradingBoardWidget.getState().getTradingObjectsRetainedByAgent(AgentEnum.player));
						final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, tradingActionEnum, newProposal);
						TradingAreaView.this.eventBus.fireEvent(new ProposalMadeEvent(newTradingAction));					        
/*					    Timer t = new Timer() { // ek: added waiting msg
					        @Override
					        public void run() {
					        	dialogBox.hide();
								final Proposal newProposal = new Proposal(AgentEnum.player, tradingBoardWidget.getState().getTradingObjectsRetainedByAgent(AgentEnum.player));
								final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, tradingActionEnum, newProposal);
								TradingAreaView.this.eventBus.fireEvent(new ProposalMadeEvent(newTradingAction));					        
					        }
					      };
					      dialogBox.setPopupPosition(105, 75);
					      dialogBox.show(); // EK 10/27/2014: pop up the screen in the left uppermost area
//				    	  dialogBox.center();
					      t.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec*/
					};
				});
				break;
			case acceptProposal:
				button.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						final double timestamp = Duration.currentTimeMillis();
						final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, tradingActionEnum, null);
						TradingAreaView.this.eventBus.fireEvent(new ProposalAcceptedEvent(newTradingAction));
					};
				});
				break;
			case claimBATNAValue:
				button.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(final ClickEvent event) {
						final double timestamp = Duration.currentTimeMillis();
						final TradingAction newTradingAction = new TradingAction(AgentEnum.player, timestamp, tradingActionEnum, null);
						TradingAreaView.this.eventBus.fireEvent(new BATNAClaimMadeEvent(newTradingAction));
					};
				});
			case rejectProposal:
			case endProposalReview:
			case endCoinTossResultReview:
			case endWaiting:				
				break;
			};
			horizontalPanelButtons.add(button);
			tradingActionButtons.put(tradingActionEnum, button);
		};

		dockLayoutPanelRightPeriphery.add(horizontalPanelButtons);
//		dockLayoutPanelRightPeriphery.addSouth(horizontalPanelButtons, 170.0);

		final DockLayoutPanel dockLayoutPayoffInformation = new DockLayoutPanel(Unit.PX);
		dockLayoutPayoffInformation.addStyleName(debuggingBorderStyle);
		viewBasePanel.addEast(dockLayoutPayoffInformation, 110);

//		counterpartObjectValuation = new AgentObjectValuationWidget(AgentEnum.counterpart, tradingObjectSetEnum, "100px");
		counterpartObjectValuation = new AgentObjectValuationWidget(AgentEnum.counterpart, tradingObjectSetEnum, "98px");
//		dockLayoutPayoffInformation.addNorth(counterpartObjectValuation, 300);
		dockLayoutPayoffInformation.addNorth(new HTML(""), 35);
		dockLayoutPayoffInformation.addNorth(counterpartObjectValuation, 270);
//		playerObjectValuation = new AgentObjectValuationWidget(AgentEnum.player, tradingObjectSetEnum, "100px");
		playerObjectValuation = new AgentObjectValuationWidget(AgentEnum.player, tradingObjectSetEnum, "98px");
//		dockLayoutPayoffInformation.addSouth(playerObjectValuation, 300);
		dockLayoutPayoffInformation.addSouth(playerObjectValuation, 210);

		viewBasePanel.setVisible(true);
		initWidget(viewBasePanel);
	};


	@Override
	public void setCounterpartInformationVisibilityAndBATNAValues(final ExperimentConditions experimentConditions) {
		
	
		this.counterpartObjectValuationVisible = experimentConditions.getCounterpartPayoffMatrixVisible();
		counterpartObjectValuation.setVisible(this.counterpartObjectValuationVisible);

		this.counterpartEmotionExpressionVisible = experimentConditions.getCounterpartEmotionExpressionVisible();
		counterpartEmotionExpressionWidget.setVisible(this.counterpartEmotionExpressionVisible);

		
		this.counterpartDealValueVisible = experimentConditions.getCounterpartDealValueVisible();
		if(this.counterpartDealValueVisible==false & this.counterpartEmotionExpressionVisible==false){
//			agentDealValuationWidgets.get(AgentEnum.counterpart).setLabelVisibility(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, false);
			agentDealValuationWidgets.get(AgentEnum.counterpart).setLabelVisibility(ValuationCategoryEnum.proposalAsDiagrammed, false);
//			agentDealValuationWidgets.get(AgentEnum.counterpart).setLabelText(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, "\tThe Other Family");
			agentDealValuationWidgets.get(AgentEnum.counterpart).setLabelText(ValuationCategoryEnum.proposalAsDiagrammed, "");
		}
		else
			dockLayoutPanelCounterpartArea.setVisible(this.counterpartDealValueVisible);
		
		
/*		this.playerBATNA = experimentConditions.getPlayerBATNA();
		agentDealValuationWidgets.get(AgentEnum.player).setDealValue(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, this.playerBATNA);

		this.counterpartBATNA = experimentConditions.getCounterpartBATNA();
		agentDealValuationWidgets.get(AgentEnum.counterpart).setDealValue(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, this.counterpartBATNA);*/
	};

	@Override
	public void setPlayerInformationVisibilityAndBATNAValues(final ExperimentConditions experimentConditions) {

		this.playerDealValuationVisible = experimentConditions.getPlayerPayoffMatrixVisible();
		playerObjectValuation.setVisible(this.playerDealValuationVisible);
		
		this.playerDealValueVisible = experimentConditions.getPlayerDealValueVisible();
		dockLayoutPanelPlayerArea.setVisible(this.playerDealValueVisible);
		
		this.playerEmotionExpressionVisible = experimentConditions.getPlayerEmotionExpressionVisible();
		playerEmotionSelection.setVisible(this.playerEmotionExpressionVisible);
		playerEmotionSelection.setFacialExpressionVisibility(this.playerEmotionExpressionVisible);

		if(this.playerDealValueVisible==false & this.playerEmotionExpressionVisible==false){
//			agentDealValuationWidgets.get(AgentEnum.player).setLabelVisibility(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, false);
			agentDealValuationWidgets.get(AgentEnum.player).setLabelVisibility(ValuationCategoryEnum.proposalAsDiagrammed, false);
//			agentDealValuationWidgets.get(AgentEnum.player).setLabelText(ValuationCategoryEnum.bestAlternativeToNegotiatedAgreement, "");
			agentDealValuationWidgets.get(AgentEnum.player).setLabelText(ValuationCategoryEnum.proposalAsDiagrammed, "\t\tYour Family");
		}
		else 
			dockLayoutPanelPlayerArea.setVisible(this.counterpartDealValueVisible);
		
	};//Morteza

	@Override
	public void setFacialExpressionStyle(final FacialExpressionStyleEnum facialExpressionStyleEnum) {
		this.counterpartEmotionExpressionWidget.setFacialExpressionStyle(facialExpressionStyleEnum);
		this.playerEmotionSelection.setFacialExpressionStyle(facialExpressionStyleEnum);
	};


	@Override
	public void setCounterpartEmotionState(final FacialExpressionEnum agentEmotionEnum) {
		this.counterpartEmotionExpressionWidget.setFacialExpression(agentEmotionEnum);
	};

	@Override
	public void setDisplayName(final Integer partnerLabel) { // ek added: 2016/4/4
		this.counterpartEmotionExpressionWidget.setDisplayName(partnerLabel);
		this.partnerLabel = partnerLabel;
	};
	
	@Override
	public void setRoundInformation(final int roundInfo) { // ek added: 2016/4/5
		this.roundInformationWidget.setRoundInformation(roundInfo);
	};
	
	@Override
	public void updateTradingActionButtonAvailabilityWithoutRegardToTradingBoardState(final NegotiationSession negotiationSession) {

		if (AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext())) {
	
//			tradingBoardWidget.setEnabled(true);

//			this.getElement().getStyle().setCursor(Cursor.POINTER);
//			getElement().getStyle().setCursor(Cursor.AUTO);

/*			// enable user interaction
			Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
                public void onPreviewNativeEvent(NativePreviewEvent pEvent) {
                    final Element target = pEvent.getNativeEvent().getEventTarget().cast();

                    // block all events targetted at the children of the composite.
                    if (DOM.isOrHasChild(getElement(), target)) {
                        pEvent.consume();
                    }
                }
            });*/
			
			
			/* If it is the player's turn to move, we only want the buttons that are eligible to be used to be visible. */

			final Button makeInitialProposal = tradingActionButtons.get(TradingActionEnum.makeInitialProposal);
			final Button acceptProposal = tradingActionButtons.get(TradingActionEnum.acceptProposal);
			final Button makeCounterproposal = tradingActionButtons.get(TradingActionEnum.makeCounterproposal);
			final Button claimBATNAScore = tradingActionButtons.get(TradingActionEnum.claimBATNAValue);
			final Button rejectProposal = tradingActionButtons.get(TradingActionEnum.rejectProposal);
			final Button endProposalReview = tradingActionButtons.get(TradingActionEnum.endProposalReview);
			final Button endCoinTossResultReview = tradingActionButtons.get(TradingActionEnum.endCoinTossResultReview);
			final Button endWaiting = tradingActionButtons.get(TradingActionEnum.endWaiting);
			makeInitialProposal.setStylePrimaryName("BigButton-style");
			acceptProposal.setStylePrimaryName("BigButton-style");
			makeCounterproposal.setStylePrimaryName("BigButton-style");
			claimBATNAScore.setStylePrimaryName("BigButton-style");
			
			rejectProposal.setEnabled(false);
			rejectProposal.setVisible(false);
			endProposalReview.setEnabled(false);
			endProposalReview.setVisible(false);
			endCoinTossResultReview.setEnabled(false);
			endCoinTossResultReview.setVisible(false);
			endWaiting.setEnabled(false);
			endWaiting.setVisible(false);

			final Proposal mostRecentlyOfferedProposal = negotiationSession.getMostRecentProposal();
//			acceptProposal.setEnabled(null != mostRecentlyOfferedProposal);
			acceptProposal.setVisible(null != mostRecentlyOfferedProposal);
			acceptProposal.setVisible(false);

			if (1 == negotiationSession.getPlyRemaining()) {
				// We have reached the final ply.
				makeInitialProposal.setEnabled(false);
				makeInitialProposal.setVisible(false);
				makeCounterproposal.setEnabled(false);
				makeCounterproposal.setVisible(false);
				claimBATNAScore.setEnabled(true);
				claimBATNAScore.setVisible(true);
			} else {
				if (null == mostRecentlyOfferedProposal) {
					makeInitialProposal.setEnabled(true);
					makeInitialProposal.setVisible(true);
					makeCounterproposal.setEnabled(false);
					makeCounterproposal.setVisible(false);
//				} else if (negotiationSession.getPlyRemaining() < 5) {
				} else if (negotiationSession.getPlyRemaining() < 9) {
					makeInitialProposal.setEnabled(false);
					makeInitialProposal.setVisible(false);
					makeCounterproposal.setEnabled(false);
					makeCounterproposal.setVisible(false);
					
/*					Timer timer1 = new Timer() {
					      public void run() {
					    	  final PopupPanel popup = new PopupPanel(false, true); // Create a modal dialog box that will not auto-hide
					    	  popup.setStylePrimaryName("PopupPanel-NoBorder");
					    	  popup.setGlassStyleName("PopupPanelGlass");
								
					    	  popup.add(new Label(""));
					    	  popup.setWidth("1024px");
					    	  popup.setHeight("768px");
					    	  popup.setGlassEnabled(true); // Enable the glass panel
					    	  popup.center(); // Center the popup and make it visible
					    	  popup.getElement().getStyle().setCursor(Cursor.WAIT);

					    	  Timer timer2 = new Timer() {
							      public void run() {
										makeCounterproposal.setEnabled(true);
										makeCounterproposal.setVisible(true);
										popup.hide();
							      }
							};
							timer2.schedule(14000);					      
						}
					};
					timer1.schedule(10000);*/
					
					final PopupPanel popup = new PopupPanel(false, true); // Create a modal dialog box that will not auto-hide
					popup.setStylePrimaryName("PopupPanel-NoBorder");
					popup.setGlassStyleName("PopupPanelGlass");
					
					popup.add(new Label(""));
					popup.setWidth("1024px");
					popup.setHeight("768px");
					popup.setGlassEnabled(true); // Enable the glass panel
					popup.center(); // Center the popup and make it visible
					popup.getElement().getStyle().setCursor(Cursor.WAIT);

					Timer timer = new Timer() {
					      public void run() {
								makeCounterproposal.setEnabled(true);
								makeCounterproposal.setVisible(true);
								popup.hide();
					      }
					};
//					timer.schedule(24000);
					timer.schedule(14000);
					
				} else {
					makeInitialProposal.setEnabled(false);
					makeInitialProposal.setVisible(false);
					makeCounterproposal.setEnabled(false);
					makeCounterproposal.setVisible(false);
//					tradingBoardWidget.setEnabled(false);
					
					final PopupPanel popup = new PopupPanel(false, true); // Create a modal dialog box that will not auto-hide
					popup.setStylePrimaryName("PopupPanel-NoBorder");
					popup.setGlassStyleName("PopupPanelGlass");
//					popup.addStyleName("myCursor");

					popup.add(new Label(""));
					popup.setWidth("1024px");
					popup.setHeight("768px");
					popup.setGlassEnabled(true); // Enable the glass panel
					popup.center(); // Center the popup and make it visible*/
					popup.getElement().getStyle().setCursor(Cursor.WAIT);
//					popup.getElement().getStyle().setCursor("myCursor");
					
					Timer timer = new Timer() {
					      public void run() {
					    	  	makeCounterproposal.setEnabled(true);
								makeCounterproposal.setVisible(true);
//								tradingBoardWidget.setEnabled(true);
								popup.hide();	
								setRoundInformation(negotiationSession.getPlyRemaining());
					      }
					};
					timer.schedule(14000);

				};
				claimBATNAScore.setEnabled(false);
				claimBATNAScore.setVisible(false);
			};

		} else {

			/* Whether it is the counterpart's ply to act, or no longer either agent's ply to act because no plies are remaining, we leave the old buttons visible, but ensure that they are all disabled. */

			for (final Button button: tradingActionButtons.values()) {
				button.setEnabled(false);
			};

			tradingBoardWidget.dropped = false;
//			this.getElement().getStyle().setCursor(Cursor.WAIT);
//			tradingBoardWidget.setEnabled(false);
//			tradingBoardWidget.getElement().getStyle().setCursor(Cursor.valueOf("BUSY"));
			
/*			Toolkit tk = Toolkit.getDefaultToolkit();
			tradingBoardWidget.getElement().getStyle().setCursor(tk.createCustomCursor(tk.createImage(""), new Point(0, 0), ""));
			
			Image loadingImage = new Image();
			loadingImage.setUrl("http://shiraz.usc.edu/negotiation/images/loading_small.gif");

			int[] pixels = new int[16 * 16];
		    Image image = Toolkit.getDefaultToolkit().createImage(
		        new MemoryImageSource(16, 16, pixels, 0, 16));
		    Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    		Toolkit.getImage("http://shiraz.usc.edu/negotiation/images/loading_small.gif"), new Point(0, 0), "invisibleCursor");*/
		    
//			tradingBoardWidget.getElement().getStyle().setCursor(Cursor.WAIT);			
//			getElement().getStyle().setCursor(Cursor.WAIT);

/*			// disable user interaction
			Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
                public void onPreviewNativeEvent(NativePreviewEvent pEvent) {
                    final Element target = pEvent.getNativeEvent().getEventTarget().cast();

                    // block all events targetted at the children of the composite.
                    if (DOM.isOrHasChild(getElement(), target)) {
                        pEvent.cancel();
                    }                    
                }
            });*/
		};
		

		
	};


	@Override
	public void updateTradingActionButtonEnablementBasedOnTradingBoardState(final AgentEnum agentWhoseTurnItIs, final Proposal mostRecentlyOfferedProposal) {

		/*
		 * When one or more objects is not allocated to either agent, the
		 * dynamic trading board state does not yield an offerable proposal.
		 * In these cases, proposal offer buttons are visible, but disabled.
		 */
		if (AgentEnum.player.equals(agentWhoseTurnItIs)) {
			final Button makeInitialProposal = tradingActionButtons.get(TradingActionEnum.makeInitialProposal);
			final Button makeCounterproposal = tradingActionButtons.get(TradingActionEnum.makeCounterproposal);

			if (tradingBoardWidget.representsValidProposal()) {
				makeInitialProposal.setEnabled(makeInitialProposal.isVisible());
				makeCounterproposal.setEnabled(makeCounterproposal.isVisible());
			} else {
				makeInitialProposal.setEnabled(false);
				makeCounterproposal.setEnabled(false);
			};
		};
	/*	//if its the player's turn and the state of the board has changed 
		final Button acceptProposal = tradingActionButtons.get(TradingActionEnum.acceptProposal);
		final TradingAction lastTrade = negotiationSession.getMostRecentProposal(); 
		
		if (AgentEnum.player.equals(agentWhoseTurnItIs)) {acceptProposal.setEnabled(false);};*/
		//if its the player's turn and the state of the board has changed 
		final Button acceptProposal = tradingActionButtons.get(TradingActionEnum.acceptProposal);
		final Button makeCounterProposal = tradingActionButtons.get(TradingActionEnum.makeCounterproposal);
		if (AgentEnum.player.equals(agentWhoseTurnItIs) & tradingBoardWidget.dropped) {acceptProposal.setEnabled(false);};
		if (AgentEnum.player.equals(agentWhoseTurnItIs) & !tradingBoardWidget.dropped) {makeCounterProposal.setEnabled(false);};
	};


	@Override
	public void setTradingBoardState(final TradingBoardState newTradingBoardState) {
		tradingBoardWidget.setState(newTradingBoardState);
	};


	@Override
	public void updateTradingAreaViewAfterTradingBoardStateChange() {
		tradingBoardWidget.updateTradingBoardAfterTradingBoardStateChange();
		final EnumMap<AgentEnum, Integer> proposalValue = tradingBoardWidget.getState().getProposalValue();
		for (final AgentEnum agentEnum: AgentEnum.values()) {
			agentDealValuationWidgets.get(agentEnum).setDealValue(ValuationCategoryEnum.proposalAsDiagrammed, proposalValue.get(agentEnum));
		};
		final TradingObjectSetEnum tradingObjectSetEnum = this.tradingBoardWidget.getState().getTradingObjectSetEnum();
		counterpartObjectValuation.setTradingObjectSetEnum(tradingObjectSetEnum);
		playerObjectValuation.setTradingObjectSetEnum(tradingObjectSetEnum);
				
	};

	@Override
	public void showNegotiationConcludedDialogBox(final ExperimentConditions experimentConditions, final NegotiationSession negotiationSession) {
//		public void showNegotiationConcludedDialogBox(final ExperimentConditions experimentConditions) {
		Timer timer = new Timer() {
			public void run() {
/*				final Button acceptProposal = tradingActionButtons.get(TradingActionEnum.acceptProposal);
				final Button divideProposal = tradingActionButtons.get(TradingActionEnum.claimBATNAValue);
				
		    	acceptProposal.setEnabled(false);
		    	divideProposal.setEnabled(false);*/
		    	
//				final NegotiationConcludedDialogBox dialogBox = new NegotiationConcludedDialogBox(eventBus, experimentConditions);
				final NegotiationConcludedDialogBox dialogBox = new NegotiationConcludedDialogBox(eventBus, experimentConditions, negotiationSession);
				dialogBox.setPopupPosition(105, 75);
				dialogBox.show();
//				dialogBox.center();
			}
	    };
//	    timer.schedule(2000);
	    timer.schedule(1000);
	};

/*	@Override
	public void showStartGameHelpWindowDialogBox(final int temp) {
		final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, temp);
		dialogBox.center();
	};*/
	
	@Override
	public void showStartGameHelpWindowDialogBox(final int temp, final ExperimentConditions experimentConditions) {
		final StartGameHelpWindowDialogBox dialogBox = new StartGameHelpWindowDialogBox(eventBus, temp, experimentConditions);
//		dialogBox.center();
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();
	};
	
	@Override
	public void showPartnerLabelDialogBox(final ExperimentConditions experimentConditions) {
/*		final PartnerLabelDialogBox dialogBox = new PartnerLabelDialogBox(eventBus, experimentConditions);
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();
		Timer timer = new Timer() {
			public void run() {
				dialogBox.hide();
			}
		};
		
	    timer.schedule(5000); 		// 5sec delay */
	    
		final PartnerLabelDialogBox dialogBox = new PartnerLabelDialogBox(eventBus, experimentConditions);
		
		Timer timer = new Timer() {
			@Override
			public void run() {
				final PartnerAssignmentDialogBox dialogBox1 = new PartnerAssignmentDialogBox(eventBus, experimentConditions);

				Timer timer1 = new Timer() {
					@Override
					public void run() {
						final PartnerAssignmentResultDialogBox dialogBox2 = new PartnerAssignmentResultDialogBox(eventBus, experimentConditions);
						Timer timer2 = new Timer() {
							@Override
							public void run() {
								dialogBox2.hide();										
							}
						};
						dialogBox2.setPopupPosition(105, 75);
						dialogBox2.show();
					    timer2.schedule(5000);				
						dialogBox1.hide();
					}
				};
				dialogBox1.setPopupPosition(105, 75);
				dialogBox1.show();
				timer1.schedule((int)(Math.random() * (17000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 17sec;
				dialogBox.hide();
			}
		};
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();
	    timer.schedule(5000); 		// 5sec delay
	}
	
	public void showScenarioDialogBox (final ExperimentConditions experimentConditions) {
		Timer timer = new Timer() {
		      public void run() {
		    	  final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
		    	  dialogBox.center();
		      }
		    };
		    timer.schedule(1000);	
	};

	public void reviewScenarioDialogBox () {
		Timer timer = new Timer() {
		      public void run() {
		    	  final ScenarioDialogBox dialogBox = new ScenarioDialogBox (expScenario);
		    	  dialogBox.center();
		      }
		    };
		    timer.schedule(1000);	
	};
	
	@Override
	public void setScenario(final int expScenario) {
//	public void setCounterpartInformationVisibilityAndBATNAValues(final ExperimentConditions experimentConditions) {
		this.expScenario = expScenario;
	};
	
	@Override
	public void setPartnerLabel(final int partnerLabel) {
		this.partnerLabel = partnerLabel;
	};
	

	@Override
	public void showPreGameQuestionnaireDialogBox(final int temp,final ExperimentConditions experimentConditions) {
		//final PreGameQuestionnaireDialogBox dialogBox;
		Timer timer = new Timer() {
		      public void run() {
		    	  final PreGameQuestionnaire1DialogBox dialogBox  = new PreGameQuestionnaire1DialogBox(eventBus, experimentConditions);
		    	  dialogBox.center();
		      }
		    };
		    timer.schedule(2000);
	};


	@Override
	public void showDemographicsDialogBox(ExperimentConditions experimentConditions) {
		final DemographicsDialogBox dialogBox = new DemographicsDialogBox(eventBus, experimentConditions);
//		dialogBox.center();
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();
	};
	
	@Override
	public void showPostGameQuestionnaireDialogBox(ExperimentConditions experimentConditions) {
		final PostGameQuestionnaireDialogBox dialogBox = new PostGameQuestionnaireDialogBox(eventBus, experimentConditions);
		dialogBox.center();
	};
	
	@Override
	public void showLastRoundHelpWindowDialogBox(final int temp) {
		Timer timer = new Timer() {
		      public void run() {
		    	  final LastRoundHelpWindowDialogBox dialogBox = new LastRoundHelpWindowDialogBox(eventBus);
		    	  dialogBox.center();
		    	  
		    	  
		      }
		};
		timer.schedule(1000);
	};
	
	@Override
//	public void showReviewingOfferDialogBox(final int[][] tradingObjectAllocations) {
//	public void showReviewingOfferDialogBox(final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession) {
	public void showReviewingOfferDialogBox(final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession, final ExperimentConditions experimentConditions) {
/*	final ReviewingOfferDialogBox dialogBox = new ReviewingOfferDialogBox(eventBus);
  	  dialogBox.setPopupPosition(0, 235);
  	  dialogBox.show();*/

		Timer timer = new Timer() {
		      public void run() {
		    	  final double timestamp = Duration.currentTimeMillis();
		    	  final TradingAction newTradingAction = new TradingAction(AgentEnum.counterpart, timestamp, TradingActionEnum.endProposalReview, null);
		    	  TradingAreaView.this.eventBus.fireEvent(new EndProposalReviewEvent(newTradingAction));

//		    	  dialogBox.hide();
//		      	  final OfferAcceptanceDialogBox dialogBoxOfferAcceptance = new OfferAcceptanceDialogBox(eventBus, tradingObjectAllocations);
//		      	  final OfferAcceptanceDialogBox dialogBoxOfferAcceptance = new OfferAcceptanceDialogBox(eventBus, newTradingBoardState, negotiationSession);
		    	  final ReportFacialExpressionDialogBox dialogBoxReportFacialExpression = new ReportFacialExpressionDialogBox(eventBus, newTradingBoardState, negotiationSession, experimentConditions);
		    	  dialogBoxReportFacialExpression.setPopupPosition(105, 75);
		    	  dialogBoxReportFacialExpression.show();
		    	  
/*		    	  final OfferAcceptanceStartDialogBox dialogBoxOfferAcceptanceStart = new OfferAcceptanceStartDialogBox(eventBus, partnerLabel);
		    	  dialogBoxOfferAcceptanceStart.setPopupPosition(105, 75);
		    	  dialogBoxOfferAcceptanceStart.show();
		    	  
		    	  Timer timer1 = new Timer() {
		    		  public void run() {
				      	  final OfferAcceptanceDialogBox dialogBoxOfferAcceptance = new OfferAcceptanceDialogBox(eventBus, newTradingBoardState, negotiationSession, experimentConditions);
				      	  dialogBoxOfferAcceptance.setPopupPosition(105, 75);
				      	  dialogBoxOfferAcceptanceStart.hide();
				      	  dialogBoxOfferAcceptance.show();  
		    		  }
		    	  };
		    	  timer1.schedule(10000); 						// 10 sec delay for reviewing*/
		      }
		};
		
//		int randomDelay =(int)(Math.random() * (8000 - 5000 + 1) + 5000);
//		if(negotiationSession.getPlyRemaining() > 3) { 	// not the last round
/*		if(negotiationSession.getPlyRemaining() > 5) { 	// not the last round
			timer.schedule(10000); 						// 10 sec delay for reviewing
		} else {										// last round
			timer.schedule(20000);						// 20 sec delay
		}*/
		timer.schedule(10000); 						// 10 sec delay for reviewing
	};

/*//	public void showLastRoundInfoDialogBox(final NegotiationSession negotiationSession) {
	public void showLastRoundInfoDialogBox(final NegotiationSession negotiationSession, final int partnerLabel, final TradingAction tradingAction) {
		final LastRoundInfoDialogBox lastRoundDialogBox = new LastRoundInfoDialogBox(eventBus, partnerLabel, negotiationSession);
		
		Timer timer = new Timer() {
		      public void run() {
		    	  showProposalResultDialogBox("rejected", partnerLabel, tradingAction);
		    	  
//		    	  final double timestamp = Duration.currentTimeMillis();
//		    	  tradingAction.setTimestamp(timestamp);
//		    	  TradingAreaView.this.eventBus.fireEvent(new ProposalMadeEvent(tradingAction));
		    	  lastRoundDialogBox.hide();
		      }
		};

		lastRoundDialogBox.setPopupPosition(105, 75);
		lastRoundDialogBox.show();
		timer.schedule(10000);	// 10 sec delay for reading
	};*/

	
//	@Override
//	public void showProposalResultDialogBox(final String temp) {
//		final ProposalResultDialogBox dialogBox = new ProposalResultDialogBox(temp);
//		dialogBox.center();
//};
	
	@Override	
	public void showProposalResultDialogBox(final String temp, final ExperimentConditions experimentConditions, final TradingAction tradingAction, final int plyRemaining) {
//	public void showProposalResultDialogBox(final String temp, final int partnerLabel, final TradingAction tradingAction, final int plyRemaining) {
//	public void showProposalResultDialogBox(final String temp, final int partnerLabel, final TradingAction tradingAction) {
		
		final WaitingDialogBox waitingOfferReviewDialogBox = new WaitingDialogBox (eventBus, "waitForOfferReview", partnerLabel);
		
		Timer timer = new Timer() {
			public void run() {
				final ReviewReportedFacialExpressionDialogBox emotionDialogBox = new ReviewReportedFacialExpressionDialogBox(eventBus, temp, experimentConditions, tradingAction, plyRemaining);
//				final ReviewReportedFacialExpressionDialogBox emotionDialogBox = new ReviewReportedFacialExpressionDialogBox(eventBus, temp, partnerLabel, tradingAction, plyRemaining);
				
/*				Timer timer0 = new Timer() {
					public void run() {
						final WaitingDialogBox waitingDialogBox = new WaitingDialogBox (eventBus, "waitForCounterpart", partnerLabel);
						final ProposalResultDialogBox resultDialogBox = new ProposalResultDialogBox(temp, partnerLabel);
						final ProposalResultDelayDialogBox resultDelayDialogBox = new ProposalResultDelayDialogBox(temp, partnerLabel);
						
						Random random = new Random();
						final int rand = random.nextInt(5);
				//		final int rand = 0; // for testing
				
				
						Timer timer1 = new Timer() { // ek: added waiting msg
				//        @Override
							public void run() {
								Timer timer2 = new Timer() {
								      public void run() {
								    	  final double timestamp = Duration.currentTimeMillis();
								    	  tradingAction.setTimestamp(timestamp);
				
								    	  String acceptedStr = "accepted";
				//				    	  String rejectedStr = "rejected";
				
								    	  if(temp.equals(acceptedStr))
								    		  TradingAreaView.this.eventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
				
											Timer timer3 = new Timer() {
											      public void run() {
											    	  final double timestamp = Duration.currentTimeMillis();
											    	  tradingAction.setTimestamp(timestamp);
							
				//							    	  String acceptedStr = "accepted";
											    	  String rejectedStr = "rejected";
							
				//							    	  if(temp.equals(acceptedStr))
				//							    		  TradingAreaView.this.eventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
				//							    	  else if(temp.equals(rejectedStr))
											    	  if(temp.equals(rejectedStr))
											    		  showOfferReviewStartDialogBox(partnerLabel, tradingAction, plyRemaining);
							//				    		  showOfferReviewStartDialogBox(partnerLabel, tradingAction);
							//				    		  TradingAreaView.this.eventBus.fireEvent(new ProposalMadeEvent(tradingAction));
											    	  
												      if(partnerLabel == 1 && rand == 0 && temp.equals(rejectedStr)) {
												    	  resultDelayDialogBox.hide();
												      }
				
												      resultDialogBox.hide();
											    	  }
											      };
											      
										    	  String rejectedStr = "rejected";
											      if(partnerLabel == 1 && rand == 0 && temp.equals(rejectedStr)) {
											    	  resultDelayDialogBox.setPopupPosition(105, 75);
											    	  resultDelayDialogBox.show();
											    	  timer3.schedule((int)(Math.random() * (18000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 18sec
											      } else {
											    	  timer3.schedule(1);
											      }
								      }
								};
				
								resultDialogBox.setPopupPosition(105, 75);
								resultDialogBox.show();
								
								String acceptedStr = "accepted";
								if(temp.equals(acceptedStr))
									timer2.schedule(5000);	// 5 sec delay for reading
								else 
									timer2.schedule((int)(Math.random() * (18000 - 15000 + 1) + 15000)); 		// random delay between 15sec and 18sec
								waitingDialogBox.hide();
							}
						};
						waitingDialogBox.setPopupPosition(105, 75);
						waitingDialogBox.show(); // EK 10/27/2014: pop up the screen in the left uppermost area
						
						timer1.schedule((int)(Math.random() * (3000 - 2000 + 1) + 2000)); 		// random delay between 2sec and 3sec

					}
				};*/
				
				emotionDialogBox.setPopupPosition(105, 75);
				emotionDialogBox.show();
				waitingOfferReviewDialogBox.hide();

//				timer0.schedule(5000); 		// 5sec delay
			}
		};
		waitingOfferReviewDialogBox.setPopupPosition(105, 75);
		waitingOfferReviewDialogBox.show(); // EK 10/27/2014: pop up the screen in the left uppermost area
		
		timer.schedule((int)(Math.random() * (12000 - 11000 + 1) + 11000)); 		// random delay between 11sec and 12sec			
		
	};
	
//	public void showOfferReviewStartDialogBox(final int partnerLabel, final TradingAction tradingAction) {
	public void showOfferReviewStartDialogBox(final int partnerLabel, final TradingAction tradingAction, final int plyRemaining) {
		final OfferReviewStartDialogBox dialogBox = new OfferReviewStartDialogBox(eventBus, partnerLabel, tradingAction, plyRemaining);
		
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();		
	}
	
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


	public boolean isTradingBoardEnabled() {
		final boolean result = this.tradingBoardWidget.isEnabled();
		return result;
	};


	public void setTradingBoardEnabled(final boolean enabled) {
		this.tradingBoardWidget.setEnabled(enabled);
	}

	@Override
	public void showParticipantIDBox(final ExperimentConditions experimentConditions) {
		final ParticipantIDDialogBox dialogBox = new ParticipantIDDialogBox (eventBus, experimentConditions);
		dialogBox.setPopupPosition(105, 75);
		dialogBox.show();

/*		Timer timer = new Timer() {
		      public void run() {
		    	  final ParticipantIDDialogBox dialogBox = new ParticipantIDDialogBox (eventBus, experimentConditions);
		    	 // final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
//		    	  dialogBox.center();
		    	  dialogBox.setPopupPosition(105, 75);
		    	  dialogBox.show();
		      }
		    };
		    timer.schedule(1000);*/
		
	};
};
