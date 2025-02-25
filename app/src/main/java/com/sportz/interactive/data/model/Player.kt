package com.sportz.interactive.data.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("Position") val position: String? = null,
    @SerializedName("Name_Full") val fullName: String? = null,
    @SerializedName("Iscaptain") val isCaptain: Boolean? = false,
    @SerializedName("Iskeeper") val isKeeper: Boolean? = false,
    @SerializedName("Batting") var Batting: Batting? = Batting(),
    @SerializedName("Bowling") var Bowling: Bowling? = Bowling()
)

data class Batting(
    @SerializedName("Style") var Style: String? = null,
    @SerializedName("Average") var Average: String? = null,
    @SerializedName("Strikerate") var Strikerate: String? = null,
    @SerializedName("Runs") var Runs: String? = null
)

data class Bowling(
    @SerializedName("Style") var Style: String? = null,
    @SerializedName("Average") var Average: String? = null,
    @SerializedName("Economyrate") var Economyrate: String? = null,
    @SerializedName("Wickets") var Wickets: String? = null
)