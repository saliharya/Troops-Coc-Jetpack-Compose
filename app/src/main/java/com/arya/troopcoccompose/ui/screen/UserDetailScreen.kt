package com.arya.troopcoccompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.arya.troopcoccompose.ui.viewmodel.UserViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun UserDetailScreen(userViewModel: UserViewModel = hiltViewModel()) {
    val userData by userViewModel.userData.observeAsState()

    LaunchedEffect(Unit) {
        userViewModel.loadUserData()
    }

    userData?.let { user ->
        val imgUrl = user.imgUrl
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(imgUrl)
                .size(coil.size.Size.ORIGINAL).build()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painter,
                    contentDescription = user.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(300.dp)
                        .clip(CircleShape)
                        .fillMaxSize()
                )
            }
            Spacer(Modifier.height(24.dp))
            Text(
                text = user.name,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = user.email,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    } ?: run {
        CircularProgressIndicator(modifier = Modifier.wrapContentSize(Alignment.Center))
    }
}

