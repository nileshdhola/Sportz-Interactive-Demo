package com.sportz.interactive.data.model

import com.google.gson.annotations.SerializedName
import com.sportz.interactive.data.model.Player

data class Team(
    @SerializedName("Name_Full") val fullName: String? = null,
    @SerializedName("Name_Short") val shortName: String? = null,
    @SerializedName("Players") val players: Map<String, Player>? = emptyMap()
)
