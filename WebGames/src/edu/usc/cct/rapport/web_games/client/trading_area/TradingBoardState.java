package edu.usc.cct.rapport.web_games.client.trading_area;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import edu.usc.cct.rapport.web_games.client.support.tuple.Pair;

public class TradingBoardState {

	static final private int agentCount = AgentEnum.values().length;
	static final int agentAreasOnTradingBoard = agentCount + 1;
//	static final int distinctTradingObjectsCount = 4;
	static final int distinctTradingObjectsCount = 3;			// 140210: for Shasha's experiment
	static final int itemsPerTradingObjectCategoryCount = 3;	// when there are 3 items each
//	static final int itemsPerTradingObjectCategoryCount = 5;	// when there are 5 items each

	static final int itemsAcrossPerTradingObjectCategoryCount = 2;
//	static final int itemsUpDownPerTradingObjectCategoryCount = itemsPerTradingObjectCategoryCount/2+1;
	static final int itemsUpDownPerTradingObjectCategoryCount = 2; // when there are 5 items each
	static final int outerColumnsAcross = distinctTradingObjectsCount * itemsAcrossPerTradingObjectCategoryCount;
	static final int outerRowsUpDown = agentAreasOnTradingBoard * itemsUpDownPerTradingObjectCategoryCount;

	static final private int counterpartRowIndex = AgentEnum.getTradingBoardRowIndex(AgentEnum.counterpart);
	static final private int noAgentRowIndex = AgentEnum.getTradingBoardRowIndex(null);
	static final private int playerRowIndex = AgentEnum.getTradingBoardRowIndex(AgentEnum.player);

	final private TradingObjectSetEnum tradingObjectSetEnum;
	final private HashMap<Integer, TradingObjectEnum> tradingObjectEnumByIndex;
	final private LinkedHashMap<TradingObjectEnum, Integer> indexByTradingObjectEnum;

	final private int tradingObjectsAllocated[][];


	static private int[][] getInitialTradingObjectAllocations() {

		final int[][] result = new int[agentAreasOnTradingBoard][distinctTradingObjectsCount];
		for (int col = 0; col != distinctTradingObjectsCount; ++col) {
			result[1][col] = itemsPerTradingObjectCategoryCount;
		};
		
/*		// EK 10/27/2014: To ease the testing
		result[2][0] = itemsPerTradingObjectCategoryCount;
		result[2][1] = itemsPerTradingObjectCategoryCount;
		result[2][2] = itemsPerTradingObjectCategoryCount;*/
		
		
/*		result[0][1] = itemsPerTradingObjectCategoryCount;							// 140210: for Shasha's experiment
		result[0][2] = itemsPerTradingObjectCategoryCount;							// 140210: for Shasha's experiment
		result[agentAreasOnTradingBoard-1][0] = itemsPerTradingObjectCategoryCount;	// 140210: for Shasha's experiment 
		
		result[1][0] = itemsPerTradingObjectCategoryCount;							// 140525: for Shasha's follow-up experiment
		result[1][1] = itemsPerTradingObjectCategoryCount;							// 140525: for Shasha's follow-up experiment
		result[0][2] = itemsPerTradingObjectCategoryCount;							// 140525: for Shasha's follow-up experiment */
					
		return result;
	};


	public TradingBoardState(final TradingObjectSetEnum tradingObjectSetEnum) {
		this(tradingObjectSetEnum, getInitialTradingObjectAllocations());
	};


	public TradingBoardState(final TradingObjectSetEnum tradingObjectSetEnum, int[][] tradingObjectAllocations) {
		this.tradingObjectSetEnum = tradingObjectSetEnum;
		this.tradingObjectEnumByIndex = new HashMap<Integer, TradingObjectEnum>();
		this.indexByTradingObjectEnum = new LinkedHashMap<TradingObjectEnum, Integer>();

		int nthTradingObject = 0;
		for (final TradingObjectEnum tradingObjectEnum: tradingObjectSetEnum.getSetOfTradingObjectEnum()) {
			this.tradingObjectEnumByIndex.put(nthTradingObject, tradingObjectEnum);
			this.indexByTradingObjectEnum.put(tradingObjectEnum, nthTradingObject);
			++nthTradingObject;
		};

		this.tradingObjectsAllocated = tradingObjectAllocations;
	};


