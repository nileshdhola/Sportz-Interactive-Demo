package com.sportz.interactive.data.model

import com.google.gson.annotations.SerializedName

data class Matchdetail(

    @SerializedName("Team_Home") var TeamHome: String? = null,
    @SerializedName("Team_Away") var TeamAway: String? = null,
    @SerializedName("Match") var Match: Match? = Match(),
    @SerializedName("Series") var Series: Series? = Series(),
    @SerializedName("Venue") var Venue: Venue? = Venue(),
    @SerializedName("Officials") var Officials: Officials? = Officials(),
    @SerializedName("Weather") var Weather: String? = null,
    @SerializedName("Tosswonby") var Tosswonby: String? = null,
    @SerializedName("Status") var Status: String? = null,
    @SerializedName("Status_Id") var StatusId: String? = null,
    @SerializedName("Player_Match") var PlayerMatch: String? = null,
    @SerializedName("Result") var Result: String? = null,
    @SerializedName("Winningteam") var Winningteam: String? = null,
    @SerializedName("Winmargin") var Winmargin: String? = null,
    @SerializedName("Equation") var Equation: String? = null
)

data class Match(
    @SerializedName("Livecoverage") val liveCoverage: String? = null,
    @SerializedName("Id") val id: String? = null,
    @SerializedName("Code") val code: String? = null,
    @SerializedName("League") val league: String? = null,
    @SerializedName("Number") val number: String? = null,
    @SerializedName("Type") val type: String? = null,
    @SerializedName("Date") val date: String? = null,
    @SerializedName("Time") val time: String? = null,
    @SerializedName("Offset") val offset: String? = null,
    @SerializedName("Daynight") val dayNight: String? = null
)

data class Series(
    @SerializedName("Id") var Id: String? = null,
    @SerializedName("Name") var Name: String? = null,
    @SerializedName("Status") var Status: String? = null,
    @SerializedName("Tour") var Tour: String? = null,
    @SerializedName("Tour_Name") var TourName: String? = null
)

data class Venue(
    @SerializedName("Id") var Id: String? = null,
    @SerializedName("Name") var Name: String? = null
)


data class Officials(
    @SerializedName("Umpires") var Umpires: String? = null,
    @SerializedName("Referee") var Referee: String? = null

)