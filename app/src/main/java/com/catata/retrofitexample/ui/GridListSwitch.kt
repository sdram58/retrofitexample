package com.catata.retrofitexample.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridListSwitch(
    listViewChecked: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Ver como: Cuadrícula")
        Switch(
            checked = listViewChecked,
            onCheckedChange = { onValueChange(it) },
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(text = "Lista")
    }
}
