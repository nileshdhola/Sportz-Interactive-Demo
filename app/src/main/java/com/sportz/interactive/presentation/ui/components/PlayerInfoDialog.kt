package com.sportz.interactive.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sportz.interactive.data.model.Player

@Composable
fun PlayerInfoDialog(player: Player, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = player.fullName ?: "N/A") },
        text = {
            Column {
                Text("Batting Style: ${player.Batting?.Style}")
                Text("Bowling Style: ${player.Bowling?.Style}")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}