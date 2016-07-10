package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class PartnerTypeNotificationEvent extends GwtEvent<PartnerTypeNotificationEventHandler> {

	static final Type<PartnerTypeNotificationEventHandler> TYPE = new Type<PartnerTypeNotificationEventHandler>();


	final private TradingAction tradingAction;


	public PartnerTypeNotificationEvent(final TradingAction tradingAction) {
		assert(TradingActionEnum.partnerTypeNotification == tradingAction.getTradingActionEnum());
		this.tradingAction = tradingAction;
	};


	@Override
	public Type<PartnerTypeNotificationEventHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final PartnerTypeNotificationEventHandler handler) {
		handler.onPartnerTypeNotification(this);
	};


	public TradingAction getTradingAction() {
		return tradingAction;
	};

};
