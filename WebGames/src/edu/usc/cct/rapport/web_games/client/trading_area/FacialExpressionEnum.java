package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionResourceLookupTable;
import edu.usc.cct.rapport.web_games.client.images.facial_expressions.FacialExpressionStyleEnum;
import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public enum FacialExpressionEnum {
	happy,
	content,
	neutral,
	angry,
	sad,
	angry_neutral,
	angry_neutral2,
	angry_neutral_player,
	angry_neutral_player2,
	happy_neutral_player,
	happy_neutral_player2,
	content_neutral_player,
	content_neutral_player2,
	sad_neutral,
	sad_neutral2,
	sad_neutral_player,
	sad_neutral_player2;


	static final private AgentEmotionsInternationalizationConstants constants = (AgentEmotionsInternationalizationConstants) (GWT.isClient() ? GWT.create(AgentEmotionsInternationalizationConstants.class) : null);
	static final private String agentEmoticonStyleName = "ict-rapport-agentEmoticonStyle";

	static final private FacialExpressionResourceLookupTable emoticonResourceLookupTable = GWT.isClient() ? new FacialExpressionResourceLookupTable() : null;

	static public FacialExpressionEnum getRandomValue() {
		final int randomIndex = Random.nextInt(FacialExpressionEnum.values().length);
		final FacialExpressionEnum result = FacialExpressionEnum.values()[randomIndex];
		return result;
	};


	public String getDescription() {

		String result;

		switch (this) {
		case happy:
			result = constants.happy();
			break;
		case content:
			result = constants.content();
			break;
		case neutral:
			result = constants.neutral();
			break;
		case angry:
			result = constants.angry();
			break;
		case sad:
			result = constants.sad();
			break;
		case angry_neutral:
			result = constants.angry();
			break;
		case angry_neutral2:
			result = constants.angry();
			break;
		case angry_neutral_player:
			result = constants.angry();
			break;
		case angry_neutral_player2:
			result = constants.angry();
			break;
		case sad_neutral:
			result = constants.sad();
			break;
		case sad_neutral2:
			result = constants.sad();
			break;
		case sad_neutral_player:
			result = constants.sad();
			break;
		case sad_neutral_player2:
			result = constants.sad();
			break;
		case happy_neutral_player:
			result = constants.happy();
			break;
		case happy_neutral_player2:
			result = constants.happy();
			break;
		case content_neutral_player:
			result = constants.content();
			break;
		case content_neutral_player2:
			result = constants.content();
			break;
		default:
			final IllegalStateException e = new IllegalStateException("Unhandled " + FacialExpressionEnum.class.getName() + " in " + FacialExpressionEnum.class.getName() + ".getDescription()");
			throw e;
		};

		return result;
	};


	@Deprecated
	public String getImageFilename() {

		final StringBuilder builder = new StringBuilder(Character.toUpperCase(this.name().charAt(0)));
		builder.append(this.name().substring(1));
		builder.append(".gif");  //Morteza:changed it to gif, from png, to allow animated gifs

		final String result = builder.toString();
		return result;
	};


	public ImageResource getImageResource(final FacialExpressionStyleEnum facialExpressionStyleEnum) {
		final ImageResource result = emoticonResourceLookupTable.getImageResource(facialExpressionStyleEnum, this);
		return result;
	};


	@Deprecated
	public Image getImage(final FacialExpressionStyleEnum facialExpressionStyleEnum, final ImageDimensionCalculator imageDimensionCalculator) {

		final ImageResource imageResource = getImageResource(facialExpressionStyleEnum);
		String hoverHint = null;

		switch (this) {
		case happy:
			hoverHint = constants.happy();
			break;
		case content:
			hoverHint = constants.content();
			break;
		case neutral:
			hoverHint = constants.neutral();
			break;
		case angry:
			hoverHint = constants.angry();
			break;
		case sad:
			hoverHint = constants.sad();
			break;
		case angry_neutral:
			hoverHint = constants.angry();
			break;
		case angry_neutral2:
			hoverHint = constants.angry();
			break;
		case angry_neutral_player:
			hoverHint = constants.angry();
			break;
		case angry_neutral_player2:
			hoverHint = constants.angry();
			break;
		case sad_neutral:
			hoverHint = constants.sad();
			break;
		case sad_neutral2:
			hoverHint = constants.sad();
			break;
		case sad_neutral_player:
			hoverHint = constants.sad();
			break;
		case sad_neutral_player2:
			hoverHint = constants.sad();
			break;
		case happy_neutral_player:
			hoverHint = constants.happy();
			break;
		case happy_neutral_player2:
			hoverHint = constants.happy();
			break;
		case content_neutral_player:
			hoverHint = constants.content();
			break;
		case content_neutral_player2:
			hoverHint = constants.content();
			break;
		default:
			final IllegalStateException e = new IllegalStateException("Unhandled " + FacialExpressionEnum.class.getName() + " in " + FacialExpressionEnum.class.getName() + ".getDescription()");
			throw e;
		};

		final Image result = new Image(imageResource.getURL());
		final Pair<Integer, Integer> sizingInformation = imageDimensionCalculator.getScaledImageDimensionsInPixels(result, true);
		result.setPixelSize(sizingInformation.getFirst(), sizingInformation.getSecond());
		result.setTitle(hoverHint);
		result.setStyleName(agentEmoticonStyleName);
		return result;
	};

};
