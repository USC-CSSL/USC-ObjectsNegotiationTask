package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

import edu.usc.cct.rapport.web_games.client.WebGamesClientBundle;

public enum TradingObjectEnum {
	blank,
	squiggle_1,
	squiggle_2,
	squiggle_3,
	squiggle_4,
	squiggle_5,
	squiggle_6,
	squiggle_7,
	squiggle_8,
	fruits1_item1_apple,
	fruits1_item2_banana,
	fruits1_item3_orange,
	fruits2_item1_melon,
	fruits2_item2_pineapple,
	fruits2_item3_watermelon,
	fruits3_item1_strawberry,
	fruits3_item2_blueberry,
	fruits3_item3_cherry,
	fruits4_item1_apple,
	fruits4_item2_pineapple,
	fruits4_item3_cherry,
	fruits5_item1_watermelon,
	fruits5_item2_banana,
	fruits5_item3_strawberry,
	fruits6_item1_orange,
	fruits6_item2_melon,
	fruits6_item3_blueberry,
	fruits7_item1_apple,
	fruits7_item2_blueberry,
	fruits7_item3_watermelon,
	fruits8_item1_cherry,
	fruits8_item2_banana,
	fruits8_item3_melon,
/*	fruits1_item1,
	fruits1_item2,
	fruits1_item3,
	fruits2_item1,
	fruits2_item2,
	fruits2_item3,
	fruits3_item1,
	fruits3_item2,
	fruits3_item3,
	fruits4_item1,
	fruits4_item2,
	fruits4_item3,
	fruits5_item1,
	fruits5_item2,
	fruits5_item3,
	fruits6_item1,
	fruits6_item2,
	fruits6_item3,*/
	veggie_pepper,
	veggie_broccoli,
	veggie_mushroom,
/*	fruits_apple,
	fruits_banana,
	fruits_orange,
	fruits_melon,
	fruits_pineapple,
	fruits_watermelon,
	fruits_strawberry,
	fruits_blueberry,
	fruits_cherry,
//	fruits_lemon,
//	fruits_pepper,
//	fruits_strawberry,*/
	istockphoto_water_bottles,
	istockphoto_money_stack,
	istockphoto_tin_can,
	istockphoto_medication,
	sacredObjects_medication,
	sacredObjects_water_bottles,
	sacredObjects_tin_can,
	sacredObjects_money_stack,
	sacredObjects_hand_sanitizer,
	sacredObjects_document,
	sacredObjects_reform,
	sacredObjects_bonus,
	sacredObjects_immigration_bill,
	sacredObjects_gun_bill,
	sacredObjects_private_sector;

	static final private WebGamesClientBundle webGamesClientBundle = (WebGamesClientBundle) (GWT.isClient() ? GWT.create(WebGamesClientBundle.class) : null);
	static final private TradingObjectsInternationalizationConstants constants = (TradingObjectsInternationalizationConstants) (GWT.isClient() ? GWT.create(TradingObjectsInternationalizationConstants.class) : null);


