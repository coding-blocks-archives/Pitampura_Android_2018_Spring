package com.codingblocks.maps

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val delhi = LatLng(28.7, 77.2)
        mMap.addMarker(MarkerOptions().position(delhi).title("Saddi Dilli"))


        val cb = LatLng(28.6969421,77.1423825)
        mMap.addMarker(MarkerOptions().position(cb).title("CB"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cb, 14.toFloat()))

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isTiltGesturesEnabled = true

        mMap.addCircle(
                CircleOptions()
                        .center(cb)
                        .radius(500.toDouble())
                        .strokeColor(Color.rgb(0xfc, 0x4f, 0x4f))
                        .fillColor(Color.argb(90, 0xfc, 0x4f, 0x4f))
                        .strokeWidth(2.toFloat())
        )

        mMap.addPolyline(PolylineOptions()
                .addAll(arrayListOf(
                        LatLng(28.6969421,77.1423825),
                        LatLng(29.6969421,77.1423825),
                        LatLng(27.6969421,78.1423825),
                        LatLng(28.6969421,79.1423825),
                        LatLng(26.6969421,77.1423825),
                        LatLng(26.6969421,78.1423825)
                ))
                .color(Color.BLUE)
                .width(5.toFloat())
        )

    }
}
