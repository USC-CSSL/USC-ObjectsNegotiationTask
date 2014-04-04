package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.event.shared.GwtEvent;

public class FacialExpressionChosenEvent extends GwtEvent<FacialExpressionChosenHandler> {

	static final Type<FacialExpressionChosenHandler> TYPE = new Type<FacialExpressionChosenHandler>();


	final private TradingExpression tradingExpression;


	public FacialExpressionChosenEvent(final TradingExpression tradingExpression) {
		this.tradingExpression = tradingExpression;
	};


	@Override
	public Type<FacialExpressionChosenHandler> getAssociatedType() {
		return TYPE;
	};


	@Override
	protected void dispatch(final FacialExpressionChosenHandler handler) {
		handler.onChoosingOfFacialExpression(this);
	};


	public TradingExpression getTradingExpression() {
		return tradingExpression;
	};

};
