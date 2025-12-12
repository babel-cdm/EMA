package es.babel.easymvvm.presentation.ui.compose

import android.os.Bundle
import android.view.Gravity.CENTER
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import es.babel.easymvvm.R
import es.babel.easymvvm.presentation.ui.compose.theme.BabelTheme
import es.babel.easymvvm.presentation.ui.compose.theme.darkOrange
import es.babel.easymvvm.presentation.ui.compose.theme.lightOrange
import es.babel.easymvvm.presentation.ui.compose.theme.tealOrange

class ComposeViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BabelTheme {
                ComposeView()
            }
        }
    }

}

@Composable
fun ComposeView() {

    // Scaffold: Generic template with various components commonly used on Android screens
    Scaffold(

        // TopBar: In it we will introduce the Composable we want to show as Toolbar
        // at the top of the screen, if we do not customise any we can use
        // the default one called TopAppBar
        topBar = {
            TopAppBar(
                title = {
                    Text("Compose View")
                },
                backgroundColor = lightOrange,
                elevation = 0.dp
            )
        },

        // FloatingButton: This will be the floating button that we will show at the bottom
        // right or left and where we can put different actions we want or
        // navigate to other screens
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                backgroundColor = darkOrange,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                )
            ) { Text("X") }
        },

        // DrawerContent: In this we will introduce the Composable we want to show
        // in the drop-down menu on the sides (in my opinion these types of menus are
        // less and less used every day)
        drawerContent = { Text(text = "DrawerContent") },
        backgroundColor = tealOrange
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Compose State
            val state = remember { mutableStateOf(0) }

            // Use Android Widget Image View to load images with XML format
            AndroidView(factory = { ctx ->
                ImageView(ctx).apply {
                    val drawable = ContextCompat.getDrawable(ctx, R.drawable.ic_error)
                    setImageDrawable(drawable)
                }
            })

            Spacer(modifier = Modifier.height(10.dp))

            // Use Material Button to load a Button with Material style with XML format
            AndroidView(factory = { ctx ->
                MaterialButton(ctx).apply {
                    text = "Android XML Buttom"
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                    setOnClickListener { state.value++ }
                }
            })

            Spacer(modifier = Modifier.height(10.dp))

            // Use Android Widget Text to load a string with XML format
            AndroidView(factory = { ctx ->
                TextView(ctx).apply {
                    layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }
            }, update = {
                it.text = "You have clicked the buttons: ${state.value} times"
            })

        }

    }

}