package com.codingblocks.runtimepermissions

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permWrite = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permRead = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)





        btnWriteFile.setOnClickListener {
            if (permRead == PackageManager.PERMISSION_GRANTED
                    && permWrite == PackageManager.PERMISSION_GRANTED) {
                writeDataToFile()
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ),
                        111
                )
            }
        }
    }

    fun writeDataToFile () {
        val sdCard = Environment.getExternalStorageDirectory()
        val testFile = File(sdCard, "test.txt")

        testFile.writeText("HELLO WORLD")
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {

        if (requestCode == 111) {
            // Coming here from the btnWriteFile function
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
                writeDataToFile()
            } else {
                Toast.makeText(this, "UNABLE TO WRITE WITHOUT PERMISSION", Toast.LENGTH_SHORT)
                        .show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
