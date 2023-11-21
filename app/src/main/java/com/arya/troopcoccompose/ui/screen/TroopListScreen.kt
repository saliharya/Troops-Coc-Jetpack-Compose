package com.arya.troopcoccompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arya.troopcoccompose.ui.component.ItemTroop
import com.arya.troopcoccompose.ui.component.SearchBar
import com.arya.troopcoccompose.ui.screen.destinations.FavoriteTroopListScreenDestination
import com.arya.troopcoccompose.ui.screen.destinations.UserDetailScreenDestination
import com.arya.troopcoccompose.ui.viewmodel.TroopListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination(start = true)
@Composable
fun TroopListScreen(navigator: DestinationsNavigator) {
    val troopViewModel: TroopListViewModel = hiltViewModel()
    val allTroops by troopViewModel.troops.observeAsState(emptyList())
    val isLoading by troopViewModel.isLoading.observeAsState(false)
    val isEmpty by troopViewModel.isEmpty.observeAsState(false)

    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        troopViewModel.loadTroops()
    }

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ), title = {
                if (isSearching) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { newQuery ->
                            searchQuery = newQuery
                            troopViewModel.searchTroops(newQuery)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(onSearch = {
                            troopViewModel.searchTroops(searchQuery)
                        })
                    )
                } else {
                    Text("Troops")
                }
            }, actions = {
                if (isSearching) {
                    SearchBar(query = searchQuery, onQueryChange = { newQuery ->
                        searchQuery = newQuery
                        troopViewModel.searchTroops(newQuery)
                    }, onClearClick = {
                        isSearching = false
                        searchQuery = ""
                        troopViewModel.searchTroops(searchQuery)
                    })
                } else {
                    IconButton(
                        onClick = {
                            navigator.navigate(UserDetailScreenDestination)
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                        )
                    }
                    IconButton(
                        onClick = {
                            navigator.navigate(FavoriteTroopListScreenDestination)
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                        )
                    }
                    IconButton(
                        onClick = {
                            isSearching = true
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                        )
                    }
                }
            })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                        items(allTroops) { troop ->
                            ItemTroop(troop, navigator)
                        }
                    }
                }
            }
        }
    }
}
