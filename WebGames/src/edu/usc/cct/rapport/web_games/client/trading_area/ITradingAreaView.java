package edu.usc.cct.rapport.web_games.client.trading_area;


import edu.usc.cct.rapport.web_games.client.IWebGamesView;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public interface ITradingAreaView extends IWebGamesView {

	void setTradingBoardEnabled(final boolean enabled);
	void setTradingBoardState(final TradingBoardState newTradingBoardState);
	void setCounterpartInformationVisibilityAndBATNAValues(final ExperimentConditions experimentConditions);
	void setCounterpartEmotionState(final FacialExpressionEnum agentEmotionEnum);
	void setFacialExpressionStyle(final FacialExpressionStyleEnum facialExpressionStyleEnum);
	void updateTradingActionButtonAvailabilityWithoutRegardToTradingBoardState(final NegotiationSession negotiationSession);
	void updateTradingAreaViewAfterTradingBoardStateChange();
	void updateTradingActionButtonEnablementBasedOnTradingBoardState(final AgentEnum agentWhoseTurnItIs, final Proposal mostRecentlyOfferedProposal);
//	void showNegotiationConcludedDialogBox(final ExperimentConditions experimentConditions);
	void showNegotiationConcludedDialogBox(final ExperimentConditions experimentConditions, final NegotiationSession negotiationSession);
//	void showStartGameHelpWindowDialogBox(final int temp);
	void showStartGameHelpWindowDialogBox(final int temp, ExperimentConditions experimentConditions);
	void showPostGameQuestionnaireDialogBox(ExperimentConditions experimentConditions);
	void showDemographicsDialogBox(ExperimentConditions experimentConditions);
	void showLastRoundHelpWindowDialogBox(final int temp);
//	void showReviewingOfferDialogBox(final int[][] tradingObjectAllocations);
	void showReviewingOfferDialogBox(final TradingBoardState newTradingBoardState, final NegotiationSession negotiationSession);
	void showPreGameQuestionnaireDialogBox (final int temp, ExperimentConditions experimentConditions);
	void showParticipantIDBox (final ExperimentConditions experimentConditions);
	void showScenarioDialogBox (ExperimentConditions experimentConditions);
	void setPlayerInformationVisibilityAndBATNAValues(final ExperimentConditions experimentConditions);
	void showProposalResultDialogBox(final String temp);
	void setScenario(final int expScenario);
};
