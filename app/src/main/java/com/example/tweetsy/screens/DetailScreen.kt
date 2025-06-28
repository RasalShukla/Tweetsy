package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.DetailViewModel
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen() {
    //val detailViewModel : DetailViewModel = viewModel()
    val detailViewModel : DetailViewModel = hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues()),
        content = {
        items(tweets.value){ tweet ->
            TweetListItem(tweet.text)
        }
    })
}
@Composable
fun TweetListItem(tweet : String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp,Color(0xFFCCCCCC)),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    )
}