package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumMap;
import java.util.EnumSet;

public enum TradingObjectSetEnum {
	placeholder_to_allow_initialization_prior_to_trading_object_set_selection,
	squiggles,
	enhanced_squiggles,
	mixture_1,
	mixture_2,
	istockphoto,
	symbolicObjects_3columns,
	sacredObjects,
	sacredObjectsMoney;

	public EnumSet<TradingObjectEnum> getSetOfTradingObjectEnum() {

		final EnumSet<TradingObjectEnum> result;

		switch (this) {
		case placeholder_to_allow_initialization_prior_to_trading_object_set_selection:
			result = EnumSet.noneOf(TradingObjectEnum.class);
			break;
		case squiggles:
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
			break;
		case symbolicObjects_3columns:
			result = EnumSet.of(TradingObjectEnum.sacredObjects_document, TradingObjectEnum.sacredObjects_reform, TradingObjectEnum.sacredObjects_bonus);
			break;
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
