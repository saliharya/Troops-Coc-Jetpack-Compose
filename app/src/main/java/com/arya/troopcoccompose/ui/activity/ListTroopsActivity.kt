package com.arya.troopcoccompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.arya.troopcoccompose.R
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.ui.activity.destinations.TroopDetailScreenDestination
import com.arya.troopcoccompose.ui.activity.destinations.UserDetailScreenDestination
import com.arya.troopcoccompose.ui.viewmodel.TroopViewModel
import com.arya.troopcoccompose.ui.viewmodel.UserViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTroopsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Destination(start = true)
@Composable
fun TroopListScreen(navigator: DestinationsNavigator) {
    val troopViewModel: TroopViewModel = hiltViewModel()
    val allTroops by troopViewModel.troops.observeAsState(emptyList())
    val isLoading by troopViewModel.isLoading.observeAsState(false)
    val isEmpty by troopViewModel.isEmpty.observeAsState(false)

    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
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
                            keyboardActions = KeyboardActions(
                                onSearch = {
                                    troopViewModel.searchTroops(searchQuery)
                                }
                            )
                        )
                    } else {
                        Text("Troops")
                    }
                },
                actions = {
                    if (isSearching) {
                        SearchBar(
                            query = searchQuery,
                            onQueryChange = { newQuery ->
                                searchQuery = newQuery
                                troopViewModel.searchTroops(newQuery)
                            },
                            onClearClick = {
                                isSearching = false
                                searchQuery = ""
                                troopViewModel.searchTroops(searchQuery)
                            }
                        )
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
                                isSearching = true
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                            )
                        }
                    }
                }
            )
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
                    // Center the "No Troops Found" text
                    Text(
                        "No Troops Found",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                } else {
                    // Show the list of troops
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


@Destination
@Composable
fun UserDetailScreen(userViewModel: UserViewModel = hiltViewModel()) {
    val userData by userViewModel.userData.observeAsState()

    LaunchedEffect(Unit) {
        userViewModel.loadUserData()
    }

    userData?.let { user ->
        val painter = rememberAsyncImagePainter(model = user.imgUrl)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painter,
                    contentDescription = user.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(Modifier.height(24.dp))
            Text(
                text = user.name, style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = user.email,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    } ?: run {
        CircularProgressIndicator(modifier = Modifier.wrapContentSize(Alignment.Center))
    }
}


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
}


@Composable
fun ItemTroop(troop: Troop, navigator: DestinationsNavigator) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .clickable { navigator.navigate(TroopDetailScreenDestination(troop)) }
    ) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text(stringResource(R.string.search_troop)) },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            singleLine = true
        )
        IconButton(
            onClick = {
                onClearClick()
            },
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear",
            )
        }
    }
}