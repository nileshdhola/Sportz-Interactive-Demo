package com.sportz.interactive.presentation.ui.squad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sportz.interactive.data.model.Player
import com.sportz.interactive.presentation.ui.components.PlayerInfoDialog
import com.sportz.interactive.presentation.ui.components.PlayerItem
import com.sportz.interactive.presentation.viewmodel.SquadViewModel

@Composable
fun SquadScreen(viewModel: SquadViewModel = hiltViewModel()) {
    val matchDetails by viewModel.squadDetails.collectAsState()
    var selectedPlayer by remember { mutableStateOf<Player?>(null) }
    var selectedTeam by remember { mutableStateOf("All") }
    var selectedRole by remember { mutableStateOf("All") }
    var expandedTeam by remember { mutableStateOf(false) }
    var expandedRole by remember { mutableStateOf(false) }

    matchDetails?.let { details ->
        val teams = details.teams?.values?.toList() ?: emptyList()
        val teamNames = listOf("All") + teams.map { it.fullName }
        val roles = listOf("All", "Batsman", "Bowler", "Wicket-Keeper", "Captain")

        val filteredPlayers = teams.flatMap { team ->
            if (selectedTeam == "All" || team.fullName == selectedTeam) {
                team.players?.values?.filter { player ->
                    when (selectedRole) {
                        "All" -> true
                        "Batsman" -> player.Batting?.Style?.isNotEmpty() == true
                        "Bowler" -> player.Bowling?.Style?.isNotEmpty() == true
                        "Wicket-Keeper" -> player.isKeeper == true
                        "Captain" -> player.isCaptain == true
                        else -> true
                    }
                } ?: emptyList()
            } else emptyList()
        }

        Column(modifier = Modifier.fillMaxSize().padding(top = 56.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Team",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box {
                            Button(onClick = { expandedTeam = true }) {
                                Text(text = selectedTeam)
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Dropdown"
                                )
                            }
                            DropdownMenu(
                                expanded = expandedTeam,
                                onDismissRequest = { expandedTeam = false }
                            ) {
                                teamNames.forEach { teamName ->
                                    DropdownMenuItem(
                                        text = { Text(teamName ?: "N/A") },
                                        onClick = {
                                            selectedTeam = teamName ?: "N/A"
                                            expandedTeam = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Role",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box {
                            Button(onClick = { expandedRole = true }) {
                                Text(text = selectedRole)
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Dropdown"
                                )
                            }
                            DropdownMenu(
                                expanded = expandedRole,
                                onDismissRequest = { expandedRole = false }
                            ) {
                                roles.forEach { role ->
                                    DropdownMenuItem(
                                        text = { Text(role) },
                                        onClick = {
                                            selectedRole = role
                                            expandedRole = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Text(
                text = "Total Players: ${filteredPlayers.size}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )


            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(filteredPlayers) { player ->
                    PlayerItem(player, onClick = { selectedPlayer = player })
                }
            }

            selectedPlayer?.let { player ->
                PlayerInfoDialog(player = player, onDismiss = { selectedPlayer = null })
            }
        }
    }
}
