package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.TextArea;
//import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.Widget;

public class DescribedValueWidget extends Composite {

	static final private String inPixels(final int pixelCount) {
		final String result = Integer.toString(pixelCount) + "px";
		return result;
	};

	// TODO: Take borders, margins into account, provide offset width and offset height.
	static final private int height = 34;
	static final private int width = 20;

	static final private String pixelHeight = inPixels(height);
	static final private String pixelWidthValue = inPixels(width);

	static final private String describedValueStyleName = "ict-rapport-describedValueStyle";
	static final private String agentDealValuationDescriptionStyleName = "ict-rapport-agentDealValuationDescriptionStyle";
	static final private String agentNameStyle = "ict-rapport-agentName";
	static final private String agentDealValuationValueStyleName = "ict-rapport-agentDealValuationValueStyle";
	static final private String verticalAlignMiddle = "ict-rapport-verticalAlignMiddle";

	final private FlexTable flexTableBasePanel;
	final private Widget widgetValueDescription;
	final private Label labelValue;
	final private Label labelText;

	private Integer value;


	public DescribedValueWidget(final String description, final Integer value, final Integer totalWidthHint) {

		Integer widthDescription = totalWidthHint - width;
		if (20 > widthDescription) widthDescription = 20;

		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.addStyleName(describedValueStyleName);
		this.flexTableBasePanel.setVisible(true);

		/*final TextArea textArea = new TextArea();
		textArea.addStyleName(agentDealValuationDescriptionStyleName);
		textArea.addStyleName(verticalAlignMiddle);
		textArea.setWidth(inPixels(widthDescription));
		textArea.setHeight(pixelHeight);
		textArea.setAlignment(TextAlignment.RIGHT);
		textArea.setReadOnly(true);
		textArea.setVisible(true);
		textArea.setText(description);
		this.widgetValueDescription = textArea;*/

		this.labelText = new Label();
		//this.labelText.addStyleName(agentDealValuationDescriptionStyleName);
		this.labelText.addStyleName(agentNameStyle);
		this.labelText.addStyleName(verticalAlignMiddle);
		this.labelText.setWidth(inPixels(widthDescription));
		this.labelText.setHeight(pixelHeight);
		this.labelText.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelText.setVisible(true);
		setText(description);
		this.widgetValueDescription = labelText;
		
		
		this.labelValue = new Label();
		this.labelValue.addStyleName(agentDealValuationValueStyleName);
		this.labelValue.addStyleName(verticalAlignMiddle);
		this.labelValue.setWidth(pixelWidthValue);
		this.labelValue.setHeight(pixelHeight);
		this.labelValue.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelValue.setVisible(true);
		setValue(value);
		
		this.flexTableBasePanel.setWidget(0, 0, this.widgetValueDescription);
		this.flexTableBasePanel.setWidget(0, 1, this.labelValue);
		
	};


	public DescribedValueWidget(final Image image, final Integer value) {
		labelText= null;
		
		this.flexTableBasePanel = new FlexTable();
		initWidget(this.flexTableBasePanel);
		this.addStyleName(describedValueStyleName);
		this.flexTableBasePanel.setVisible(true);

		this.widgetValueDescription = image;
		this.widgetValueDescription.addStyleName(verticalAlignMiddle);

		this.labelValue = new Label();
		this.labelValue.addStyleName(agentDealValuationValueStyleName);
		this.labelValue.addStyleName(verticalAlignMiddle);
		this.labelValue.setWidth(pixelWidthValue);
		this.labelValue.setHeight(pixelHeight);
		this.labelValue.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.labelValue.setVisible(true);
		setValue(value);

		this.flexTableBasePanel.setWidget(0, 0, this.widgetValueDescription);
		this.flexTableBasePanel.setWidget(0, 1, this.labelValue);
		
	};


	public Integer getValue() {
		return new Integer(value);
	};


	public void setValue(final Integer value) {
		this.value = value;
		if (null == value) {
			this.labelValue.setText("--");
		} else {
			this.labelValue.setText(Integer.toString(value));
		};
	};


	public void setText(String text) {
			this.labelText.setText(text);
	};
	
	public void setLabelVisibility (final Boolean visible){
		this.labelValue.setVisible(visible);
	}
	
	
};
