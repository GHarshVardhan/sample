package com.example.sampleapp.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sampleapp.businesslogic.MainViewModel
import com.example.sampleapp.models.Result
import com.example.sampleapp.ui.theme.SampleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecyclerView()
                }
            }
        }
    }
}

@Composable
fun ListItem(result: Result) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row() {
                Column(modifier = Modifier.weight(1f)) {
                    result.exchange?.let { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
                }
            }
        }
    }
}
@Composable
fun RecyclerView(){
    val mainViewModel: MainViewModel= hiltViewModel()
    val results: List<Result> by mainViewModel.allResults.observeAsState(listOf())
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = results){result ->
            ListItem(result = result)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleAppTheme {
        val result=Result(exchange = "test")
        RecyclerView()
    }
}