package com.jianastrero.templateandroidapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jianastrero.templateandroidapp.ui.theme.TemplateAndroidAppTheme
import com.jianastrero.templateandroidapp.viewmodel.domain.IHomeViewModel
import com.jianastrero.templateandroidapp.viewmodel.implementation.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNextClick: (message: String, value: Float) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: IHomeViewModel = viewModel<HomeViewModel>()
) {
    val state by viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(64.dp),
        modifier = Modifier
            .padding(
                horizontal = 12.dp,
                vertical = 64.dp
            )
            .then(modifier)
    ) {
        Text(
            text = "Home Screen",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = state.message,
            onValueChange = {
                viewModel.updateState(state.copy(message = it))
            },
            label = { Text("Message") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Slider(
            value = state.value,
            onValueChange = {
                viewModel.updateState(state.copy(value = it))
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                onNextClick(state.message, state.value)
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(
                text = "View Details",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    TemplateAndroidAppTheme {
        HomeScreen(
            onNextClick = { _, _ -> },
            viewModel = IHomeViewModel.Preview
        )
    }
}
