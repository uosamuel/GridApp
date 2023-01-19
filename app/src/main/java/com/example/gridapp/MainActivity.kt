package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapp.data.DataSource
import com.example.gridapp.model.Topic
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid(topic = DataSource.topics)

                }
            }
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .height(68.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(id = topic.ImageResource),
                contentDescription = stringResource(id = topic.StringResource),
                modifier = Modifier.width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Text(
                    text = stringResource(id = topic.StringResource),
                    style = MaterialTheme.typography.body2,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.numberOfCourse.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(topic: List<Topic>, modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(topic) { topic ->
            TopicCard(topic = topic)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridAppTheme {
        TopicGrid(topic = DataSource.topics)
    }
}