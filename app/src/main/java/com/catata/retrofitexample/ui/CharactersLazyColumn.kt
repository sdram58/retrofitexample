package com.catata.retrofitexample.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.catata.retrofitexample.datasource.model.CharacterInfo

@Composable
fun CharactersLazyColumn(characters: List<CharacterInfo>) {
    LazyColumn {
        items(characters) { character ->
            CharacterInfoList(character = character)
        }
    }
}