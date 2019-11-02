package com.lysenko.cars_MVP.presenter

import android.util.Log
import com.lysenko.cars_MVP.R
import com.lysenko.cars_MVP.MainContract
import com.lysenko.cars_MVP.model.entity.Poi
import com.lysenko.cars_MVP.utils.MapFactory
import com.google.android.gms.maps.model.LatLng
import com.lysenko.cars_MVP.utils.RetrofitProvider
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MainActivityPresenter : MainContract.IPresenterMainActivity, MainContract.IPresenterBottomFragment {

    private var poiList = mutableListOf<Poi>()

    init {
        RetrofitProvider.getPoiFromNet(this)
    }

    override fun getMap(map: SupportMapFragment) {
        MapFactory.getGoogleMap(map)
    }

    override fun onSucsessList(list: List<Poi>) {
        poiList.addAll(list)
        MapFactory.map()
            .moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(53.63866991354654, 9.990935212464525), 11.0F))
        val carMarker = BitmapDescriptorFactory.fromResource(R.drawable.car3)
        for (p in poiList) {
            MapFactory.map().addMarker(
                MarkerOptions().position(
                    LatLng(
                        p.coordinate!!.latitude, p.coordinate.longitude
                    )
                ).title("Cab ID = " + p.id.toString()).icon(carMarker)
            )
        }
    }

    override fun onErrorList(throwable: Throwable) {
        Log.e("TAG", throwable.message!!)
    }
}

