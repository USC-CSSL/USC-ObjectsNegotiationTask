package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ProposalMadeEvent extends GwtEvent<ProposalMadeEventHandler> {

	static final Type<ProposalMadeEventHandler> TYPE = new Type<ProposalMadeEventHandler>();


	final private TradingAction tradingAction;


	public ProposalMadeEvent(final TradingAction tradingAction) {
		assert((TradingActionEnum.makeInitialProposal == tradingAction.getTradingActionEnum()) || (TradingActionEnum.makeCounterproposal == tradingAction.getTradingActionEnum()));
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ProposalMadeEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ProposalMadeEventHandler handler) {
		handler.onMakingOfProposal(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