	private String getDescription() {

		String result;

		switch (this) {
		case blank:
			result = "";
			break;
		case squiggle_1:
			result = constants.squiggle_1_Description();
			break;
		case squiggle_2:
			result = constants.squiggle_2_Description();
			break;
		case squiggle_3:
			result = constants.squiggle_3_Description();
			break;
		case squiggle_4:
			result = constants.squiggle_4_Description();
			break;
		case squiggle_5:
			result = constants.squiggle_5_Description();
			break;
		case squiggle_6:
			result = constants.squiggle_6_Description();
			break;
		case squiggle_7:
			result = constants.squiggle_7_Description();
			break;
		case squiggle_8:
			result = constants.squiggle_8_Description();
			break;
/*		case fruits_apple:
			result = constants.fruits_apple_Description();
			break;
		case fruits_banana:
			result = constants.fruits_banana_Description();
			break;
		case fruits_orange:
			result = constants.fruits_orange_Description();
			break;
		case fruits_melon:
			result = constants.fruits_melon_Description();
			break;
		case fruits_pineapple:
			result = constants.fruits_pineapple_Description();
			break;
		case fruits_watermelon:
			result = constants.fruits_watermelon_Description();
			break;
		case fruits_strawberry:
			result = constants.fruits_strawberry_Description();
			break;
		case fruits_blueberry:
			result = constants.fruits_blueberry_Description();
			break;
		case fruits_cherry:
			result = constants.fruits_cherry_Description();
			break;*/
		case veggie_pepper:
			result = constants.veggie_pepper_Description();
			break;
		case veggie_broccoli:
			result = constants.veggie_broccoli_Description();
			break;
		case veggie_mushroom:
			result = constants.veggie_mushroom_Description();
			break;
/*		case fruits_lemon:
			result = constants.fruits_lemon_Description();
			break;
		case fruits_pepper:
			result = constants.fruits_pepper_Description();
			break;*/
		case fruits1_item1_apple:
		case fruits4_item1_apple:
		case fruits7_item1_apple:
			result = constants.fruits_apple_Description();
			break;
		case fruits1_item2_banana:
		case fruits5_item2_banana:
		case fruits8_item2_banana:
			result = constants.fruits_banana_Description();
			break;
		case fruits1_item3_orange:
		case fruits6_item1_orange:			
			result = constants.fruits_orange_Description();
			break;
		case fruits2_item1_melon:
		case fruits6_item2_melon:
		case fruits8_item3_melon:
			result = constants.fruits_melon_Description();
			break;
		case fruits2_item2_pineapple:
		case fruits4_item2_pineapple:
			result = constants.fruits_pineapple_Description();
			break;
		case fruits2_item3_watermelon:
		case fruits5_item1_watermelon:
		case fruits7_item3_watermelon:
			result = constants.fruits_watermelon_Description();
			break;
		case fruits3_item1_strawberry:
		case fruits5_item3_strawberry:
			result = constants.fruits_strawberry_Description();
			break;
		case fruits3_item2_blueberry:
		case fruits6_item3_blueberry:
		case fruits7_item2_blueberry:
			result = constants.fruits_blueberry_Description();
			break;
		case fruits3_item3_cherry:
		case fruits4_item3_cherry:
		case fruits8_item1_cherry:
			result = constants.fruits_cherry_Description();
			break;
		case istockphoto_water_bottles:
			result = constants.istockphoto_water_bottles_Description();
			break;
		case istockphoto_money_stack:
			result = constants.istockphoto_money_stack_Description();
			break;
		case istockphoto_tin_can:
			result = constants.istockphoto_tin_can_Description();
			break;
		case istockphoto_medication:
			result = constants.istockphoto_medication_Description();
			break;
		case sacredObjects_water_bottles:
			result = constants.sacredObjects_water_bottles_Description();
			break;
		case sacredObjects_money_stack:
			result = constants.sacredObjects_money_stack_Description();
			break;
		case sacredObjects_tin_can:
			result = constants.sacredObjects_tin_can_Description();
			break;
		case sacredObjects_medication:
			result = constants.sacredObjects_medication_Description();
			break;
		case sacredObjects_hand_sanitizer:
			result = constants.sacredObjects_hand_sanitizer_Description();
			break;
		case sacredObjects_document:
			result = constants.sacredObjects_document_Description();
			break;
		case sacredObjects_reform:
			result = constants.sacredObjects_reform_Description();
			break;
		case sacredObjects_bonus:
			result = constants.sacredObjects_bonus_Description();
			break;
		case sacredObjects_immigration_bill:
			result = constants.sacredObjects_immigration_bill_Description();
			break;
		case sacredObjects_gun_bill:
			result = constants.sacredObjects_gun_bill_Description();
			break;
		case sacredObjects_private_sector:
			result = constants.sacredObjects_private_sector_Description();
			break;
			
		default:
			throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getDescription().");
		};

		return result;
	};


