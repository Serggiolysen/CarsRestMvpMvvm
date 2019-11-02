package com.lysenko.cars_MVP

import com.google.android.gms.maps.SupportMapFragment
import com.lysenko.cars_MVP.model.entity.Poi

interface MainContract {

    interface IPresenterMainActivity {
        fun getMap(map: SupportMapFragment)
    }

    interface IPresenterBottomFragment {
        fun onSucsessList(list: List<Poi>)
        fun onErrorList(throwable: Throwable)
    }
}