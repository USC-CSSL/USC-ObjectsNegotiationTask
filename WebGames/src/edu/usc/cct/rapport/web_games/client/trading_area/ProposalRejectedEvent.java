package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ProposalRejectedEvent extends GwtEvent<ProposalRejectedEventHandler> {

	static final Type<ProposalRejectedEventHandler> TYPE = new Type<ProposalRejectedEventHandler>();


	final private TradingAction tradingAction;


	public ProposalRejectedEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.rejectProposal == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ProposalRejectedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ProposalRejectedEventHandler handler) {
		handler.onProposalRejection(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
