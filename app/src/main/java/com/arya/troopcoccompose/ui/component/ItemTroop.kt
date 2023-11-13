package com.arya.troopcoccompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.ui.screen.destinations.TroopDetailScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ItemTroop(troop: Troop, navigator: DestinationsNavigator) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(8.dp)
        .clickable { navigator.navigate(TroopDetailScreenDestination(troop)) }) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            troop.imgUrl?.let { url ->
                Image(
                    painter = rememberAsyncImagePainter(model = url),
                    contentDescription = troop.name,
                    modifier = Modifier.width(100.dp)
                )
            }
            Spacer(Modifier.width(24.dp))
            Column {
                Text(
                    text = troop.name ?: "",
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = troop.description ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}