
package com.example.msmtest.presentation.people

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.example.msmtest.presentation.people.component.ItemPeopleCard
import com.example.msmtest.presentation.people.component.TopBar
import androidx.compose.foundation.lazy.items

@Composable
fun Home(navController: NavHostController, toggleTheme: () -> Unit) {
val peopleViewModel : PeopleViewModel = hiltViewModel()
    val state = peopleViewModel.state.value

    LazyColumn {
        item {
            TopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(state.people ?: emptyList()) {
            ItemPeopleCard(
                it,
                onItemClicked = { people ->
                    navController.navigate("details/${people.firstName}/${people.dateOfBirth}")
                }
            )
        }
    }
}

