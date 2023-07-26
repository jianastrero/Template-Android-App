package com.jianastrero.templateandroidapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jianastrero.templateandroidapp.component.DetailItem
import com.jianastrero.templateandroidapp.model.detail.DetailArguments
import com.jianastrero.templateandroidapp.ui.theme.TemplateAndroidAppTheme

@Composable
fun DetailScreen(
    detailArguments: DetailArguments,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                horizontal = 12.dp,
                vertical = 64.dp
            )
            .then(modifier)
    ) {
        Text(
            text = "Detail Screen",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(64.dp))
        DetailItem(
            title = "Message",
            value = detailArguments.title,
            modifier = Modifier.fillMaxWidth()
        )
        DetailItem(
            title = "Value",
            value = detailArguments.value,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 12.dp)
        )
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    TemplateAndroidAppTheme {
        DetailScreen(DetailArguments("Hello world!", 0.696969f))
    }
}
