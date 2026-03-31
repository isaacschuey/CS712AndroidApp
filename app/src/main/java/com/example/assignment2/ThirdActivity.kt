package com.example.assignment2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.asImageBitmap
import com.example.assignment2.ui.theme.Assignment2Theme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val capturedImage = mutableStateOf<Bitmap?>(null)
        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result -> val bitmap = result.data?.extras?.get("data") as? Bitmap
            capturedImage.value = bitmap
        }

        setContent {
            Assignment2Theme {
                Surface {
                    Column() {
                        Button(
                            onClick = {
                                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                                launcher.launch(intent)
                            }
                        ) {
                            Text(text = "Capture Image")
                        }
                        capturedImage.value?.let { bitmap ->
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = "Captured Image"
                            )
                        }
                    }
                }
            }
        }
    }
}