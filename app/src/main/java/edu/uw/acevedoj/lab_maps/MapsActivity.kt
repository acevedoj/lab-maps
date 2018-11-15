package edu.uw.acevedoj.lab_maps

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.security.AccessController.getContext
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.LatLng
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
        val maryGates = LatLng(47.655, -122.3078)
        val drumheller = LatLng(47.6538, -122.3078)
        mMap.addMarker(MarkerOptions().position(maryGates).title("Marker in Mary Gates"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(maryGates))
        mMap.setMinZoomPreference(17f)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap.addMarker(MarkerOptions().position(drumheller).title("Careful of the goose poo water!").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val rectOptions = PolylineOptions()
            .add(LatLng(47.65384, -122.30817))
            .add(LatLng(47.65358, -122.30805))  // North of the previous point, but at the same longitude
            .add(LatLng(47.65376, -122.30783))  // Same latitude, and 30km to the west
            .add(LatLng(47.65363, -122.30756))  // Same longitude, and 16km to the south
            .add(LatLng(47.65396, -122.30753)) // Closes the polyline.

        // Get back the mutable Polyline
        val polyline = mMap.addPolyline(rectOptions)
        polyline.width = 15f
        polyline.color = Color.rgb(51, 0, 111)





    }
}
