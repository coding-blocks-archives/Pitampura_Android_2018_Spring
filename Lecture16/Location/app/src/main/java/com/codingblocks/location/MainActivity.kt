package com.codingblocks.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LocationListener {
    val TAG = "LOC"
    lateinit var locMan: LocationManager

    override fun onLocationChanged(location: Location?) {
        location?.let {
            Log.d(TAG, """
                latitude = ${it.latitude}
                longitude = ${it.longitude}
                altitude = ${it.altitude}
                accuracy = ${it.accuracy}
            """.trimIndent())

        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {
        Log.d("LOC", "PROVIDER ENABLED")
    }

    override fun onProviderDisabled(provider: String?) {
        Log.d("LOC", "PROVIDER DISABLED")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetLoc.setOnClickListener {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    123
            )
        }

        locMan = getSystemService(Context.LOCATION_SERVICE) as LocationManager

    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {

        for (i in 1 until grantResults.size) {
            if (permissions[i] == Manifest.permission.ACCESS_FINE_LOCATION ||
                    permissions[i] == Manifest.permission.ACCESS_COARSE_LOCATION) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {

                    locMan.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            30 * 1000,
                            10F,
                            this
                    )
                }

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
