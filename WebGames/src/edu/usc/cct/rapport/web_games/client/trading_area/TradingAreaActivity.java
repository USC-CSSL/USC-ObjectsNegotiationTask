package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.Random;

import com.google.gwt.core.client.Duration;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
//import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.usc.cct.rapport.web_games.client.WebGamesActivity;
import edu.usc.cct.rapport.web_games.client.parting.PartingPlace;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEvent;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditionsDecodedEventHandler;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.AlgorithmicCounterpartDecisionMakingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making.ProposalDecisionMakingStrategy;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionModellingStrategyEnum;
import edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling.EmotionalModelOfAlgorithmicCounterpart;


public class TradingAreaActivity extends WebGamesActivity implements ITradingAreaActivity {

	final private class RetrieveAndApplyExperimentConditions implements ExperimentConditionsDecodedEventHandler {
		@Override
		public void onExperimentConditionsDecoded(final ExperimentConditionsDecodedEvent event) {
			Random random = new Random();
			Random otherRandom= new Random ();
//			final int whichEmotion = random.nextInt(2);
			final int whichStrategy2 = otherRandom.nextInt(2);
			final int whichEmotion = random.nextInt(3);
			final int whichStrategy4 = otherRandom.nextInt(4);
			final int whichScenario = random.nextInt(2);

			TradingAreaActivity.this.experimentConditions = event.getExperimentConditions();
			TradingAreaActivity.this.negotiationSession = new NegotiationSession(TradingAreaActivity.this.experimentConditions.getTradingObjectSetEnum(), TradingAreaActivity.this.experimentConditions.getNegotiationSessionPlyCount(), TradingAreaActivity.this.experimentConditions.getAgentWhoActsLastIfNoAgreementIsReached());
			
/*			if(experimentConditions.getExpScenario()==1 & whichScenario==0) {
				experimentConditions.setExpScenario(2);
			} else if(experimentConditions.getExpScenario()==1 &  whichScenario==1){
				experimentConditions.setExpScenario(3);
			} else if(experimentConditions.getExpScenario()==1 &  whichScenario==2){
				experimentConditions.setExpScenario(4);
			}
			experimentConditions.setExpScenario(1);*/
			if(experimentConditions.getExpScenario()==3 & whichScenario==0) {
				experimentConditions.setExpScenario(4);				
			} else if(experimentConditions.getExpScenario()==3 &  whichScenario==1){
				experimentConditions.setExpScenario(5);
			}
			
			AlgorithmicCounterpartDecisionMakingStrategyEnum algorithmicCounterpartDecisionMakingStrategyEnum = TradingAreaActivity.this.experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart(); 
			if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy2) & whichStrategy2==0){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedConceder;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} else if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy2) & whichStrategy2==1){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconceder;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			}
			
			if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy) & whichStrategy4==0){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedConceder;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} else if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy) & whichStrategy4==1){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconceder;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} else if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy) & whichStrategy4==2){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedConcederGentleSlope;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} else if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.randomStrategy) & whichStrategy4==3){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedNonconcederSteepSlope;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} 
			
			if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.SymbolicOrFinancialAgents) & whichStrategy2==0){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedSymbolicAgent;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			} else if(algorithmicCounterpartDecisionMakingStrategyEnum.equals(AlgorithmicCounterpartDecisionMakingStrategyEnum.SymbolicOrFinancialAgents) & whichStrategy2==1){
				algorithmicCounterpartDecisionMakingStrategyEnum = AlgorithmicCounterpartDecisionMakingStrategyEnum.prespecifiedFinancialAgent;
				TradingAreaActivity.this.experimentConditions.setDecisionMakingStrategyOfAlgorithmicCounterpart(algorithmicCounterpartDecisionMakingStrategyEnum);
			}

			TradingAreaActivity.this.proposalDecisionMakingStrategyOfAlgorithmicCounterpart = TradingAreaActivity.this.experimentConditions.getDecisionMakingStrategyOfAlgorithmicCounterpart().getProposalDecisionMakingStrategy(TradingAreaActivity.this.experimentConditions.getNegotiationSessionPlyCount());
			
			EmotionModellingStrategyEnum emotionModellingPolicyEnum = TradingAreaActivity.this.experimentConditions.getEmotionalModellingPolicyEnum();

			// randomEveryOtherTurnSadOrAngryOrNeutral
			if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomEveryOtherTurnSadOrAngryOrNeutral) & whichEmotion==0){	
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.everyOtherTurnAngry;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}
			
			else if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomEveryOtherTurnSadOrAngryOrNeutral) & whichEmotion==1){
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.everyOtherTurnSad;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}	

			else if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomEveryOtherTurnSadOrAngryOrNeutral)){
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.alwaysNeutral;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}	

			// after134SadOrAngryOrNeutral
			if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomAfter134SadOrAngryOrNeutral) & whichEmotion==0){	
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.after134Angry;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}
			
			else if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomAfter134SadOrAngryOrNeutral) & whichEmotion==1){
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.after134Sad;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}	

			else if (emotionModellingPolicyEnum.equals(EmotionModellingStrategyEnum.randomAfter134SadOrAngryOrNeutral)){
				emotionModellingPolicyEnum = EmotionModellingStrategyEnum.alwaysNeutral;
				TradingAreaActivity.this.experimentConditions.setEmotionalReactionDeterminationStrategyOfAlgorithmicCounterpart(emotionModellingPolicyEnum);}	

			TradingAreaActivity.this.emotionalModelOfAlgorithmicCounterpart = new EmotionalModelOfAlgorithmicCounterpart(0.0, emotionModellingPolicyEnum.getEmotionModellingStrategy(), TradingAreaActivity.this.negotiationSession, TradingAreaActivity.this.experimentConditions.getPlayerBATNA(), TradingAreaActivity.this.experimentConditions.getCounterpartBATNA(),emotionModellingPolicyEnum);
			TradingAreaActivity.this.view.setCounterpartInformationVisibilityAndBATNAValues(TradingAreaActivity.this.experimentConditions);
			TradingAreaActivity.this.view.setPlayerInformationVisibilityAndBATNAValues(TradingAreaActivity.this.experimentConditions);
			TradingAreaActivity.this.view.setFacialExpressionStyle(TradingAreaActivity.this.experimentConditions.getFacialExpressionStyleEnum());
			final FacialExpressionEnum initialCounterpartEmotionState = TradingAreaActivity.this.emotionalModelOfAlgorithmicCounterpart.getFacialExpressionEnum();
			final double timestamp = Duration.currentTimeMillis();
