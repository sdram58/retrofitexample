package com.catata.retrofitexample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun SearchBox(
    searchedCharacter: String,
    onValueChange: (String) -> Unit,
    onClickPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Variables para controlar el Foco/Teclado
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 8.dp).then(modifier)
    ) {
        OutlinedTextField(
            value = searchedCharacter,
            onValueChange = onValueChange,
            modifier = Modifier.weight(3f)
        )
        Button(
            onClick = {
                onClickPress()
                // Ocultar el teclado borrando el foco de donde esté
                focusManager.clearFocus()
                // También se puede cerrar el teclado directamente
                // keyboardController?.hide()
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Buscar")
        }
    }
}
