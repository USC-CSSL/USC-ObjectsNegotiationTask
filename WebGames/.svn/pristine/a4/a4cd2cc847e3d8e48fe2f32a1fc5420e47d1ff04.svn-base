package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class BATNAClaimMadeEvent extends GwtEvent<BATNAClaimMadeEventHandler> {

	static final Type<BATNAClaimMadeEventHandler> TYPE = new Type<BATNAClaimMadeEventHandler>();


	final private TradingAction tradingAction;


	public BATNAClaimMadeEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.claimBATNAValue == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<BATNAClaimMadeEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final BATNAClaimMadeEventHandler handler) {
		handler.onBATNAClaim(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