//			TradingAreaActivity.this.view.setCounterpartEmotionState(initialCounterpartEmotionState);
			resettableEventBus.fireEvent(new FacialExpressionChosenEvent(new TradingExpression(AgentEnum.counterpart, timestamp, initialCounterpartEmotionState)));
			resettableEventBus.fireEvent(new FacialExpressionChosenEvent(new TradingExpression(AgentEnum.player, timestamp, FacialExpressionEnum.neutral)));
			final TradingBoardState initialTradingBoardState = new TradingBoardState(TradingAreaActivity.this.experimentConditions.getTradingObjectSetEnum());
			TradingAreaActivity.this.updateTradingArea(initialTradingBoardState, negotiationSession);
			TradingAreaActivity.this.executeCounterpartTurnIfNecessary(TradingAreaActivity.this.experimentConditions.getPlayerBATNA(), TradingAreaActivity.this.experimentConditions.getCounterpartBATNA(), TradingAreaActivity.this.negotiationSession);
			TradingAreaActivity.this.view.setScenario(TradingAreaActivity.this.experimentConditions.getExpScenario());
		};
	};


	final private class TrackFacialExpressionChoice implements FacialExpressionChosenHandler {
		@Override
		public void onChoosingOfFacialExpression(final FacialExpressionChosenEvent event) {
			TradingAreaActivity.this.negotiationSession.add(event.getTradingExpression());
		};
	};


	final private class HandleUserActionAndExecuteTurnOfAlgorithmicOpponent implements ProposalMadeEventHandler {
		@Override
		public void onMakingOfProposal(final ProposalMadeEvent event) {
			assert (negotiationSession.getWhoseTurnIsNext().equals(event.getTradingAction().getPerformingAgent()));
			TradingAreaActivity.this.negotiationSession.add(event.getTradingAction());
			final TradingBoardState newTradingBoardState = new TradingBoardState(TradingAreaActivity.this.experimentConditions.getTradingObjectSetEnum(), TradingAreaActivity.this.negotiationSession.getMostRecentProposal());
			TradingAreaActivity.this.updateTradingArea(newTradingBoardState, TradingAreaActivity.this.negotiationSession);
			TradingAreaActivity.this.executeCounterpartTurnIfNecessary(TradingAreaActivity.this.experimentConditions.getPlayerBATNA(), TradingAreaActivity.this.experimentConditions.getCounterpartBATNA(), TradingAreaActivity.this.negotiationSession);
		};
	};


	final private class UpdateViewToSyncWithBoardStateChange implements TradingBoardStateChangedEventHandler {
		@Override
		public void onTradingBoardStateChange(final TradingBoardStateChangedEvent event) {
			view.updateTradingAreaViewAfterTradingBoardStateChange();
			view.updateTradingActionButtonEnablementBasedOnTradingBoardState(negotiationSession.getWhoseTurnIsNext(), negotiationSession.getMostRecentProposal());
		};
	};
	
	final private class HandleUserActionAndUpdate implements ProposalRejectedEventHandler {
		@Override
		public void onProposalRejection(final ProposalRejectedEvent event) {
//			assert (negotiationSession.getWhoseTurnIsNext().equals(event.getTradingAction().getPerformingAgent()));
			TradingAreaActivity.this.negotiationSession.add(event.getTradingAction());
		}
	}


	final private class HandleTasksUponNegotiationSessionConclusion implements ProposalAcceptedEventHandler, BATNAClaimMadeEventHandler {

		@Override
		public void onBATNAClaim(final BATNAClaimMadeEvent event) {
			assert(null == TradingAreaActivity.this.finalExperimentInformation);
			assert (negotiationSession.getWhoseTurnIsNext().equals(event.getTradingAction().getPerformingAgent()));
			TradingAreaActivity.this.negotiationSession.add(event.getTradingAction());
			TradingAreaActivity.this.finalExperimentInformation = new ExperimentInformation(TradingAreaActivity.this.experimentConditions, TradingAreaActivity.this.negotiationSession/*, TradingActionEnum.claimBATNAValue*/);
			TradingAreaActivity.this.resettableEventBus.fireEvent(new NegotiationSessionConcludedEvent(TradingAreaActivity.this.finalExperimentInformation));
		};


		@Override
		public void onProposalAcceptance(final ProposalAcceptedEvent event) {
			assert(null == TradingAreaActivity.this.finalExperimentInformation);
			assert (negotiationSession.getWhoseTurnIsNext().equals(event.getTradingAction().getPerformingAgent()));
			TradingAreaActivity.this.negotiationSession.add(event.getTradingAction());
			TradingAreaActivity.this.finalExperimentInformation = new ExperimentInformation(TradingAreaActivity.this.experimentConditions, TradingAreaActivity.this.negotiationSession/*, TradingActionEnum.acceptProposal*/);
			TradingAreaActivity.this.resettableEventBus.fireEvent(new NegotiationSessionConcludedEvent(TradingAreaActivity.this.finalExperimentInformation));
		};
	};


	final private class PromptUserToAcknowledgeNegotiationConclusion implements NegotiationSessionConcludedEventHandler {
		@Override
		public void onNegotiationSessionConclusion(final NegotiationSessionConcludedEvent event) {
			assert(null != TradingAreaActivity.this.finalExperimentInformation);
//			TradingAreaActivity.this.view.showNegotiationConcludedDialogBox(TradingAreaActivity.this.experimentConditions);
			// EK 10/30/14: added negotiation session info
			TradingAreaActivity.this.view.showNegotiationConcludedDialogBox(TradingAreaActivity.this.experimentConditions, TradingAreaActivity.this.negotiationSession);
		};
	};


	//final private class LogExperimentInformation implements NegotiationSessionConcludedEventHandler {
	final private class LogExperimentInformation implements LogExperimentInformationEventHandler {
		@Override
		public void onLogExperimentInformationEvent(final LogExperimentInformationEvent event) {
			assert(null != TradingAreaActivity.this.finalExperimentInformation);
			@SuppressWarnings("unused") final ExperimentInformationRecorder recorder = new ExperimentInformationRecorder(TradingAreaActivity.this.resettableEventBus, TradingAreaActivity.this.finalExperimentInformation);
		};
	};


	final private class GoToPartingPlace implements NegotiationConclusionAcknowledgedEventHandler {
		@Override
		public void onNegotiationConclusionAcknowledgement(final NegotiationConclusionAcknowledgedEvent event) {
			Timer timer = new Timer() {
				public void run() {
					final PartingPlace newPlace = new PartingPlace(resettableEventBus, true);
					goTo(newPlace);
				}
			};
			timer.schedule(1000);
		};
	};


	final private ITradingAreaView view;

	private ExperimentConditions experimentConditions;

	// Dynamic Model.
	private NegotiationSession negotiationSession;
	private ProposalDecisionMakingStrategy proposalDecisionMakingStrategyOfAlgorithmicCounterpart;
	private EmotionalModelOfAlgorithmicCounterpart emotionalModelOfAlgorithmicCounterpart;

	private ExperimentInformation finalExperimentInformation;


	@Inject
	public TradingAreaActivity(final EventBus eventBus, final PlaceController placeController, final ITradingAreaPlace webGamesPlace) {
		super(eventBus, placeController, webGamesPlace);
		this.view = new TradingAreaView(eventBus, placeController);
		bind();
	};


	public void bind() {
		resettableEventBus.addHandler(ExperimentConditionsDecodedEvent.TYPE, new RetrieveAndApplyExperimentConditions());
		resettableEventBus.addHandler(NegotiationConclusionAcknowledgedEvent.TYPE, new GoToPartingPlace());
		resettableEventBus.addHandler(TradingBoardStateChangedEvent.TYPE, new UpdateViewToSyncWithBoardStateChange());
		resettableEventBus.addHandler(FacialExpressionChosenEvent.TYPE, new TrackFacialExpressionChoice());
		resettableEventBus.addHandler(ProposalMadeEvent.TYPE, new HandleUserActionAndExecuteTurnOfAlgorithmicOpponent());
		resettableEventBus.addHandler(BATNAClaimMadeEvent.TYPE, new HandleTasksUponNegotiationSessionConclusion());
		resettableEventBus.addHandler(ProposalAcceptedEvent.TYPE, new HandleTasksUponNegotiationSessionConclusion());
		resettableEventBus.addHandler(ProposalRejectedEvent.TYPE, new HandleUserActionAndUpdate());
		resettableEventBus.addHandler(NegotiationSessionConcludedEvent.TYPE, new PromptUserToAcknowledgeNegotiationConclusion());
		resettableEventBus.addHandler(LogExperimentInformationEvent.TYPE, new LogExperimentInformation());
	};


	public void updateTradingArea(final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession) {
		if (negotiationSession.getPlyRemaining() ==  TradingAreaActivity.this.experimentConditions.getNegotiationSessionPlyCount() & TradingAreaActivity.this.experimentConditions.getHelpWindowsVisible() ){
			//TradingAreaActivity.this.view.showStartGameHelpWindowDialogBox(1);
			//TradingAreaActivity.this.view.showScenarioDialogBox(TradingAreaActivity.this.experimentConditions);
			//TradingAreaActivity.this.view.showParticipantIDBox(TradingAreaActivity.this.experimentConditions); // EK 10/23/14: commented out for fMRI experiment
			TradingAreaActivity.this.experimentConditions.setParticipantID(Long.toString(System.currentTimeMillis()));
//		} else if (negotiationSession.getPlyRemaining() == 1 & TradingAreaActivity.this.experimentConditions.getHelpWindowsVisible() & AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext())){
//			TradingAreaActivity.this.view.showLastRoundHelpWindowDialogBox(1);
		} else if ((negotiationSession.getPlyRemaining()%3) == 2 & AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext())){
//		} else if (AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext())){
			// EK 10/08/14: added random delay
			TradingAreaActivity.this.view.showReviewingOfferDialogBox(newTradingBoardState, negotiationSession);
		} else {
			
		}
		
		if (negotiationSession.getPlyRemaining() ==  TradingAreaActivity.this.experimentConditions.getNegotiationSessionPlyCount() & TradingAreaActivity.this.experimentConditions.getHelpWindowsVisible() ){
			this.view.setTradingBoardState(newTradingBoardState);
			this.view.updateTradingActionButtonAvailabilityWithoutRegardToTradingBoardState(negotiationSession);
			this.view.updateTradingActionButtonEnablementBasedOnTradingBoardState(negotiationSession.getWhoseTurnIsNext(), negotiationSession.getMostRecentProposal());
			this.view.updateTradingAreaViewAfterTradingBoardStateChange();
			this.view.setTradingBoardEnabled(AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext()) && (1 < negotiationSession.getPlyRemaining()));
		} else {
			this.view.setTradingBoardState(newTradingBoardState);
			this.view.updateTradingActionButtonAvailabilityWithoutRegardToTradingBoardState(negotiationSession);
			this.view.updateTradingActionButtonEnablementBasedOnTradingBoardState(negotiationSession.getWhoseTurnIsNext(), negotiationSession.getMostRecentProposal());
			this.view.updateTradingAreaViewAfterTradingBoardStateChange();
			
			Timer timer = new Timer() {
				public void run() {
					TradingAreaActivity.this.view.setTradingBoardEnabled(AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext()) && (1 < negotiationSession.getPlyRemaining()));
				}
			};
			
	//		int randomDelay =(int)(Math.random() * (8000 - 5000 + 1) + 5000);
		    timer.schedule(5500); 		// 5.5sec delay
		    
			this.view.setTradingBoardEnabled(false);
		}
