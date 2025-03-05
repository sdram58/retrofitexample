package com.catata.retrofitexample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.catata.retrofitexample.R
import com.catata.retrofitexample.datasource.model.CharacterInfo
import com.catata.retrofitexample.ui.viewmodels.CharacterViewModel

@Composable
fun Content() {
    // ViewModel
    val characterViewModel = remember { CharacterViewModel() }

    // State variables observed from ViewModel
    val characters: List<CharacterInfo> by characterViewModel.characters.observeAsState(initial = emptyList())
    val isLoadingBooks: Boolean by characterViewModel.isLoading.observeAsState(initial = false)
    val responseError: Boolean by characterViewModel.responseError.observeAsState(initial = false)

    // State variable for search input
    var searchedCharacter by rememberSaveable { mutableStateOf(value = "") }

    // State variable for the list/grid switch
    var listViewChecked by rememberSaveable { mutableStateOf(value = false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rick),
            contentDescription = "Rick & Morty logo",
            modifier = Modifier.weight(1f)
        )

        SearchBox(
            searchedCharacter = searchedCharacter,
            onValueChange = { searchedCharacter = it },
            onClickPress = { characterViewModel.loadCharacterList(searchedCharacter) },
            modifier = Modifier.weight(1f)
        )

        // Box to show loading or fetched information
        Box(modifier = Modifier.weight(8f)) {
            if (isLoadingBooks) {
                LoadingInfo()
            } else if (responseError) {
                Text(text = "\"$searchedCharacter\" does not match any character")
            } else {
                if (characters.isNotEmpty()) {
                    Column {
                        GridListSwitch(
                            listViewChecked = listViewChecked,
                            onValueChange = { listViewChecked = it }
                        )
                        if (listViewChecked)
                            CharactersLazyColumn(characters = characters)
                        else
                            CharactersVerticalGrid(characters = characters)
                    }
                }
            }
        }
    }
}