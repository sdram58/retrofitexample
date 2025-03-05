package com.catata.retrofitexample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.catata.retrofitexample.datasource.model.CharacterInfo

@Composable
fun CharactersVerticalGrid(characters: List<CharacterInfo>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(characters) { character ->
            CharacterInfoGrid(character = character)
        }
    }
}