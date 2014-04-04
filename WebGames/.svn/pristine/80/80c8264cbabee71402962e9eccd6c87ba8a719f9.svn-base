package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.LinkedHashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;

import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;

public class AgentEmotionSelectionWidget extends Composite {

	static final private String playerEmoticonGridCSSStyleName = "ict-rapport-playerEmoticonGridStyle";
	static final private String playerEmoticonSelectedCSSStyleName = "ict-rapport-playerEmoticonSelected";
	static final private int panelWidthHint = 215;

	final private AgentEmotionExpressionWidget playerEmotionExpressionWidget;
	final private FacialExpressionEnum[] desiredImagePresentationOrder;
	final private LinkedHashMap<FacialExpressionWidget, FacialExpressionEnum> playersEmotionSelection;
	final private PlayerFacialExpressionMouseInteractionHandler playerFacialExpressionMouseInteractionHandler;
	final private Grid gridPlayerFacialExpressionPalette;
	final private FlexTable flexTableBasePanel;

	private FacialExpressionStyleEnum facialExpressionStyleEnum;


	public AgentEmotionSelectionWidget(final EventBus eventBus, final FacialExpressionStyleEnum initialFacialExpressionStyleEnum, final FacialExpressionEnum[] desiredImagePresentationOrder, final FacialExpressionEnum initiallySelectedFacialExpression) {

		// TODO: verify that desired image presentation order contains no duplicates but does contain original selection.

		this.facialExpressionStyleEnum = initialFacialExpressionStyleEnum;
		this.playerEmotionExpressionWidget = new AgentEmotionExpressionWidget(AgentEnum.player, initiallySelectedFacialExpression, this.facialExpressionStyleEnum, panelWidthHint);
		this.desiredImagePresentationOrder = desiredImagePresentationOrder;
		this.playersEmotionSelection = new LinkedHashMap<FacialExpressionWidget, FacialExpressionEnum>();
		this.playerFacialExpressionMouseInteractionHandler = new PlayerFacialExpressionMouseInteractionHandler(eventBus, playersEmotionSelection, playerEmotionExpressionWidget);

		for (final FacialExpressionEnum agentFacialExpressionEnum: this.desiredImagePresentationOrder) {
			final FacialExpressionWidget facialExpressionWidget = new FacialExpressionWidget(65, 65, true, facialExpressionStyleEnum, agentFacialExpressionEnum);
			facialExpressionWidget.addMouseDownHandler(playerFacialExpressionMouseInteractionHandler);
			facialExpressionWidget.addMouseOverHandler(playerFacialExpressionMouseInteractionHandler);
			facialExpressionWidget.addMouseOutHandler(playerFacialExpressionMouseInteractionHandler);
			if (initiallySelectedFacialExpression == agentFacialExpressionEnum) {
				facialExpressionWidget.addStyleName(playerEmoticonSelectedCSSStyleName);
			};

			playersEmotionSelection.put(facialExpressionWidget, agentFacialExpressionEnum);
		};

		final int gridRowCount = 2;
		final int gridColCount = 3;
		this.gridPlayerFacialExpressionPalette = new Grid(gridRowCount, gridColCount);
		this.gridPlayerFacialExpressionPalette.setStyleName(playerEmoticonGridCSSStyleName);
		int i = 0;
		for (final Widget widget: playersEmotionSelection.keySet()) {
			this.gridPlayerFacialExpressionPalette.setWidget(i / gridColCount, i % gridColCount, widget);
			this.gridPlayerFacialExpressionPalette.setPixelSize(TradingAreaView.desiredEmotionSelectionImageDimensionCalculator.getImageBoundsInPixels().getFirst(), TradingAreaView.desiredEmotionSelectionImageDimensionCalculator.getImageBoundsInPixels().getSecond());
			++i;
		};

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.flexTableBasePanel.setVisible(true);
		this.flexTableBasePanel.setWidget(0, 0, this.playerEmotionExpressionWidget);
		this.flexTableBasePanel.setWidget(1, 0, gridPlayerFacialExpressionPalette);
		
/*		Button reviewScenarioBtn = new Button("review Scenario");
		this.flexTableBasePanel.setWidget(2, 0, reviewScenarioBtn);
		reviewScenarioBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {				
				final ScenarioDialogBox dialogBox = new ScenarioDialogBox (eventBus, experimentConditions);
				dialogBox.center();
			}
		});
		reviewScenarioBtn.setSize("92px", "33px");*/
		
		
	};


	public FacialExpressionEnum getFacialExpression() {
		final FacialExpressionEnum result = this.playerEmotionExpressionWidget.getFacialExpression();
		return result;
	};

	public void setFacialExpressionVisibility (final boolean faceVisible) {
		this.playerEmotionExpressionWidget.setFacialExpressionVisibility(faceVisible);
		
	};

	public void setFacialExpressionStyle(final FacialExpressionStyleEnum newFacialExpressionStyleEnum) {
		if (false == this.facialExpressionStyleEnum.equals(newFacialExpressionStyleEnum)) {
			this.facialExpressionStyleEnum = newFacialExpressionStyleEnum;
			this.playerEmotionExpressionWidget.setFacialExpressionStyle(newFacialExpressionStyleEnum);
			for (final FacialExpressionWidget facialExpressionWidget: this.playersEmotionSelection.keySet()) {
				facialExpressionWidget.setFacialExpressionStyle(newFacialExpressionStyleEnum);
			};
		};
	};

};
