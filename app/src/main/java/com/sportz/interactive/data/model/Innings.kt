package com.sportz.interactive.data.model

import com.google.gson.annotations.SerializedName

data class Innings(
    @SerializedName("Number") var Number: String? = null,
    @SerializedName("Battingteam") var Battingteam: String? = null,
    @SerializedName("Total") var Total: String? = null,
    @SerializedName("Wickets") var Wickets: String? = null,
    @SerializedName("Overs") var Overs: String? = null,
    @SerializedName("Runrate") var Runrate: String? = null,
    @SerializedName("Byes") var Byes: String? = null,
    @SerializedName("Legbyes") var Legbyes: String? = null,
    @SerializedName("Wides") var Wides: String? = null,
    @SerializedName("Noballs") var Noballs: String? = null,
    @SerializedName("Penalty") var Penalty: String? = null,
    @SerializedName("AllottedOvers") var AllottedOvers: String? = null,
    @SerializedName("Batsmen") var Batsmen: List<Batsmen> = emptyList(),
    @SerializedName("Partnership_Current") var PartnershipCurrent: PartnershipCurrent? = PartnershipCurrent(),
    @SerializedName("Bowlers") var Bowlers: ArrayList<Bowlers> = arrayListOf(),
    @SerializedName("FallofWickets") var FallofWickets: ArrayList<FallofWickets> = arrayListOf(),
    @SerializedName("PowerPlay") var PowerPlay: PowerPlay? = PowerPlay()
)

data class Batsmen(

    @SerializedName("Batsman") var Batsman: String? = null,
    @SerializedName("Runs") var Runs: String? = null,
    @SerializedName("Balls") var Balls: String? = null,
    @SerializedName("Fours") var Fours: String? = null,
    @SerializedName("Sixes") var Sixes: String? = null,
    @SerializedName("Dots") var Dots: String? = null,
    @SerializedName("Strikerate") var Strikerate: String? = null,
    @SerializedName("Dismissal") var Dismissal: String? = null,
    @SerializedName("Howout") var Howout: String? = null,
    @SerializedName("Bowler") var Bowler: String? = null,
    @SerializedName("Fielder") var Fielder: String? = null
)

data class PartnershipCurrent(
    @SerializedName("Runs") var Runs: String? = null,
    @SerializedName("Balls") var Balls: String? = null,
    @SerializedName("Batsmen") var Batsmen: List<Batsmen> = emptyList()

)

data class Bowlers(
    @SerializedName("Bowler") var Bowler: String? = null,
    @SerializedName("Overs") var Overs: String? = null,
    @SerializedName("Maidens") var Maidens: String? = null,
    @SerializedName("Runs") var Runs: String? = null,
    @SerializedName("Wickets") var Wickets: String? = null,
    @SerializedName("Economyrate") var Economyrate: String? = null,
    @SerializedName("Noballs") var Noballs: String? = null,
    @SerializedName("Wides") var Wides: String? = null,
    @SerializedName("Dots") var Dots: String? = null
)

data class FallofWickets(
    @SerializedName("Batsman") var Batsman: String? = null,
    @SerializedName("Score") var Score: String? = null,
    @SerializedName("Overs") var Overs: String? = null

)

data class PowerPlay(
    @SerializedName("PP1") var PP1: String? = null,
    @SerializedName("PP2") var PP2: String? = null

)