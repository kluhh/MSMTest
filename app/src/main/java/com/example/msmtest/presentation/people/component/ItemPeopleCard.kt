package com.example.msmtest.presentation.people.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.msmtest.domain.model.PeopleItemModel

@Composable
fun ItemPeopleCard(people: PeopleItemModel, onItemClicked: (people: PeopleItemModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(people) }),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val painter: Painter = rememberImagePainter(data = people.avatarImage)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = painter,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = people.firstName.toString(),
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
//                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
//                    style = typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = buildString {
                        append(people.dateOfBirth)
                        append("yrs | ")
//                        append(people.)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
//                    color = MaterialTheme.colors.surface,
//                    style = typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {

//                    val location: Painter = painterResource(id = R.drawable.ic_location)

//                    Icon(
//                        painter = location,
//                        contentDescription = null,
//                        modifier = Modifier.size(16.dp, 16.dp),
//                        tint = Color.Red
//                    )

                    Text(
                        text = people.role.toString(),
                        modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
//                        color = MaterialTheme.colors.surface,
//                        style = typography.caption
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
//                GenderTag(dog.gender)
            }
        }
    }
}