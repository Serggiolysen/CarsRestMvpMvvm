package com.lysenko.cars_MVP.presenter

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.lysenko.cars_MVP.MainContract
import com.lysenko.cars_MVP.R
import com.lysenko.cars_MVP.utils.MapFactory
import com.lysenko.cars_MVP.utils.RVAdapter
import com.lysenko.cars_MVP.utils.RetrofitProvider
import com.lysenko.cars_MVP.model.entity.Poi

class BottomSheetPresenter : MainContract.IPresenterBottomFragment, RVAdapter.Clicklistener {

    private lateinit var recyclerView: RecyclerView

    init {
        RetrofitProvider.getPoiFromNet(this)
    }

    fun createRV(recyclerView: RecyclerView, context: Context) {
        this.recyclerView = recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onSucsessList(list: List<Poi>) {
        recyclerView.adapter = RVAdapter(list, this)
    }

    override fun onErrorList(throwable: Throwable) {
        Log.e("TAG", throwable.message!!)
    }

    override fun onItemClick(item: Poi) {
        MapFactory.map().moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(item.coordinate!!.latitude, item.coordinate.longitude),
                11.0F
            )
        )
        MapFactory.map().addCircle(
            CircleOptions()
                .center(LatLng(item.coordinate.latitude + 0.003, item.coordinate.longitude))
                .radius(1000.0)
                .fillColor(R.color.redTranspo)
                .strokeColor(0)
        )
    }
}
