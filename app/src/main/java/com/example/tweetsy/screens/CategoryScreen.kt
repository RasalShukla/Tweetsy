package com.example.tweetsy.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.CategoryViewModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tweetsy.R

@Composable
fun CategoryScreen(onClick : (category : String) -> Unit) {
    //val categoryViewModel: CategoryViewModel = viewModel()
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()

    if(categories.value.isEmpty()){
      Box(
          modifier = Modifier.fillMaxSize(1f),
          contentAlignment = Alignment.Center){
          Text(
              text = "Loading...",
              style = MaterialTheme.typography.displayMedium
              )
      }
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues()),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(categories.value.distinct()) { category ->
                CategoryItem(category,onClick)
            }
        }
    }
}


@Composable
fun CategoryItem(category : String, onClick : (category : String) -> Unit){

    Box(modifier = Modifier
        .padding(4.dp)
        .clickable {
            onClick(category)
        }
        .size(160.dp)
        .clip(RoundedCornerShape(8.dp))
        .paint(painter = painterResource(id = R.drawable.bg),
            contentScale = ContentScale.Crop)
        .border(1.dp, Color(0XEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ){
        Text(
            text =category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp,20.dp),//horizantol
            style = MaterialTheme.typography.bodyLarge
        )
    }
}