package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.LinkedHashMap;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;


final class PlayerFacialExpressionMouseInteractionHandler implements MouseDownHandler, MouseOverHandler, MouseOutHandler {

    static final private String hoveredPlayerEmoticonCSSStyleName = "ict-rapport-playerEmoticonHovered";
    static final private String selectedPlayerEmoticonCSSStyleName = "ict-rapport-playerEmoticonSelected";

    final private EventBus eventBus;
	final private LinkedHashMap<? extends Widget, FacialExpressionEnum> orderedWidgetsAndCorrespondingEmotionEnums;
	final private AgentEmotionExpressionWidget playerEmotionExpression;


	public PlayerFacialExpressionMouseInteractionHandler(final EventBus eventBus, final LinkedHashMap<? extends Widget, FacialExpressionEnum> orderedWidgetsAndCorrespondingEmotionEnums, final AgentEmotionExpressionWidget playerEmotionExpression) {
		this.eventBus = eventBus;
		this.orderedWidgetsAndCorrespondingEmotionEnums = orderedWidgetsAndCorrespondingEmotionEnums;
		this.playerEmotionExpression = playerEmotionExpression;
	};


	@Override
	public void onMouseDown(final MouseDownEvent event) {

		final double timestamp = Duration.currentTimeMillis();
		for (final Widget widgetRepresentingEmotion: this.orderedWidgetsAndCorrespondingEmotionEnums.keySet()) {
			final Object eventSource = event.getSource();
			if (widgetRepresentingEmotion.equals(eventSource) || widgetRepresentingEmotion.equals(eventSource)) {
				widgetRepresentingEmotion.addStyleName(selectedPlayerEmoticonCSSStyleName);
				GWT.log("Mouse down on eventSource |" + eventSource.toString() + "|.");
				final FacialExpressionEnum chosenFacialExpression = this.orderedWidgetsAndCorrespondingEmotionEnums.get(widgetRepresentingEmotion);

				if(chosenFacialExpression.equals(FacialExpressionEnum.angry)) {
					if(playerEmotionExpression.getFacialExpression().equals(FacialExpressionEnum.angry_neutral_player)) {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.angry_neutral_player2);
					} else {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.angry_neutral_player);
					}
				} else if(chosenFacialExpression.equals(FacialExpressionEnum.sad)) {
					if(playerEmotionExpression.getFacialExpression().equals(FacialExpressionEnum.sad_neutral_player)) {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.sad_neutral_player2);
					} else {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.sad_neutral_player);
					}
				} else if(chosenFacialExpression.equals(FacialExpressionEnum.happy)) {
					if(playerEmotionExpression.getFacialExpression().equals(FacialExpressionEnum.happy_neutral_player)) {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.happy_neutral_player2);
					} else {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.happy_neutral_player);
					}
				} else if(chosenFacialExpression.equals(FacialExpressionEnum.content)) {
					if(playerEmotionExpression.getFacialExpression().equals(FacialExpressionEnum.content_neutral_player)) {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.content_neutral_player2);
					} else {
						playerEmotionExpression.setFacialExpression(FacialExpressionEnum.content_neutral_player);
					}
				} else {
					playerEmotionExpression.setFacialExpression(chosenFacialExpression);
				}
				
				final FacialExpressionChosenEvent newEvent = new FacialExpressionChosenEvent(new TradingExpression(AgentEnum.player, timestamp, chosenFacialExpression));
				eventBus.fireEvent(newEvent);
			} else {
				widgetRepresentingEmotion.removeStyleName(selectedPlayerEmoticonCSSStyleName);
			};
		};
	};


	@Override
	public void onMouseOver(final MouseOverEvent event) {

		for (final Widget widgetRepresentingEmotion: this.orderedWidgetsAndCorrespondingEmotionEnums.keySet()) {
			final Object eventSource = event.getSource();
			if (widgetRepresentingEmotion.equals(eventSource) || widgetRepresentingEmotion.equals(eventSource)) {
				widgetRepresentingEmotion.addStyleName(hoveredPlayerEmoticonCSSStyleName);
				GWT.log("Mouse over eventSource |" + eventSource.toString() + "|.");
			};
		};
	};


	@Override
	public void onMouseOut(final MouseOutEvent event) {

		for (final Widget widgetRepresentingEmotion: this.orderedWidgetsAndCorrespondingEmotionEnums.keySet()) {
			final Object eventSource = event.getSource();
			if (widgetRepresentingEmotion.equals(eventSource) || widgetRepresentingEmotion.equals(eventSource)) {
				widgetRepresentingEmotion.removeStyleName(hoveredPlayerEmoticonCSSStyleName);
				GWT.log("Mouse out of eventSource |" + eventSource.toString() + "|.");
			};
		};
	};

};
