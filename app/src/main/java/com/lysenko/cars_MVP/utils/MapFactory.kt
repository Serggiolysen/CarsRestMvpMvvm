package com.lysenko.cars_MVP.utils

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

object MapFactory : OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private lateinit var supportMapFragment: SupportMapFragment

    fun setSupportMapFragment(supportMapFragment: SupportMapFragment) {
        this.supportMapFragment = supportMapFragment
    }

    fun getSupportMapFragment(): SupportMapFragment {
        return supportMapFragment
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!
    }

    fun getGoogleMap(map: SupportMapFragment) {
        map.getMapAsync(this)
    }

    fun map(): GoogleMap {
        return map
    }
}