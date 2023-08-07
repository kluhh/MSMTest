package com.example.msmtest.presentation.people


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.msmtest.R
import com.example.msmtest.domain.model.PeopleItemModel
import com.example.msmtest.presentation.people.component.PeopleInfoCard
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(navController: NavController, people_item: PeopleItemModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { people_item.firstName?.let { Text(it) } },
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "go back",
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = colorResource(id = R.color.text)
                    )
                }

            )
        },
        content = { DetailsView(people_item) }
    )


}

@Composable
fun DetailsView(people_item: PeopleItemModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {


        // Basic details
        item {
            people_item.apply {

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    painter = rememberImagePainter(people_item.avatarImage),
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

            }
        }

        item {
            people_item.apply {

                Spacer(modifier = Modifier.height(24.dp))
                PeopleInfoCard(people_item.firstName!! + " " + people_item.lastName,people_item.role!!, convertDate(people_item.dateOfBirth!!))

            }
        }

    }
}


@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = colorResource(id = R.color.text),
        style = MaterialTheme.typography.titleMedium,// Apply the desired TextStyle here
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}

fun convertDate(inputDateStr: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val outputFormat = SimpleDateFormat("d 'January' yyyy", Locale.ENGLISH)

    val inputDate: Date = inputFormat.parse(inputDateStr)
    return outputFormat.format(inputDate)
}