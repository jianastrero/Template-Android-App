package com.jianastrero.templateandroidapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jianastrero.templateandroidapp.navgraph.MainNavGraph
import com.jianastrero.templateandroidapp.ui.theme.TemplateAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateAndroidAppTheme {
                MainNavGraph()
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityPreview() {
    TemplateAndroidAppTheme {
        MainNavGraph()
    }
}