//		this.view.setTradingBoardEnabled(AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext()) && (1 < negotiationSession.getPlyRemaining()));
//		this.view.setReviewScenarioButtonEnabled("");
	};


	public void executeCounterpartTurnIfNecessary(final int playerBATNA, final int counterpartBATNA, final NegotiationSession negotiationSession) {
		final AgentEnum agentWhoseTurnIsNext = negotiationSession.getWhoseTurnIsNext();
		if (AgentEnum.counterpart.equals(agentWhoseTurnIsNext)) {
			if (null != negotiationSession.getMostRecentProposal()) {
				this.emotionalModelOfAlgorithmicCounterpart.update(negotiationSession.getMostRecentProposal());
			};
			final double timestamp = Duration.currentTimeMillis();
			final FacialExpressionEnum counterpartEmotionState = TradingAreaActivity.this.emotionalModelOfAlgorithmicCounterpart.getFacialExpressionEnum();
			this.view.setCounterpartEmotionState(counterpartEmotionState);
			///*
			Timer timer = new Timer() {
			      public void run() {
			    	  resettableEventBus.fireEvent(new FacialExpressionChosenEvent(new TradingExpression(AgentEnum.counterpart, timestamp, counterpartEmotionState)));
			      }
			    };
			    timer.schedule(3000);
			    //*/
			//resettableEventBus.fireEvent(new FacialExpressionChosenEvent(new TradingExpression(AgentEnum.counterpart, timestamp, counterpartEmotionState)));

			final TradingAction tradingAction = proposalDecisionMakingStrategyOfAlgorithmicCounterpart.determineAction(counterpartBATNA, negotiationSession);
			switch (tradingAction.getTradingActionEnum()) {
			case makeInitialProposal:
				assert(true);
			case makeCounterproposal:
//				if (negotiationSession.getPlyRemaining() == 1 & TradingAreaActivity.this.experimentConditions.getHelpWindowsVisible() & AgentEnum.player.equals(negotiationSession.getWhoseTurnIsNext())){
//					TradingAreaActivity.this.view.showLastRoundHelpWindowDialogBox(1);
//				} else {
//					TradingAreaActivity.this.view.showProposalResultDialogBox("rejected");
//				}

				resettableEventBus.fireEvent(new ProposalMadeEvent(tradingAction));
/*			    Timer t = new Timer() { // EK 10/08/14: added random delay
			        @Override
			        public void run() {
			        }
			      };
			      t.schedule((int)(Math.random() * (8000 - 5000 + 1) + 5000)); 		// random delay between 5sec and 8sec
*/
				break;
			case acceptProposal:
//				TradingAreaActivity.this.view.showProposalResultDialogBox("accepted");
				resettableEventBus.fireEvent(new ProposalAcceptedEvent(tradingAction));
				break;
			case claimBATNAValue:
				resettableEventBus.fireEvent(new BATNAClaimMadeEvent(tradingAction));
				break;
			default:
				assert(false);
			};
		};
	};


	@Override
	public void start(final AcceptsOneWidget container, final EventBus eventBus) {
		container.setWidget(this.view.asWidget());
	};

};