	private ImageResource getImageResource() {

		ImageResource result = null;

		switch (this) {
		case blank:
			result = webGamesClientBundle.blank();
			break;
		case squiggle_1:
			result = webGamesClientBundle.squiggle_1();
			break;
		case squiggle_2:
			result = webGamesClientBundle.squiggle_2();
			break;
		case squiggle_3:
			result = webGamesClientBundle.squiggle_3();
			break;
		case squiggle_4:
			result = webGamesClientBundle.squiggle_4();
			break;
		case squiggle_5:
			result = webGamesClientBundle.squiggle_5();
			break;
		case squiggle_6:
			result = webGamesClientBundle.squiggle_6();
			break;
		case squiggle_7:
			result = webGamesClientBundle.squiggle_7();
			break;
		case squiggle_8:
			result = webGamesClientBundle.squiggle_8();
			break;
/*		case fruits_apple:
			result = webGamesClientBundle.fruits_apple();
			break;
		case fruits_banana:
			result = webGamesClientBundle.fruits_banana();
			break;
		case fruits_orange:
			result = webGamesClientBundle.fruits_orange();
			break;
		case fruits_lemon:
			result = webGamesClientBundle.fruits_lemon();
			break;
		case fruits_pepper:
			result = webGamesClientBundle.fruits_pepper();
			break;
			
		case fruits_melon:
			result = webGamesClientBundle.fruits_melon();
			break;
		case fruits_pineapple:
			result = webGamesClientBundle.fruits_pineapple();
			break;
		case fruits_watermelon:
			result = webGamesClientBundle.fruits_watermelon();
			break;
		case fruits_strawberry:
			result = webGamesClientBundle.fruits_strawberry();
			break;	
		case fruits_blueberry:
			result = webGamesClientBundle.fruits_blueberry();
			break;
		case fruits_cherry:
			result = webGamesClientBundle.fruits_cherry();
			break;*/
		case veggie_pepper:
			result = webGamesClientBundle.veggie_pepper();
			break;
		case veggie_broccoli:
			result = webGamesClientBundle.veggie_broccoli();
			break;
		case veggie_mushroom:
			result = webGamesClientBundle.veggie_mushroom();
			break;
		case fruits1_item1_apple:
		case fruits4_item1_apple:
		case fruits7_item1_apple:
			result = webGamesClientBundle.fruits_apple();
			break;
		case fruits1_item2_banana:
		case fruits5_item2_banana:
		case fruits8_item2_banana:
			result = webGamesClientBundle.fruits_banana();
			break;
		case fruits1_item3_orange:
		case fruits6_item1_orange:			
			result = webGamesClientBundle.fruits_orange();
			break;
		case fruits2_item1_melon:
		case fruits6_item2_melon:
		case fruits8_item3_melon:
			result = webGamesClientBundle.fruits_melon();
			break;
		case fruits2_item2_pineapple:
		case fruits4_item2_pineapple:
			result = webGamesClientBundle.fruits_pineapple();
			break;
		case fruits2_item3_watermelon:
		case fruits5_item1_watermelon:
		case fruits7_item3_watermelon:
			result = webGamesClientBundle.fruits_watermelon();
			break;
		case fruits3_item1_strawberry:
		case fruits5_item3_strawberry:
			result = webGamesClientBundle.fruits_strawberry();
			break;
		case fruits3_item2_blueberry:
		case fruits6_item3_blueberry:
		case fruits7_item2_blueberry:
			result = webGamesClientBundle.fruits_blueberry();
			break;
		case fruits3_item3_cherry:
		case fruits4_item3_cherry:
		case fruits8_item1_cherry:
			result = webGamesClientBundle.fruits_cherry();
			break;
		case istockphoto_water_bottles:
			result = webGamesClientBundle.istockphoto_water_bottles();
			break;
		case istockphoto_money_stack:
			result = webGamesClientBundle.istockphoto_money_stack();
			break;
		case istockphoto_tin_can:
			result = webGamesClientBundle.istockphoto_tin_can();
			break;
		case istockphoto_medication:
			result = webGamesClientBundle.istockphoto_medication();
			break;
		case sacredObjects_water_bottles:
			result = webGamesClientBundle.sacredObjects_water_bottles();
			break;
		case sacredObjects_money_stack:
			result = webGamesClientBundle.sacredObjects_money_stack();
			break;
		case sacredObjects_tin_can:
			result = webGamesClientBundle.sacredObjects_tin_can();
			break;
		case sacredObjects_medication:
			result = webGamesClientBundle.sacredObjects_medication();
			break;
		case sacredObjects_hand_sanitizer:
			result = webGamesClientBundle.sacredObjects_hand_sanitizer();
			break;
		case sacredObjects_document:
			result = webGamesClientBundle.sacredObjects_document();
			break;
		case sacredObjects_reform:
			result = webGamesClientBundle.sacredObjects_reform();
			break;
		case sacredObjects_bonus:
			result = webGamesClientBundle.sacredObjects_bonus();
			break;
		case sacredObjects_immigration_bill:
			result = webGamesClientBundle.sacredObjects_immigration_bill();
			break;
		case sacredObjects_gun_bill:
			result = webGamesClientBundle.sacredObjects_gun_bill();
			break;
		case sacredObjects_private_sector:
			result = webGamesClientBundle.sacredObjects_private_sector();
			break;
		default:
			throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getImage.");
		};

		return result;
	};


