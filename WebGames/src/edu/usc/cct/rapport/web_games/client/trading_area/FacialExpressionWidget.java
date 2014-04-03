package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;

import edu.usc.cct.rapport.web_games.client.WebGamesClientBundle;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;

public class FacialExpressionWidget extends Composite implements HasMouseOutHandlers, HasMouseOverHandlers, HasMouseDownHandlers {

	static final private WebGamesClientBundle webGamesClientBundle = GWT.create(WebGamesClientBundle.class);

	final private ImageDisplayManagementWidget backingWidget;

	private FacialExpressionStyleEnum facialExpressionStyleEnum;
	private FacialExpressionEnum facialExpressionEnum;


	public FacialExpressionWidget(final int boundingWidthInPixels, final int boundingHeightInPixels, final boolean preserveImageAspectRatio, final FacialExpressionStyleEnum initialFacialExpressionStyleEnum, final FacialExpressionEnum initialFacialExpressionEnum) {
		this.backingWidget = new ImageDisplayManagementWidget(boundingWidthInPixels, boundingHeightInPixels, preserveImageAspectRatio, webGamesClientBundle.blank(), "");

		this.facialExpressionStyleEnum = initialFacialExpressionStyleEnum;
		this.facialExpressionEnum = initialFacialExpressionEnum;

		initWidget(this.backingWidget);

		setTitle(this.facialExpressionEnum.getDescription());
		setImageResource(this.facialExpressionEnum.getImageResource(this.facialExpressionStyleEnum));
	};


	public void setImageResource(final ImageResource imageResource) {
		this.backingWidget.setImageResource(imageResource);
	};


	public FacialExpressionEnum getFacialExpression() {
		final FacialExpressionEnum result = Enum.valueOf(FacialExpressionEnum.class, this.facialExpressionEnum.name());
		return result;
	};


	public void setFacialExpression(final FacialExpressionEnum facialExpressionEnum) {
		if (false == this.facialExpressionEnum.equals(facialExpressionEnum)) {
			this.facialExpressionEnum = facialExpressionEnum;
			setTitle(this.facialExpressionEnum.getDescription());
			setImageResource(this.facialExpressionEnum.getImageResource(facialExpressionStyleEnum));
		};
	};


	public FacialExpressionStyleEnum getFacialExpressionStyle() {
		final FacialExpressionStyleEnum result = Enum.valueOf(FacialExpressionStyleEnum.class, this.facialExpressionStyleEnum.name());
		return result;
	};


	public void setFacialExpressionStyle(final FacialExpressionStyleEnum facialExpressionStyleEnum) {
		if (this.facialExpressionStyleEnum != facialExpressionStyleEnum) {
			this.facialExpressionStyleEnum = facialExpressionStyleEnum;
			setImageResource(this.facialExpressionEnum.getImageResource(facialExpressionStyleEnum));
		};
	};


	public void setTitle(final String hoverText) {
		this.backingWidget.setTitle(hoverText);
	};


	public String getTitle() {
		final String result = this.backingWidget.getTitle();
		return result;
	};


	@Override
	public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	};


	@Override
	public HandlerRegistration addMouseOverHandler(final MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	};


	@Override
	public HandlerRegistration addMouseDownHandler(final MouseDownHandler handler) {
		return addDomHandler(handler, MouseDownEvent.getType());
	};

};
