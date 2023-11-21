package com.arya.troopcoccompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arya.troopcoccompose.ui.component.ItemTroop
import com.arya.troopcoccompose.ui.viewmodel.TroopListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun FavoriteTroopListScreen(navigator: DestinationsNavigator) {
    val troopViewModel: TroopListViewModel = hiltViewModel()
    val favoriteTroops by troopViewModel.favoriteTroops.observeAsState(emptyList())
    val isLoading by troopViewModel.isLoading.observeAsState(false)
    val isEmpty by troopViewModel.isEmpty.observeAsState(false)

    LaunchedEffect(key1 = true) {
        troopViewModel.loadFavoriteTroops()
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
        } else {
            if (isEmpty) {
                Text(
                    "No Troops Found",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn {
                    items(favoriteTroops) { troop ->
                        ItemTroop(troop, navigator)
                    }
                }
            }
        }
    }
}
