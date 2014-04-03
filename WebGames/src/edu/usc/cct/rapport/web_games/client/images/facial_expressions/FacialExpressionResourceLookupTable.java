package edu.usc.cct.rapport.web_games.client.images.facial_expressions;

import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;

import edu.usc.cct.rapport.web_games.client.WebGamesClientBundle;
import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;
import edu.usc.cct.rapport.web_games.client.trading_area.FacialExpressionEnum;

public class FacialExpressionResourceLookupTable {

	static final private WebGamesClientBundle webGamesClientBundle = GWT.create(WebGamesClientBundle.class);

	final HashMap<Pair<FacialExpressionStyleEnum, FacialExpressionEnum>, ImageResource> facialExpressionImageResources;


	public FacialExpressionResourceLookupTable() {

		this.facialExpressionImageResources = new HashMap<Pair<FacialExpressionStyleEnum,FacialExpressionEnum>, ImageResource>();

		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.emoticons, FacialExpressionEnum.sad), webGamesClientBundle.iconsland_large_sad());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.emoticons, FacialExpressionEnum.angry), webGamesClientBundle.iconsland_large_displeased());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.emoticons, FacialExpressionEnum.neutral), webGamesClientBundle.iconsland_large_neutral());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.emoticons, FacialExpressionEnum.content), webGamesClientBundle.iconsland_large_content());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.emoticons, FacialExpressionEnum.happy), webGamesClientBundle.iconsland_large_happy());
		
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.sad), webGamesClientBundle.drama_face_mask_sad());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.angry), webGamesClientBundle.drama_face_mask_displeased());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.neutral), webGamesClientBundle.drama_face_mask_neutral());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.sad_neutral), webGamesClientBundle.drama_face_mask_sad_neutral());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.angry_neutral), webGamesClientBundle.drama_face_mask_angry_neutral());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.content), webGamesClientBundle.drama_face_mask_content());
		this.facialExpressionImageResources.put(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(FacialExpressionStyleEnum.drama_masks, FacialExpressionEnum.happy), webGamesClientBundle.drama_face_mask_happy());
	};


	public ImageResource getImageResource(final FacialExpressionStyleEnum facialExpressionStyleEnum, final FacialExpressionEnum agentFacialExpressionEnum) {
		final ImageResource result = this.facialExpressionImageResources.get(new Pair<FacialExpressionStyleEnum, FacialExpressionEnum>(facialExpressionStyleEnum, agentFacialExpressionEnum));
		return result;
	};

};
