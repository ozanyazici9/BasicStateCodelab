package com.ozanyazici.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
// Modifier Yeniden kullanılabilirliği artıracağından, tüm şekillendirilebilir işlevlere varsayılan değer sağlamak iyi bir uygulamadır .
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable {mutableStateOf(0)}
        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
    }
}