	public TradingBoardState(final TradingObjectSetEnum tradingObjectSetEnum, final Proposal proposal) {
		this.tradingObjectSetEnum = tradingObjectSetEnum;
		this.tradingObjectEnumByIndex = new HashMap<Integer, TradingObjectEnum>();
		this.indexByTradingObjectEnum = new LinkedHashMap<TradingObjectEnum, Integer>();

		int nthTradingObject = 0;
		for (final TradingObjectEnum tradingObjectEnum: tradingObjectSetEnum.getSetOfTradingObjectEnum()) {
			this.tradingObjectEnumByIndex.put(nthTradingObject, tradingObjectEnum);
			this.indexByTradingObjectEnum.put(tradingObjectEnum, nthTradingObject);
			++nthTradingObject;
		};

		final Map<Pair<AgentEnum, TradingObjectEnum>, Integer> tradingObjectsAllocation = proposal.getTradingObjectsAllocation();
		this.tradingObjectsAllocated = new int[agentAreasOnTradingBoard][distinctTradingObjectsCount];
		for (int col = 0; col != distinctTradingObjectsCount; ++col) {
			final TradingObjectEnum tradingObjectEnum = this.tradingObjectEnumByIndex.get(col);
			this.tradingObjectsAllocated[counterpartRowIndex][col] = tradingObjectsAllocation.get(new Pair<AgentEnum, TradingObjectEnum>(AgentEnum.counterpart, tradingObjectEnum));
			this.tradingObjectsAllocated[1][col] = 0;
			this.tradingObjectsAllocated[playerRowIndex][col] = tradingObjectsAllocation.get(new Pair<AgentEnum, TradingObjectEnum>(AgentEnum.player, tradingObjectEnum));
		};
	};


	public TradingObjectSetEnum getTradingObjectSetEnum() {
		return Enum.valueOf(TradingObjectSetEnum.class, tradingObjectSetEnum.name());
	};


	public TradingObjectEnum getTradingObjectEnumByIndex(final int index) {
		final TradingObjectEnum result = Enum.valueOf(TradingObjectEnum.class, tradingObjectEnumByIndex.get(index).name());
		return result;
	};


	public Integer getIndexByTradingObjectEnum(final TradingObjectEnum tradingObjectEnum) {
		Integer result = null;
		if (indexByTradingObjectEnum.containsKey(tradingObjectEnum)) {
			result = indexByTradingObjectEnum.get(tradingObjectEnum);
		};
		return result;
	};


	public int[][] getTradingObjectAllocationsAsArray() {
		final int[][] result = new int[agentAreasOnTradingBoard][distinctTradingObjectsCount];
		for (int row = 0; row != agentAreasOnTradingBoard; ++row) {
			for (int col = 0; col != distinctTradingObjectsCount; ++col) {
				result[row][col] = tradingObjectsAllocated[row][col];
			};
		};
		return result;
	};


	public EnumMap<TradingObjectEnum, Integer> getTradingObjectsRetainedByAgent(final AgentEnum agentEnum) {
		assert (this.representsValidProposal());
		final int agentRowIndex = AgentEnum.getTradingBoardRowIndex(agentEnum);
		final EnumMap<TradingObjectEnum, Integer> result = new EnumMap<TradingObjectEnum, Integer>(TradingObjectEnum.class);
		for (final TradingObjectEnum tradingObjectEnum: tradingObjectSetEnum.getSetOfTradingObjectEnum()) {
			result.put(tradingObjectEnum, tradingObjectsAllocated[agentRowIndex][getIndexByTradingObjectEnum(tradingObjectEnum)]);
		};
		return result;
	};


/*
	public Map<Pair<AgentEnum, TradingObjectEnum>, Integer> getTradingObjectsAllocation() {
		assert (this.representsValidProposal());
		final Map<Pair<AgentEnum, TradingObjectEnum>, Integer> result = new HashMap<Pair<AgentEnum, TradingObjectEnum>, Integer>();
		for (int col = 0; col != distinctTradingObjectsCount; ++col) {
			final TradingObjectEnum tradingObjectEnum = this.getTradingObjectEnumByIndex(col);
			for (final AgentEnum agentEnum: AgentEnum.values()) {
				final int objectAllocationCount = tradingObjectsAllocated[AgentEnum.getTradingBoardRowIndex(agentEnum)][col];
				final Pair<AgentEnum, TradingObjectEnum> key = new Pair<AgentEnum, TradingObjectEnum>(agentEnum, tradingObjectEnum);
				result.put(key, objectAllocationCount);
			};
		};
		return result;
	};
*/


