package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class ProposalAcceptedEvent extends GwtEvent<ProposalAcceptedEventHandler> {

	static final Type<ProposalAcceptedEventHandler> TYPE = new Type<ProposalAcceptedEventHandler>();


	final private TradingAction tradingAction;


	public ProposalAcceptedEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.acceptProposal == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<ProposalAcceptedEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final ProposalAcceptedEventHandler handler) {
		handler.onProposalAcceptance(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
