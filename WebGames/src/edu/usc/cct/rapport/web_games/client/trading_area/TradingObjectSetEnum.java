package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumMap;
import java.util.EnumSet;

public enum TradingObjectSetEnum {
	placeholder_to_allow_initialization_prior_to_trading_object_set_selection,
/*	squiggles,
	enhanced_squiggles,
	mixture_1,
	mixture_2,
	istockphoto,
	sacredObjects,
	sacredObjectsMoney*/
//	symbolicObjects_3columns,
//	politicalParty_3columns,
//	veggie,
	fruits1;/*,
	fruits2,
	fruits3,
	fruits4,
	fruits5,
	fruits6,
	fruits7,
	fruits8;*/

	public EnumSet<TradingObjectEnum> getSetOfTradingObjectEnum() {

		final EnumSet<TradingObjectEnum> result;

		switch (this) {
		case placeholder_to_allow_initialization_prior_to_trading_object_set_selection:
			result = EnumSet.noneOf(TradingObjectEnum.class);
			break;
/*		case squiggles:
			result = EnumSet.of(TradingObjectEnum.squiggle_1, TradingObjectEnum.squiggle_2, TradingObjectEnum.squiggle_3, TradingObjectEnum.squiggle_4);
			break;
		case enhanced_squiggles:
			result = EnumSet.of(TradingObjectEnum.squiggle_5, TradingObjectEnum.squiggle_6, TradingObjectEnum.squiggle_7, TradingObjectEnum.squiggle_8);
			break;
		case mixture_1:
			result = EnumSet.of(TradingObjectEnum.squiggle_1, TradingObjectEnum.squiggle_2, TradingObjectEnum.squiggle_5, TradingObjectEnum.squiggle_6);
			break;
		case mixture_2:
			result = EnumSet.of(TradingObjectEnum.squiggle_3, TradingObjectEnum.squiggle_4, TradingObjectEnum.squiggle_7, TradingObjectEnum.squiggle_8);
			break;
		case istockphoto:
			result = EnumSet.of(TradingObjectEnum.istockphoto_tin_can, TradingObjectEnum.istockphoto_medication, TradingObjectEnum.istockphoto_water_bottles, TradingObjectEnum.istockphoto_money_stack);
			break; 
		case sacredObjectsMoney:
			result = EnumSet.of(TradingObjectEnum.sacredObjects_medication, TradingObjectEnum.sacredObjects_tin_can, TradingObjectEnum.sacredObjects_water_bottles, TradingObjectEnum.sacredObjects_money_stack);
			break;
		case sacredObjects:
			result = EnumSet.of(TradingObjectEnum.sacredObjects_medication, TradingObjectEnum.sacredObjects_tin_can, TradingObjectEnum.sacredObjects_water_bottles, TradingObjectEnum.sacredObjects_hand_sanitizer);
			break;*/
/*		case veggie:
			result = EnumSet.of(TradingObjectEnum.veggie_pepper, TradingObjectEnum.veggie_broccoli, TradingObjectEnum.veggie_mushroom);
			break;*/
		case fruits1:
			result = EnumSet.of(TradingObjectEnum.fruits1_item1_apple, TradingObjectEnum.fruits1_item2_banana, TradingObjectEnum.fruits1_item3_orange);
			break;
/*		case fruits2:
			result = EnumSet.of(TradingObjectEnum.fruits2_item1_melon, TradingObjectEnum.fruits2_item2_pineapple, TradingObjectEnum.fruits2_item3_watermelon);
			break;
		case fruits3:
			result = EnumSet.of(TradingObjectEnum.fruits3_item1_strawberry, TradingObjectEnum.fruits3_item2_blueberry, TradingObjectEnum.fruits3_item3_cherry);
			break;
		case fruits4:
			result = EnumSet.of(TradingObjectEnum.fruits4_item1_apple, TradingObjectEnum.fruits4_item2_pineapple, TradingObjectEnum.fruits4_item3_cherry);
			break;
		case fruits5:
			result = EnumSet.of(TradingObjectEnum.fruits5_item1_watermelon, TradingObjectEnum.fruits5_item2_banana, TradingObjectEnum.fruits5_item3_strawberry);
			break;
		case fruits6:
			result = EnumSet.of(TradingObjectEnum.fruits6_item1_orange, TradingObjectEnum.fruits6_item2_melon, TradingObjectEnum.fruits6_item3_blueberry);
			break;
		case fruits7:
			result = EnumSet.of(TradingObjectEnum.fruits7_item1_apple, TradingObjectEnum.fruits7_item2_blueberry, TradingObjectEnum.fruits7_item3_watermelon);
			break;
		case fruits8:
			result = EnumSet.of(TradingObjectEnum.fruits8_item1_cherry, TradingObjectEnum.fruits8_item2_banana, TradingObjectEnum.fruits8_item3_melon);
			break;
/*		case symbolicObjects_3columns:
			result = EnumSet.of(TradingObjectEnum.sacredObjects_document, TradingObjectEnum.sacredObjects_reform, TradingObjectEnum.sacredObjects_bonus);
			break;
		case politicalParty_3columns:
			result = EnumSet.of(TradingObjectEnum.sacredObjects_immigration_bill, TradingObjectEnum.sacredObjects_gun_bill, TradingObjectEnum.sacredObjects_private_sector);
			break;			*/
		default:
			throw new IllegalStateException("Unhandled TradingObjectSetEnum in TradingObjectSetEnum.getEnumSet().");			
		};

		return result;
	};


	public EnumMap<TradingObjectEnum, Integer> getPayoffMatrix(final AgentEnum agentEnum) {

		final EnumMap<TradingObjectEnum, Integer> result = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);

		for (final TradingObjectEnum tradingObjectEnum: this.getSetOfTradingObjectEnum()) {
			result.put(tradingObjectEnum, tradingObjectEnum.getPayoff(agentEnum));
		};

		return result;
	};

};
