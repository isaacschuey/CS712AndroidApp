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

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme() {
                Surface {
                    Column(modifier = Modifier.statusBarsPadding().padding(10.dp)) {
                        SoftwareChallenges(
                            challenges = arrayOf(
                                "Device Fragmentation", "OS Fragmentation",
                                "Unstable/Dynamic Environment", "Rapid Changes",
                                "Low Tolerance"
                            )
                        )
                        Button(
                            onClick = {
                                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text(text = "Go Back")
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun SoftwareChallenges(challenges: Array<String>) {

    Text (
        text =  "5 Mobile Software Engineering Challenges:\n" +
                "\t1) ${challenges[0]}\n" +
                "\t2) ${challenges[1]}\n" +
                "\t3) ${challenges[2]}\n" +
                "\t4) ${challenges[3]}\n" +
                "\t5) ${challenges[4]}"
    )

}