	public void setToRandomProposal() {
		for (int col = 0; col != distinctTradingObjectsCount; ++col) {
			final Random rng = new Random();
			int tradingObjectsToGoToCounterpart = rng.nextInt(itemsPerTradingObjectCategoryCount);
			tradingObjectsAllocated[counterpartRowIndex][col] = tradingObjectsToGoToCounterpart;
			tradingObjectsAllocated[noAgentRowIndex][col] = 0;
			tradingObjectsAllocated[playerRowIndex][col] = itemsPerTradingObjectCategoryCount - tradingObjectsToGoToCounterpart;
		};
	};


	public EnumMap<AgentEnum, Integer> getProposalValue() {

		final EnumMap<AgentEnum, Integer> result = new EnumMap<AgentEnum, Integer>(AgentEnum.class);

		for (final AgentEnum agentEnum: AgentEnum.values()) {
			int totalValue = 0;
			for (int col = 0; col != distinctTradingObjectsCount; ++col) {
				final int tradingObjectCount = tradingObjectsAllocated[AgentEnum.getTradingBoardRowIndex(agentEnum)][col];
				final int tradingObjectValue = this.tradingObjectEnumByIndex.get(col).getPayoff(agentEnum);
				totalValue += tradingObjectCount * tradingObjectValue;
			};
			result.put(agentEnum, totalValue);
		};

		return result;
	};


	public boolean representsValidProposal() {

		boolean result = true;

		for (int col = 0; col != distinctTradingObjectsCount; ++col) {
			if (0 != tradingObjectsAllocated[noAgentRowIndex][col]) {
				result = false;
				break;
			};
		};

		return result;
	};


	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append('[');
		for (int tradingObjectIndex = 0; tradingObjectIndex != distinctTradingObjectsCount; ++tradingObjectIndex) {
			if (0 != tradingObjectIndex) {
				builder.append(' ');
			};
			builder.append(tradingObjectEnumByIndex.get(tradingObjectIndex).toString());
			builder.append(':');
			for (int agentAreaIndex = 0; agentAreaIndex != agentAreasOnTradingBoard; ++agentAreaIndex) {
				if (0 != agentAreaIndex) {
					builder.append(' ');
				};
				builder.append(tradingObjectsAllocated[agentAreaIndex][tradingObjectIndex]);
			};
		};
		builder.append(']');

		final String result = builder.toString();
		return result;
	};


	@Override
	public int hashCode() {
		int result = tradingObjectSetEnum.hashCode();
		for (int agentAreaIndex = 0; agentAreaIndex != agentAreasOnTradingBoard; ++agentAreaIndex) {
			for (int tradingObjectIndex = 0; tradingObjectIndex != distinctTradingObjectsCount; ++tradingObjectIndex) {
				result = result * 23 + tradingObjectsAllocated[agentAreaIndex][tradingObjectIndex];
			};
		};
		return result;
	};


	@Override
	public boolean equals(final Object other) {

		if (null == other) return false;
		if (this == other) return true;
		if (false == (other instanceof TradingBoardState)) return false;

		final TradingBoardState otherObject = (TradingBoardState)other;

		if (false == this.getTradingObjectSetEnum().equals(otherObject.getTradingObjectSetEnum())) return false;

		for (int agentAreaIndex = 0; agentAreaIndex != agentAreasOnTradingBoard; ++agentAreaIndex) {
			for (int tradingObjectIndex = 0; tradingObjectIndex != distinctTradingObjectsCount; ++tradingObjectIndex) {
				if (tradingObjectsAllocated[agentAreaIndex][tradingObjectIndex] != otherObject.tradingObjectsAllocated[agentAreaIndex][tradingObjectIndex]) return false;
			};
		};

		return true;
	};
	
	public Integer getItemsPerTradingObjectCategoryCount() {
		return itemsPerTradingObjectCategoryCount;
	};


};
