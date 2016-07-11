package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;

public enum TradingActionEnum {
	partnerTypeNotification,
	connectionEstablished,
	makeInitialProposal,
	endWaitingForAgentsOfferReview,
	checkAgentsReportedEmotion,
	endWaitingForAgentsOfferAcceptance,
	showAgentsOfferAcceptanceResult,
//	reviewProposal,
	endProposalReview,
	reportSelfEmotion,
	decidingOfferAcceptance,
	endCoinTossResultReview,
	endWaiting,
	acceptProposal,
	rejectProposal,
	makeCounterproposal,
	claimBATNAValue;
//	reviewScenario;


	static final private TradingActionsInternationalizationConstants constants = GWT.create(TradingActionsInternationalizationConstants.class);


	String getButtonDescription() {

		String result;

		switch (this) {
		case partnerTypeNotification:
		case connectionEstablished:
			result = "";
			break;
		case makeInitialProposal:
			result = constants.makeInitialProposal();
			break;
		case acceptProposal:
			result = constants.acceptProposal();
			break;
		case rejectProposal:
			result = constants.rejectProposal();
			break;
		case makeCounterproposal:
			result = constants.makeCounterproposal();
			break;
		case claimBATNAValue:
			result = constants.claimBATNAScore();
			break;
		case endProposalReview:
			result = "";
			break;
		case endCoinTossResultReview:
			result = "";
			break;
		case endWaiting:
		case endWaitingForAgentsOfferReview:
		case checkAgentsReportedEmotion:
		case endWaitingForAgentsOfferAcceptance:
		case showAgentsOfferAcceptanceResult:
		case reportSelfEmotion:
		case decidingOfferAcceptance:
			result = "";
			break;			
//		case reviewScenario:
//			result = constants.reviewScenario();
//			break;
		default:
			throw new IllegalStateException("Unhandled TradingActionEnum in TradingActionEnum.getDescription().");
		};

		return result;
	};


	String getDialogBoxDescription() {

		String result;

		switch (this) {
		case partnerTypeNotification:
		case connectionEstablished:
			result = "";
			break;
		case acceptProposal:
			result = constants.agreementReached();
			break;
		case claimBATNAValue:
			result = constants.agreementNotReached();
			break;
		case rejectProposal:
			result = constants.rejectProposal();
			break;
		case endProposalReview:
			result = "";
			break;
		case endCoinTossResultReview:
			result = "";
			break;
		case endWaiting:
		case endWaitingForAgentsOfferReview:
		case checkAgentsReportedEmotion:
		case endWaitingForAgentsOfferAcceptance:
		case showAgentsOfferAcceptanceResult:
		case reportSelfEmotion:
		case decidingOfferAcceptance:
			result = "";
			break;			
//		case reviewScenario:
//			result = constants.reviewScenario();
//			break;
		case makeInitialProposal:
		case makeCounterproposal:
			final IllegalStateException iseNegotiationSessionCannotFinishWithProposalOffer = new IllegalStateException("The negotiation session should not have ended with a proposal being offered.");
			throw iseNegotiationSessionCannotFinishWithProposalOffer;
		default:
			final IllegalStateException iseUnhandledTradingActionEnum = new IllegalStateException("Unhandled TradingActionEnum in TradingActionEnum.getDescription().");
			throw iseUnhandledTradingActionEnum;
		};

		return result;
	};

};
