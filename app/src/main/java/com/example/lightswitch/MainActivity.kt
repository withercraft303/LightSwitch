package com.example.lightswitch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.hardware.camera2.CameraManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lightToggle = findViewById<Button>(R.id.LightToggleButton)
        var lightOn = false

        val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var camID = ""

        try {
            camID = camManager.cameraIdList[0]
        } catch (e: Exception) {

        }

        lightToggle.setOnClickListener{
            if (camID != ""){
                lightOn = !lightOn
                try {
                    camManager.setTorchMode(camID, lightOn)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                // display error message
                // camera torch not found
            }
        }
    }
}