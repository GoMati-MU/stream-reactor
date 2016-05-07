/**
  * Copyright 2015 Datamountaineer.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  **/

package com.datamountaineer.streamreactor.connect.bloomberg

object BloombergConstants {
  /**
    * Defines the default value for the buffer accumulating the data updates from Bloomberg
    */
  val Default_Buffer_Size: Int = 2048

  val SUBSCRIPTION_KEY = "SUBSCRIPTION_KEY"

  /**
    * All the fields available to receive data for when subscribing for a ticker updates
    */
  val SubscriptionFields = Set(
    "ALL_PRICE",
    "ALL_PRICE_COND_CODE",
    "ALL_PRICE_SIZE",
    "ALL_PRICE_TIME",
    "API_INTERNAL_TIME",
    "ARBITRAGE_ASK_ORD_NOT_MATCHED_RT",
    "ARBITRAGE_ASK_ORD_VOLUME_RT",
    "ARBITRAGE_BID_ORD_NOT_MATCHED_RT",
    "ARBITRAGE_BID_ORD_VOLUME_RT",
    "ASK",
    "ASK_ALL_SESSION",
    "ASK_BEST_TIME",
    "ASK_BROKER_CODE",
    "ASK_COND_CODE",
    "ASK_DIR",
    "ASK_DIR_YLD",
    "ASK_LIFT_TIME",
    "ASK_MKT_MAKER_TIME",
    "ASK_SIZE",
    "ASK_SIZE_TDY",
    "ASK_SPREAD_TIME",
    "ASK_TDY",
    "ASK_TIME",
    "ASK_WEIGHTED_AVG_SPREAD",
    "ASK_WEIGHTED_AVG_SPREAD_TIME",
    "ASK_YIELD_TIME",
    "ASK_YIELD",
    "ASK_YLD_COND_CODE",
    "ASK_YLD_TDY",
    "ASK2",
    "ASK2_YLD",
    "AT_TRADE_TIME",
    "BEST_ASK",
    "BEST_ASK1",
    "BEST_ASK1_SZ",
    "BEST_ASK2",
    "BEST_ASK2_SZ",
    "BEST_ASK3",
    "BEST_ASK3_SZ",
    "BEST_ASK4",
    "BEST_ASK4_SZ",
    "BEST_ASK5",
    "BEST_ASK5_SZ",
    "BEST_BID",
    "BEST_BID1",
    "BEST_BID1_SZ",
    "BEST_BID2",
    "BEST_BID2_SZ",
    "BEST_BID3",
    "BEST_BID3_SZ",
    "BEST_BID4",
    "BEST_BID4_SZ",
    "BEST_BID5",
    "BEST_BID5_SZ",
    "BID",
    "BID_ALL_SESSION",
    "BID_ASK_TIME",
    "BID_BEST_TIME",
    "BID_BROKER_CODE",
    "BID_COND_CODE",
    "BID_DIR",
    "BID_DIR_YLD",
    "BID_LIFT_TIME",
    "BID_MKT_MAKER_TIME",
    "BID_SIZE",
    "BID_SIZE_TDY",
    "BID_SPREAD_TIME",
    "BID_TDY",
    "BID_TIME",
    "BID_WEIGHTED_AVG_SPREAD",
    "BID_WEIGHTED_AVG_SPREAD_TIME",
    "BID_YIELD_TIME",
    "BID_YIELD",
    "BID_YLD_COND_CODE",
    "BID_YLD_TDY",
    "BID2",
    "BID2_YLD",
    "BLP_ASW_SPRD_CHG_RT",
    "BLP_ASW_SPRD_PCT_CHG_RT",
    "BLP_ASW_SPREAD_LAST_RT",
    "BLP_ASW_SPREAD_MID_RT",
    "BLP_CDS_BASIS_CHG_RT",
    "BLP_CDS_BASIS_MID_RT",
    "BLP_CDS_BASIS_PCT_CHG_RT",
    "BLP_I_SPRD_CHG_RT",
    "BLP_I_SPRD_LAST_RT",
    "BLP_I_SPRD_MID_RT",
    "BLP_I_SPRD_PCT_CHG_RT",
    "BLP_RT_SPRD_TO_BENCH_LAST_RT",
    "BLP_SPRD_TO_BENCH_ASK_RT",
    "BLP_SPRD_TO_BENCH_BID_RT",
    "BLP_SPRD_TO_BENCH_CHG_RT",
    "BLP_SPRD_TO_BENCH_MID_RT",
    "BLP_SPRD_TO_BENCH_PCT_CHG_RT",
    "BLP_SPREAD_BENCHMARK_NAME_RT",
    "BLP_SWAP_CURVE_NAME_RT",
    "BLP_Z_SPRD_CHG_RT",
    "BLP_Z_SPRD_LAST_RT",
    "BLP_Z_SPRD_MID_RT",
    "BLP_Z_SPRD_PCT_CHG_RT",
    "BT_ASK_RECAP_TIME",
    "BT_BID_RECAP_TIME",
    "BT_LAST_RECAP_TIME",
    "BT_LSE_LAST_TIME",
    "BT_MID_PRICE_TIME",
    "BT_MKT_TURN_TIME",
    "BT_SEC_ASK_TIME",
    "BT_SEC_BID_TIME",
    "BUY_SELL_INFO_TIME",
    "CANCEL_CORRECT_TIME",
    "COOLING_DAYS_REALTIME",
    "CR_OBSERVATION_DATE",
    "DOWN_LIMIT",
    "EBS_TOUCH_HIGH_REALTIME",
    "EBS_TOUCH_LOW_REALTIME",
    "EQY_SH_FOREIGN_RT",
    "EVAL_JAPANESE_TIME",
    "EXCH_VWAP",
    "FINANCIAL_STATUS_INDICATOR_RT",
    "FIXING_RATE_REALTIME",
    "FOREIGN_HOLDING_PCT_RT",
    "HEATING_DAYS_REALTIME",
    "HIGH",
    "HIGH_TDY",
    "HIGH_TEMP_REALTIME",
    "HIGH_TIME",
    "HIGH_YIELD_TIME",
    "HIGH_YLD",
    "HIGH_YLD_TDY",
    "HIT_TIME",
    "IMBALANCE_ASK",
    "IMBALANCE_BID",
    "IMBALANCE_INDIC_RT",
    "IND_ASK_FLAG",
    "IND_BID_FLAG",
    "INDICATIVE_ASK",
    "INDICATIVE_ASK_TIME",
    "INDICATIVE_BID",
    "INDICATIVE_BID_TIME",
    "INDICATIVE_FAR",
    "INDICATIVE_NEAR",
    "IS_DELAYED_STREAM",
    "LAST_ALL_SESSIONS",
    "LAST_AT_TRADE",
    "LAST_AT_TRADE_TDY",
    "LAST_DIR",
    "LAST_DIR_YLD",
    "LAST_PRICE",
    "LAST_PRICE_TDY",
    "LAST_TRADE",
    "LAST_TRADE_TIME",
    "LAST_YLD",
    "LAST_YLD_TDY",
    "LAST2_AT_TRADE",
    "LAST2_DIR",
    "LAST2_DIR_YLD",
    "LAST2_PRICE",
    "LAST2_YLD",
    "LISTED_SH_RT",
    "LOW",
    "LOW_TDY",
    "LOW_TEMP_REALTIME",
    "LOW_TIME",
    "LOW_YIELD_TIME",
    "LOW_YLD",
    "LOW_YLD_TDY",
    "MAN_TRADE_WITH_SIZE_TIME",
    "MARKET_DEFINED_VWAP_REALTIME",
    "MARKET_DEPTH_TIME",
    "MAX_LIMIT",
    "MAX_LIMIT_OUT_OF_SESSION",
    "MAX_LIMIT_OUT_OF_SESSION_TIME",
    "MAX_LIMIT_TIME",
    "MEAN_TEMP_REALTIME",
    "MGF_SETTING_RT",
    "MGF_VOLUME_RT",
    "MID",
    "MID_DIR",
    "MID_TDY",
    "MID2",
    "MID2_DIR",
    "MIN_LIMIT",
    "MIN_LIMIT_OUT_OF_SESSION",
    "MIN_LIMIT_OUT_OF_SESSION_TIME",
    "MIN_LIMIT_TIME",
    "MKT_INDICATOR_TIME",
    "NASDAQ_CLOSING_CROSS_ELIGIBLE_RT",
    "NASDAQ_FIRST_TRADE",
    "NASDAQ_OPEN",
    "NASDAQ_PREV_ASK",
    "NASDAQ_PREV_BID",
    "NEW_MKT_DAY_TIME",
    "NEWS_STORY_TIME",
    "NON_ARBIT_ASK_ORD_VOLUME_RT",
    "NON_ARBIT_BID_ORD_VOLUME_RT",
    "NON_ARBITRAGE_ASK_NOT_MATCHED_RT",
    "NON_ARBITRAGE_BID_NOT_MATCHED_RT",
    "NUM_TRADES_CLOSING_AUCTION_RT",
    "NUM_TRADES_OPENING_AUCTION_RT",
    "NUM_TRADES_RT",
    "NYSE_LIQUIDITY_ASK_TIME",
    "NYSE_LIQUIDITY_BID_TIME",
    "NYSE_LRP_HIGH_PRICE_RT",
    "NYSE_LRP_LOW_PRICE_RT",
    "NYSE_LRP_SEND_TIME_RT",
    "OFF_EXCH_VOLUME_RT",
    "OFF_ON_EXCH_VOLUME_RT",
    "OPEN",
    "OPEN_INTEREST_TIME",
    "OPEN_TDY",
    "OPEN_TIME",
    "OPEN_YLD",
    "OPEN_YLD_TDY",
    "DELTA_ASK_RT",
    "DELTA_BID_RT",
    "DELTA_LAST_RT",
    "DELTA_MID_RT",
    "GAMMA_ASK_RT",
    "GAMMA_BID_RT",
    "GAMMA_LAST_RT",
    "GAMMA_MID_RT",
    "IVOL_ASK_RT",
    "IVOL_BID_RT",
    "IVOL_LAST_RT",
    "IVOL_MID_RT",
    "OPT_VEGA_ASK_RT",
    "OPT_VEGA_BID_RT",
    "OPT_VEGA_LAST_RT",
    "OPT_VEGA_MID_RT",
    "ORDER_IMB_BUY_VOLUME",
    "ORDER_IMB_SELL_VOLUME",
    "OWNERSHIP_LIMIT_RATIO_RT",
    "PRE_ANNOUNCE_NUM_PROG_ASK_RT",
    "PRE_ANNOUNCE_NUM_PROG_BID_RT",
    "PRE_POST_MARKET_TIME",
    "PRECIPITATION_REALTIME",
    "PREV_CLOSE_VALUE_REALTIME",
    "PREV_SES_LAST_PRICE",
    "PREV_SES_LAST_YLD",
    "PRICE_UPDATE_TIME",
    "PRIOR_OBSERVATION_DATE",
    "PROPRIETARY_ASK_ORD_VALUE_RT",
    "PROPRIETARY_ASK_ORD_VOLUME_RT",
    "PROPRIETARY_BID_ORD_VALUE_RT",
    "PROPRIETARY_BID_ORD_VOLUME_RT",
    "PX_EVAL_JAPANESE_REALTIME",
    "PX_INDICATIVE_ASK_SIZE_RT",
    "PX_INDICATIVE_BID_SIZE_RT",
    "PX_NASDAQ_VWOP_REALTIME",
    "PX_OFFICIAL_AUCTION_RT",
    "PX_PREV_TO_LAST_REALTIME",
    "PX_SETTLE_ACTUAL_RT",
    "PX_TARGIN_OFFCIAL_REALTIME",
    "PX_TARGIN_SERVICE_REALTIME",
    "PX_VOLUME_BAL_RT",
    "REL_HUMIDITY_REALTIME",
    "RT_EVAL_JAPANESE_CHG_ON_DAY",
    "RT_EVAL_JAPANESE_PCT_CHG_ON_DAY",
    "RT_EXCH_MARKET_STATUS",
    "RT_EXCH_TRADE_STATUS",
    "RT_NYSE_LIQUIDITY_ASK_SIZE",
    "RT_NYSE_LIQUIDITY_BID_SIZE",
    "RT_NYSE_LIQUIDITY_PX_ASK",
    "RT_NYSE_LIQUIDITY_PX_BID",
    "RT_OPEN_INTEREST",
    "RT_PRICING_SOURCE",
    "RT_PX_CHG_NET_1D",
    "RT_PX_CHG_PCT_1D",
    "RT_QUOTE_STATUS",
    "RT_SIMP_SEC_STATUS",
    "RT_TIME_OF_TRADE",
    "RT_TRADING_PERIOD",
    "RT_YLD_CHG_NET_1D",
    "RT_YLD_CHG_PCT_1D",
    "SES_END",
    "SES_START",
    "SETS_MID_PRICE_TIME",
    "SETTLE_TIME",
    "SETTLE_YIELD_TIME",
    "SIZE_LAST_AT_TRADE",
    "SIZE_LAST_AT_TRADE_TDY",
    "SIZE_LAST_TRADE",
    "SIZE_LAST_TRADE_TDY",
    "SMART_QUOTE_TIME",
    "SMART_TIME",
    "SMARTMAX_TIME",
    "TAKE_TIME",
    "THEO_PRICE",
    "THEO_PRICE_TIME",
    "TICK_NUM_TIME",
    "TIME",
    "TORONTO_MOC_ELIGIBLE_REALTIME",
    "TOTAL_VALUE_PROGRAM_TRADE_RT",
    "TOTAL_VOLUME_PROGRAM_TRADE_RT",
    "TRADE_SPREAD_TIME",
    "TRADING_DT_REALTIME",
    "TRADING_PERIOD_TIME",
    "TRUST_ASK_ORD_VALUE_RT",
    "TRUST_ASK_ORD_VOLUME_RT",
    "TRUST_BID_ORD_VALUE_RT",
    "TRUST_BID_ORD_VOLUME_RT",
    "UP_LIMIT",
    "VOLUME",
    "VOLUME_TDY",
    "VOLUME_THEO",
    "VOLUME_TIME",
    "VOLUME_UPDATE_TIME",
    "VWAP",
    "VWAP_TIME",
    "WEATHER_CODE_REALTIME",
    "WIND_SPEED_REALTIME",
    "YIELD_TIME",
    "YLD_COND_CODE"
  )
}
