package edu.usc.cct.rapport.web_games.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface WebGamesClientBundle extends ClientBundle {

	static final String emoticonPackagePath = "images/facial_expressions/";
	static final String iconslandLargeEmoticonDirectoryPath = emoticonPackagePath + "icons_hyphen_land_dot_com/129px/";
	static final String dramaFaceMaskEmoticonDirectoryPath = emoticonPackagePath + "scott_mccloud/drama_masks/";
	static final String tradingObjectsDirectoryPath = "/images/trading_objects/";
	static final String squigglesDirectoryPath = tradingObjectsDirectoryPath + "squiggles/";
	static final String fruitsPath = tradingObjectsDirectoryPath + "fruits/";
	static final String istockphotoTradingObjectsDirectoryPath = tradingObjectsDirectoryPath + "istockphoto_dot_com/";
	static final String sacredObjectsPath = tradingObjectsDirectoryPath + "sacred_objects/";

	@Source(iconslandLargeEmoticonDirectoryPath + "Sad.png")
	ImageResource iconsland_large_sad();

	@Source(iconslandLargeEmoticonDirectoryPath + "Frown.png")
	ImageResource iconsland_large_displeased();

	@Source(iconslandLargeEmoticonDirectoryPath + "Sleep.png")
	ImageResource iconsland_large_neutral();
	
	@Source(iconslandLargeEmoticonDirectoryPath + "Smile.png")
	ImageResource iconsland_large_content();

	@Source(iconslandLargeEmoticonDirectoryPath + "Laugh.png")
	ImageResource iconsland_large_happy();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "Sad.gif")
	ImageResource drama_face_mask_sad();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "sad_neutral.gif")
	ImageResource drama_face_mask_sad_neutral();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "sad_neutral2.gif")
	ImageResource drama_face_mask_sad_neutral2();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "sad_neutral_noLoop.gif")
	ImageResource drama_face_mask_sad_neutral_player();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "sad_neutral_noLoop2.gif")
	ImageResource drama_face_mask_sad_neutral_player2();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "angry_neutral.gif")
	ImageResource drama_face_mask_angry_neutral();
	
	@Source(dramaFaceMaskEmoticonDirectoryPath + "angry_neutral2.gif")
	ImageResource drama_face_mask_angry_neutral2();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "angry_neutral_noLoop.gif")
	ImageResource drama_face_mask_angry_neutral_player();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "angry_neutral_noLoop2.gif")
	ImageResource drama_face_mask_angry_neutral_player2();
	
	@Source(dramaFaceMaskEmoticonDirectoryPath + "happy_neutral_noLoop.gif")
	ImageResource drama_face_mask_happy_neutral_player();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "happy_neutral_noLoop2.gif")
	ImageResource drama_face_mask_happy_neutral_player2();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "content_neutral_noLoop.gif")
	ImageResource drama_face_mask_content_neutral_player();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "content_neutral_noLoop2.gif")
	ImageResource drama_face_mask_content_neutral_player2();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "Angry.gif")
	ImageResource drama_face_mask_displeased();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "Neutral.gif")
	ImageResource drama_face_mask_neutral();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "Content.gif")
	ImageResource drama_face_mask_content();

	@Source(dramaFaceMaskEmoticonDirectoryPath + "Happy.gif")
	ImageResource drama_face_mask_happy();

	@Source(tradingObjectsDirectoryPath + "blank.png")
	ImageResource blank();

	@Source(squigglesDirectoryPath + "squiggle_1.png")
	ImageResource squiggle_1();

	@Source(squigglesDirectoryPath + "squiggle_2.png")
	ImageResource squiggle_2();

	@Source(squigglesDirectoryPath + "squiggle_3.png")
	ImageResource squiggle_3();

	@Source(squigglesDirectoryPath + "squiggle_4.png")
	ImageResource squiggle_4();

	@Source(squigglesDirectoryPath + "squiggle_5.png")
	ImageResource squiggle_5();

	@Source(squigglesDirectoryPath + "squiggle_6.png")
	ImageResource squiggle_6();

	@Source(squigglesDirectoryPath + "squiggle_7.png")
	ImageResource squiggle_7();

	@Source(squigglesDirectoryPath + "squiggle_8.png")
	ImageResource squiggle_8();
	
	@Source(fruitsPath + "apple.png")
	ImageResource fruits_apple();

	@Source(fruitsPath + "banana.png")
	ImageResource fruits_banana();

	@Source(fruitsPath + "orange.png")
	ImageResource fruits_orange();
	
/*	@Source(fruitsPath + "lemon.png")
	ImageResource fruits_lemon();

	@Source(fruitsPath + "pepper.png")
	ImageResource fruits_pepper();*/
	
	@Source(fruitsPath + "melon.png")
	ImageResource fruits_melon();

	@Source(fruitsPath + "pineapple.png")
	ImageResource fruits_pineapple();

	@Source(fruitsPath + "watermelon.png")
	ImageResource fruits_watermelon();

	@Source(fruitsPath + "strawberry.png")
	ImageResource fruits_strawberry();

	@Source(fruitsPath + "blueberry.png")
	ImageResource fruits_blueberry();

	@Source(fruitsPath + "cherry.png")
	ImageResource fruits_cherry();

	@Source(fruitsPath + "pepper.png")
	ImageResource veggie_pepper();

	@Source(fruitsPath + "broccoli.png")
	ImageResource veggie_broccoli();

	@Source(fruitsPath + "mushroom.png")
	ImageResource veggie_mushroom();

	@Source(istockphotoTradingObjectsDirectoryPath + "symbol1.jpg")
	ImageResource istockphoto_medication();
	
	@Source(istockphotoTradingObjectsDirectoryPath + "symbol2.jpg")
	ImageResource istockphoto_water_bottles();

	@Source(istockphotoTradingObjectsDirectoryPath + "symbol3.jpg")
	ImageResource istockphoto_tin_can();
	
	@Source(istockphotoTradingObjectsDirectoryPath + "symbol4.jpg")
	ImageResource istockphoto_money_stack();
	
	@Source(sacredObjectsPath + "Pills-MD.png")
	ImageResource sacredObjects_medication();
	
	@Source(sacredObjectsPath + "Waterbottle-MD.png")
	ImageResource sacredObjects_water_bottles();

	@Source(sacredObjectsPath + "CashPic-MD.png")
	ImageResource sacredObjects_money_stack();
	
	@Source(sacredObjectsPath + "hand-sanitizer.png")
	ImageResource sacredObjects_hand_sanitizer();
	
//	@Source(sacredObjectsPath + "hand-sanitizer.png")
//	ImageResource sacredObjects_money_stack();

	@Source(sacredObjectsPath + "can-new.png")
	ImageResource sacredObjects_tin_can();
	
	@Source(sacredObjectsPath + "document.jpg")
	ImageResource sacredObjects_document();
	
	@Source(sacredObjectsPath + "reform.jpg")
	ImageResource sacredObjects_reform();

	@Source(sacredObjectsPath + "money.jpg")
	ImageResource sacredObjects_bonus();
	
	@Source(sacredObjectsPath + "immigration_bill.png")
	ImageResource sacredObjects_immigration_bill();
	
	@Source(sacredObjectsPath + "gun_bill.jpg")
	ImageResource sacredObjects_gun_bill();
	
	@Source(sacredObjectsPath + "private_sector.png")
	ImageResource sacredObjects_private_sector();
};
