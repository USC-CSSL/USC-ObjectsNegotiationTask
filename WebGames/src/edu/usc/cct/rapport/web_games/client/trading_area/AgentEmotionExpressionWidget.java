package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;

public class AgentEmotionExpressionWidget extends Composite {

	static final private String inPixels(final int pixelCount) {
		final String result = Integer.toString(pixelCount) + "px";
		return result;
	};

	static final private int emoticonDiameter = 129;
	static final private ImageDimensionCalculator desiredEmotionExpressionImageDimensionCalculator = new ImageDimensionCalculator(emoticonDiameter, emoticonDiameter);

	static final private int height = 34;
	static final private int targetPixelWidthAfterScaling = desiredEmotionExpressionImageDimensionCalculator.getImageBoundsInPixels().getFirst();

	static final private String pixelHeight = inPixels(height);

	static final private String agentEmotionExpressionStyleName = "ict-rapport-agentEmotionExpression";
	static final private String agentNameStyle = "ict-rapport-agentName";
	static final private String verticalAlignMiddle = "ict-rapport-verticalAlignMiddle";

	final private AgentEnum agentEnum;
	final private Label labelDisplayName;
	final private FacialExpressionWidget facialExpressionWidget;

	final private FlexTable flexTableBasePanel;


	public AgentEmotionExpressionWidget(final AgentEnum agentEnum, final FacialExpressionEnum facialExpressionEnum, final FacialExpressionStyleEnum facialExpressionStyleEnum, final Integer widthHint) {

		this.agentEnum = agentEnum;

		final Integer width = Math.max(targetPixelWidthAfterScaling, widthHint);
		final String pixelWidth = inPixels(width);

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.addStyleName(agentEmotionExpressionStyleName);
		this.flexTableBasePanel.setVisible(true);

		this.labelDisplayName = new Label(this.agentEnum.getDisplayName());
		this.labelDisplayName.addStyleName(agentNameStyle);
		this.labelDisplayName.addStyleName(verticalAlignMiddle);
		this.labelDisplayName.setWidth(pixelWidth);
		this.labelDisplayName.setHeight(pixelHeight);
		this.labelDisplayName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelDisplayName.setVisible(true);
		this.flexTableBasePanel.setWidget(0, 0, this.labelDisplayName);

		final int boundingWidthInPixels = Math.max(emoticonDiameter, width);
		this.facialExpressionWidget = new FacialExpressionWidget(boundingWidthInPixels, emoticonDiameter, true, facialExpressionStyleEnum, facialExpressionEnum);
		this.flexTableBasePanel.setWidget(1, 0, this.facialExpressionWidget);
		
		
	};
	
	
/*	public AgentEmotionExpressionWidget(final AgentEnum agentEnum, final FacialExpressionEnum facialExpressionEnum, final FacialExpressionStyleEnum facialExpressionStyleEnum, final Integer widthHint, final Integer expScenario) {

		this.agentEnum = agentEnum;

		final Integer width = Math.max(targetPixelWidthAfterScaling, widthHint);
		final String pixelWidth = inPixels(width);

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.addStyleName(agentEmotionExpressionStyleName);
		this.flexTableBasePanel.setVisible(true);

		this.labelDisplayName = new Label(this.agentEnum.getDisplayName(expScenario));
		this.labelDisplayName.addStyleName(agentNameStyle);
		this.labelDisplayName.addStyleName(verticalAlignMiddle);
		this.labelDisplayName.setWidth(pixelWidth);
		this.labelDisplayName.setHeight(pixelHeight);
		this.labelDisplayName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelDisplayName.setVisible(true);
		this.flexTableBasePanel.setWidget(0, 0, this.labelDisplayName);

		final int boundingWidthInPixels = Math.max(emoticonDiameter, width);
		this.facialExpressionWidget = new FacialExpressionWidget(boundingWidthInPixels, emoticonDiameter, true, facialExpressionStyleEnum, facialExpressionEnum);
		this.flexTableBasePanel.setWidget(1, 0, this.facialExpressionWidget);
		
		
	};*/


	public FacialExpressionEnum getFacialExpression() {
		final FacialExpressionEnum result = this.facialExpressionWidget.getFacialExpression();
		return result;
	};


	public void setFacialExpression(final FacialExpressionEnum agentEmotionEnum) {
		this.facialExpressionWidget.setFacialExpression(agentEmotionEnum);
		
	};

	public void setFacialExpressionVisibility (final boolean faceVisible) {
		this.facialExpressionWidget.setVisible(faceVisible);
		
	};

	public FacialExpressionStyleEnum getFacialExpressionStyle() {
		final FacialExpressionStyleEnum result = this.facialExpressionWidget.getFacialExpressionStyle();
		return result;
	};


	public void setFacialExpressionStyle(final FacialExpressionStyleEnum facialExpressionStyleEnum) {
		this.facialExpressionWidget.setFacialExpressionStyle(facialExpressionStyleEnum);
	};

};
