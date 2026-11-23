package io.github.smilingjey.onebeep.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.smilingjey.onebeep.ui.theme.OneBeepTheme

@Composable
fun OneBeepApp() {
    OneBeepTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {}
    }
}
