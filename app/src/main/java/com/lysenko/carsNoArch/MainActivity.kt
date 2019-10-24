package com.lysenko.carsNoArch

import android.os.Bundle
import com.lysenko.cars_MVP.R
import com.lysenko.carsNoArch.entity.Poi
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity(), OnMapReadyCallback, CarRepositoryResult, SelectCarInterface {
    private var poiList = mutableListOf<Poi>()

    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetBehavior = BottomSheetBehavior.from(botom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false

        if (savedInstanceState == null) {
            setFragment()
        }

        RetrofitProvider.getPoiFromNet(this)

        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
    }

    override fun onSuccess(list: List<Poi>) {
        poiList.addAll(list)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(53.63866991354654, 9.990935212464525), 11.0F))
        val carMarker = BitmapDescriptorFactory.fromResource(R.drawable.car3)
        for (p in poiList){
            map.addMarker(MarkerOptions().position(LatLng(p.coordinate!!.latitude,p.coordinate.longitude)).title("Cab ID = "+p.id.toString()).icon(carMarker))
        }
    }

    override fun select(item: Poi) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(item.coordinate!!.latitude,item.coordinate.longitude), 11.0F))
        map.addCircle(CircleOptions()
            .center(LatLng(item.coordinate!!.latitude+0.003,item.coordinate.longitude))
            .radius(1000.0)
            .fillColor(R.color.redTranspo)
            .strokeColor(0))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        println("AAA ------> MainActivity onMapReady list ")
        map = googleMap
    }

    fun setFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.botom_sheet, BonttomSheetFragment(this))
        transaction.commit()
    }

    override fun onError(throwable: Throwable) {
        println("AAA -------->  onError" + throwable)
    }


}
