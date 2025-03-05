package com.catata.retrofitexample.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.catata.retrofitexample.datasource.model.CharacterInfo

@Composable
fun CharacterInfoList(character: CharacterInfo) {
    ListItem(
        headlineContent = { Text(text = character.name, fontWeight = FontWeight.Bold) },
        overlineContent = { Text(text = character.species) },
        supportingContent = {
            Text(
                text = """
                    |Origen: ${character.origin.name}
                    |Localización: ${character.location.name}
                """.trimMargin(),
                fontSize = 12.sp,
            )
        },
        leadingContent = {
            AsyncImage(
                model = character.image,
                contentDescription = "Character avatar",
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).size(80.dp),
            )
        },
        colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier.padding(4.dp).clip(RoundedCornerShape(8.dp))
    )
}