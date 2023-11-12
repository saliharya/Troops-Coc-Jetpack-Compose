package com.arya.troopcoccompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.ui.component.FavoriteButton
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TroopDetailScreen(troop: Troop) {
    val painter = rememberAsyncImagePainter(model = troop.imgUrl)

    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(8.dp)
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painter,
                contentDescription = troop.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(Modifier.height(24.dp))
        Text(
            text = troop.name ?: "",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = troop.description ?: "",
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = troop.trivia ?: "",
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodySmall
        )
    }

    FavoriteButton(
        onClick = { /* Handle favorite button click */ },
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomEnd)
    )
}