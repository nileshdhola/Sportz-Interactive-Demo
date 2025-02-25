package com.sportz.interactive.presentation.ui.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sportz.interactive.presentation.viewmodel.MatchViewModel

@Composable
fun MatchScreen(navController: NavController, viewModel: MatchViewModel = hiltViewModel()) {
    val matchDetails by viewModel.matchDetails.collectAsState()

    matchDetails?.let { details ->
        val teamList = details.teams?.values?.toList() ?: emptyList()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = if (teamList.size >= 2) {
                        "${teamList[0].fullName} vs ${teamList[1].fullName}"
                    } else {
                        "Teams not available"
                    },
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Date: ${details.Matchdetail?.Match?.date} - Time ${details.Matchdetail?.Match?.time}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Venue: ${details.Matchdetail?.Venue?.Name}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Button(
                    onClick = { navController.navigate("squadScreen") },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(
                        text = "View Squad Details",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    } ?: run {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
