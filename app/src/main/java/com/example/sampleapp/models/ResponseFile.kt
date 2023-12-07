package com.example.sampleapp.models


import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("marketSummaryAndSparkResponse" ) var marketSummaryAndSparkResponse : MarketSummaryAndSparkResponse? = MarketSummaryAndSparkResponse()

)

data class MarketSummaryAndSparkResponse (

    @SerializedName("result" ) var result : ArrayList<Result> = arrayListOf(),
    @SerializedName("error"  ) var error  : String?           = null

)
data class Result (

    @SerializedName("fullExchangeName"           ) var fullExchangeName           : String?                     = null,
    @SerializedName("exchangeTimezoneName"       ) var exchangeTimezoneName       : String?                     = null,
    @SerializedName("symbol"                     ) var symbol                     : String?                     = null,
    @SerializedName("cryptoTradeable"            ) var cryptoTradeable            : Boolean?                    = null,
    @SerializedName("gmtOffSetMilliseconds"      ) var gmtOffSetMilliseconds      : Int?                        = null,
    @SerializedName("firstTradeDateMilliseconds" ) var firstTradeDateMilliseconds : Long?                        = null,
    @SerializedName("exchangeDataDelayedBy"      ) var exchangeDataDelayedBy      : Int?                        = null,
    @SerializedName("language"                   ) var language                   : String?                     = null,
    @SerializedName("regularMarketTime"          ) var regularMarketTime          : RegularMarketTime?          = RegularMarketTime(),
    @SerializedName("exchangeTimezoneShortName"  ) var exchangeTimezoneShortName  : String?                     = null,
    @SerializedName("quoteType"                  ) var quoteType                  : String?                     = null,
    @SerializedName("marketState"                ) var marketState                : String?                     = null,
    @SerializedName("customPriceAlertConfidence" ) var customPriceAlertConfidence : String?                     = null,
    @SerializedName("market"                     ) var market                     : String?                     = null,
    @SerializedName("spark"                      ) var spark                      : Spark?                      = Spark(),
    @SerializedName("priceHint"                  ) var priceHint                  : Int?                        = null,
    @SerializedName("tradeable"                  ) var tradeable                  : Boolean?                    = null,
    @SerializedName("sourceInterval"             ) var sourceInterval             : Int?                        = null,
    @SerializedName("exchange"                   ) var exchange                   : String?                     = null,
    @SerializedName("region"                     ) var region                     : String?                     = null,
    @SerializedName("shortName"                  ) var shortName                  : String?                     = null,
    @SerializedName("regularMarketPreviousClose" ) var regularMarketPreviousClose : RegularMarketPreviousClose? = RegularMarketPreviousClose(),
    @SerializedName("triggerable"                ) var triggerable                : Boolean?                    = null

)

data class RegularMarketTime (

    @SerializedName("raw" ) var raw : Int?    = null,
    @SerializedName("fmt" ) var fmt : String? = null

)

data class Spark (

    @SerializedName("dataGranularity"    ) var dataGranularity    : Int?              = null,
    @SerializedName("symbol"             ) var symbol             : String?           = null,
    @SerializedName("timestamp"          ) var timestamp          : ArrayList<Int>    = arrayListOf(),
    @SerializedName("end"                ) var end                : Int?              = null,
    @SerializedName("previousClose"      ) var previousClose      : Double?           = null,
    @SerializedName("chartPreviousClose" ) var chartPreviousClose : Double?           = null,
    @SerializedName("start"              ) var start              : Int?              = null,
    @SerializedName("close"              ) var close              : ArrayList<Double> = arrayListOf()

)

data class RegularMarketPreviousClose (

    @SerializedName("raw" ) var raw : Double? = null,
    @SerializedName("fmt" ) var fmt : String? = null

)


