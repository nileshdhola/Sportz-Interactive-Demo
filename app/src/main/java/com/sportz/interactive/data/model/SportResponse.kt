package com.sportz.interactive.data.model

import com.google.gson.annotations.SerializedName

data class SportResponse(
    @SerializedName("Matchdetail") var Matchdetail: Matchdetail? = Matchdetail(),
    @SerializedName("Nuggets") val nuggets: List<String>? = emptyList(),
    @SerializedName("Innings") var Innings: List<Innings> = emptyList(),
    @SerializedName("Teams") val teams: Map<String, Team>? = emptyMap(),
    @SerializedName("Notes") val notes: Map<String, List<String>>? = emptyMap()
)
