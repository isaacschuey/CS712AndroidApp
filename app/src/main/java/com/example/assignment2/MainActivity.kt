package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Surface {
                    Column(modifier = Modifier.statusBarsPadding().padding(10.dp)) {

                        Greeting(
                            name = "Isaac Schumacher",
                            id = "1470564",
                        )

                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("View Mobile SWE Challenges (Explicit)")
                        }

                        Button(
                            onClick = {
                                val intent = Intent("RENDER_SECOND")
                                startActivity(intent)
                            }
                        ) {
                            Text("View Mobile SWE Challenges (Implicit)")
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun Greeting(name: String, id: String, modifier: Modifier = Modifier) {

    Text(text = "$name, $id")

}
