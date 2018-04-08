package com.codingblocks.camera

import android.Manifest
import android.content.pm.PackageManager
import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.os.SystemClock
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.Surface
import android.view.SurfaceHolder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    val TAG = "CAM"
    lateinit var cam: Camera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
                this,
                arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                101
        )

        fun startPreview () {
            cam.setPreviewDisplay(surfaceView.holder)
            when (windowManager.defaultDisplay.rotation) {
                Surface.ROTATION_0 -> cam.setDisplayOrientation(90)
                Surface.ROTATION_90 -> cam.setDisplayOrientation(0)
                Surface.ROTATION_180 -> cam.setDisplayOrientation(270)
                Surface.ROTATION_270 -> cam.setDisplayOrientation(180)
            }
            cam.startPreview()
        }

        surfaceView.holder.addCallback(object: SurfaceHolder.Callback {
            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
                holder?.surface?.let {
                    try {
                        cam.stopPreview()
                    } catch (e: Exception) {
                        Log.e(TAG, "No preview to stop", e)
                    }

                    try {
                        startPreview()
                    } catch (e: Exception) {
                        Log.e(TAG, "No preview to stop", e)
                    }
                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
            }

        })

        btnPreview.setOnClickListener {
            cam = Camera.open()
            Log.d(TAG, cam.toString())
            cam.parameters.pictureSize.let {
                Log.d(TAG, "${it.width}x${it.height}")
            }
            cam.parameters.previewSize.let {
                Log.d(TAG, "${it.width}x${it.height}")
            }
            startPreview()
        }

        btnCapture.setOnClickListener {
            cam.takePicture(
                    null,
                    null,
                    object: Camera.PictureCallback {
                        override fun onPictureTaken(data: ByteArray?, camera: Camera?) {
                            Log.d(TAG, "picsize = ${data?.size}")
                            if (data == null) return
                            val timeStamp = System.currentTimeMillis()
                            with(File(Environment.getExternalStorageDirectory(), "pic-$timeStamp.jpg")) {
                                writeBytes(data)
                            }
                            startPreview()

                        }

                    }
            )
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode == 101) {
            if (grantResults.reduce{ acc, i -> acc+i } == 0) {

            } else {
                Toast.makeText(this, "CANNOT USE APP WITHOUT CAMERA PERM", Toast.LENGTH_SHORT)
                        .show()
                finish()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
