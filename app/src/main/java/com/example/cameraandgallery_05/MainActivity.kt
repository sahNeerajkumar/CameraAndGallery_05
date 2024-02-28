package com.example.cameraandgallery_05

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    private lateinit var cameraPerText: TextView
    private lateinit var cameraPerButton: Button
    private lateinit var galleryPerText: TextView
    private lateinit var galleryPerButton: Button
    private lateinit var imageView: ImageView

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        galleryPerText = findViewById(R.id.galleryPremission_textView)
        galleryPerButton = findViewById(R.id.galleryPremission_button)
        cameraPerText = findViewById(R.id.cameraPermission_textView)
        cameraPerButton = findViewById(R.id.cameraPermission_Button)
        imageView = findViewById(R.id.image_show)

        cameraPerButton.setOnClickListener {
            OpenCameraAndTakeImage()
        }



        cameraPerButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                cameraPerText.text = "camera has granted permission"
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
            }

        }
    }

    fun OpenCameraAndTakeImage() {
        val intent = Intent(Manifest.permission.CAMERA)
        startActivity(intent)
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode ==1){
//            if ()
//        }
//    }


}