	public Image getImage() {

		final ImageResource imageResource = this.getImageResource();
		final String hoverHint = this.getDescription();

		final Image result = new Image(imageResource.getURL());
		result.setTitle(hoverHint);
		result.setWidth("100%");
		result.setHeight("100%");
		return result;
	};


	public Integer getPayoff(final AgentEnum agentEnum) {

		final Integer result;
/*	 	// fruits negotiation: 5 items each
 		final int fruits_player_payoff1 = 2;
		final int fruits_player_payoff2 = 3;
		final int fruits_player_payoff3 = 4;
		final int veggie_counterpart_payoff1 = 1;
		final int veggie_counterpart_payoff2 = 1;
		final int veggie_counterpart_payoff3 = 3;
		final int veggie_player_payoff1 = 1;
		final int veggie_player_payoff2 = 1;
		final int veggie_player_payoff3 = 3;		*/
/*		final int fruits_counterpart_payoff1 = 2;
		final int fruits_counterpart_payoff2 = 3;
		final int fruits_counterpart_payoff3 = 4;
		final int fruits_player_payoff1 = 3;
		final int fruits_player_payoff2 = 4;
		final int fruits_player_payoff3 = 2; // fMRI experiment 1 */
		final int fruits_counterpart_payoff1 = 3;
		final int fruits_counterpart_payoff2 = 4;
		final int fruits_counterpart_payoff3 = 5;
		final int fruits_player_payoff1 = 4;
		final int fruits_player_payoff2 = 5;
		final int fruits_player_payoff3 = 3;
		final int veggie_counterpart_payoff1 = 1;
		final int veggie_counterpart_payoff2 = 3;
		final int veggie_counterpart_payoff3 = 5;
		final int veggie_player_payoff1 = 1;
		final int veggie_player_payoff2 = 5;
		final int veggie_player_payoff3 = 3;		

		switch (agentEnum) {
			case counterpart: {
	
				switch (this) {
				case squiggle_1:
					result = 1;
					break;
				case squiggle_2:
					result = 2;
					break;
				case squiggle_3:
					result = 3;
					break;
				case squiggle_4:
					result = 4;
					break;
				case squiggle_5:
					result = 4;
					break;
				case squiggle_6:
					result = 4;
					break;
				case squiggle_7:
					result = 4;
					break;
				case squiggle_8:
					result = 4;
					break;
/*				case fruits_apple:
					result = 1;
					break;
				case fruits_banana:
					result = 2;
					break;
				case fruits_orange:
					result = 3;
					break;
				case fruits_lemon:
					result = 0;
					break;
				case fruits_pepper:
					result = 1;
					break;
				case fruits_strawberry:
					result = 1;
					break;*/
					
				case fruits1_item1_apple:
				case fruits2_item2_pineapple:
				case fruits3_item3_cherry:
				case fruits4_item1_apple:
				case fruits5_item2_banana:
				case fruits6_item3_blueberry:
				case fruits7_item3_watermelon:
				case fruits8_item2_banana:
					result = fruits_counterpart_payoff1;
					break;					
				case fruits1_item2_banana:
				case fruits2_item3_watermelon:
				case fruits3_item1_strawberry:
				case fruits4_item3_cherry:
				case fruits5_item1_watermelon:
				case fruits6_item2_melon:
				case fruits7_item1_apple:
				case fruits8_item1_cherry:
					result = fruits_counterpart_payoff2;
					break;
				case fruits1_item3_orange:
				case fruits2_item1_melon:
				case fruits3_item2_blueberry:
				case fruits4_item2_pineapple:
				case fruits5_item3_strawberry:
				case fruits6_item1_orange:
				case fruits7_item2_blueberry:
				case fruits8_item3_melon:
					result = fruits_counterpart_payoff3;
					break;					
/*				case veggie_pepper:
					result = 1;
					break;
				case veggie_broccoli:
					result = 1;
					break;
				case veggie_mushroom:
					result = 3;
					break;*/
				case veggie_pepper:
					result = veggie_counterpart_payoff1;
					break;
				case veggie_broccoli:
					result = veggie_counterpart_payoff2;
					break;
				case veggie_mushroom:
					result = veggie_counterpart_payoff3;
					break;
				case istockphoto_water_bottles:
					result = 10;
					break;
				case istockphoto_money_stack:
					result = 1;
					break;
				case istockphoto_tin_can:
					result = 5;
					break;
				case istockphoto_medication:
					result = 50;
					break;
				case sacredObjects_water_bottles:
					result = 10;
					break;
				case sacredObjects_money_stack:
					result = 1;
					break;
				case sacredObjects_hand_sanitizer:
					result = 1;
					break;
				case sacredObjects_tin_can:
					result = 5;
					break;
				case sacredObjects_medication:
					result = 50;
					break;
				case sacredObjects_document:
					result = 30;
					break;
				case sacredObjects_reform:
					result = 20;
					break;
				case sacredObjects_bonus:
					result = 10;
					break;
				case sacredObjects_immigration_bill:
					result = 30;
					break;
				case sacredObjects_gun_bill:
					result = 20;
					break;
				case sacredObjects_private_sector:
					result = 10;
					break;
				case blank:
					throw new IllegalStateException("Blank is not a true trading object: its worth to the counterpart should never be queried.");
				default:
					throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getPayoff.");
				};
			};
			break;
			
			case player: {
				switch (this) {
				case squiggle_1:
					result = 3;
					break;
				case squiggle_2:
					result = 3;
					break;
				case squiggle_3:
					result = 2;
					break;
				case squiggle_4:
					result = 2;
					break;
				case squiggle_5:
					result = 10;
					break;
				case squiggle_6:
					result = 0;
					break;
				case squiggle_7:
					result = 5;
					break;
				case squiggle_8:
					result = 15;
					break;
/*				case fruits_apple:
					result = 1;
					break;
				case fruits_banana:
					result = 2;
					break;
				case fruits_orange:
					result = 3;
					break;
				case fruits_lemon:
					result = 0;
					break;
				case fruits_pepper:
					result = 3;
					break;
				case fruits_strawberry:
					result = 1;
					break;	*/
				case fruits1_item1_apple:
				case fruits2_item2_pineapple:
				case fruits3_item3_cherry:
				case fruits4_item1_apple:
				case fruits5_item2_banana:
				case fruits6_item3_blueberry:
				case fruits7_item3_watermelon:
				case fruits8_item2_banana:
					result = fruits_player_payoff1;
					break;					
				case fruits1_item2_banana:
				case fruits2_item3_watermelon:
				case fruits3_item1_strawberry:
				case fruits4_item3_cherry:
				case fruits5_item1_watermelon:
				case fruits6_item2_melon:
				case fruits7_item1_apple:
				case fruits8_item1_cherry:
					result = fruits_player_payoff2;
					break;
				case fruits1_item3_orange:
				case fruits2_item1_melon:
				case fruits3_item2_blueberry:
				case fruits4_item2_pineapple:
				case fruits5_item3_strawberry:
				case fruits6_item1_orange:
				case fruits7_item2_blueberry:
				case fruits8_item3_melon:
					result = fruits_player_payoff3;
					break;
				case veggie_pepper:
					result = veggie_player_payoff1;
					break;
				case veggie_broccoli:
					result = veggie_player_payoff2;
					break;
				case veggie_mushroom:
					result = veggie_player_payoff3;
					break;
				case istockphoto_water_bottles:
					result = 5;
					break;
				case istockphoto_money_stack:
					result = 1;
					break;
				case istockphoto_tin_can:
					result = 10;
					break;
				case istockphoto_medication:
					result = 50;
					break;
				case sacredObjects_water_bottles:
					result = 5;
					break;
				case sacredObjects_money_stack:
					result = 1;
					break;
				case sacredObjects_hand_sanitizer:
					result = 1;
					break;
				case sacredObjects_tin_can:
					result = 10;
					break;
				case sacredObjects_medication:
					result = 50;
					break;
				case sacredObjects_document:
					result = 30;
					break;
				case sacredObjects_reform:
					result = 20;
					break;
				case sacredObjects_bonus:
					result = 10;
					break;
				case sacredObjects_immigration_bill:
					result = 30;
					break;
				case sacredObjects_gun_bill:
					result = 20;
					break;
				case sacredObjects_private_sector:
					result = 10;
					break;
				case blank:
					throw new IllegalStateException("Blank is not a true trading object: its worth to the player should never be queried.");
				default:
					throw new IllegalStateException("Unhandled TradingObjectEnum in TradingObjectEnum.getPayoff.");
				};
			};
			break;

			default:
				throw new IllegalStateException("Unhandled AgentEnum in TradingObjectEnum.getPayoff.");
		};

		return result;
	};

};
