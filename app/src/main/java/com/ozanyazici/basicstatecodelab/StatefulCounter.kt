package com.ozanyazici.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// BU bir state hoisting örneğidir. Böylelikle StatelessCounter composable ını yeniden kullanılabilir ve daha esnek hale gelir.
@Composable
fun StatefulCounter(modifer: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ })
}