package com.jianastrero.templateandroidapp.activity

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jianastrero.templateandroidapp.navgraph.MainNavGraph
import com.jianastrero.templateandroidapp.ui.theme.TemplateAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity(), ViewTreeObserver.OnPreDrawListener {

    private var splashScreenTimerStart = 0L

    private lateinit var content: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateAndroidAppTheme {
                MainNavGraph()
            }
        }

        content = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(this)

        CoroutineScope(Dispatchers.Default).launch {
            splashScreenTimerStart = System.currentTimeMillis()
            while (System.currentTimeMillis() > splashScreenTimerStart + SPLASH_SCREEN_DURATION) {
                delay(100)
            }
        }
    }

    override fun onPreDraw(): Boolean {
        return if (System.currentTimeMillis() > splashScreenTimerStart + SPLASH_SCREEN_DURATION) {
            content.viewTreeObserver.removeOnPreDrawListener(this)
            true
        } else {
            false
        }
    }

    companion object {
        private const val SPLASH_SCREEN_DURATION = 1_500L
    }
}

@Preview
@Composable
private fun MainActivityPreview() {
    TemplateAndroidAppTheme {
        MainNavGraph()
    }
}
