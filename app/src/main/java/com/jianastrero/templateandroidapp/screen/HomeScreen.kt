package com.jianastrero.templateandroidapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jianastrero.templateandroidapp.ui.theme.TemplateAndroidAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Home Screen")
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    TemplateAndroidAppTheme {
        HomeScreen()
    }
}
