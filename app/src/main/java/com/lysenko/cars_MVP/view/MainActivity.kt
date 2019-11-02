package com.lysenko.cars_MVP.view

import android.os.Bundle
import com.lysenko.cars_MVP.R
import com.lysenko.cars_MVP.utils.MapFactory
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.maps.SupportMapFragment
import com.lysenko.cars_MVP.presenter.MainActivityPresenter
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetBehavior = BottomSheetBehavior.from(botom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false

        MapFactory.setSupportMapFragment(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment)

        MainActivityPresenter().getMap(MapFactory.getSupportMapFragment())

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.botom_sheet, BonttomSheetFragment())
            transaction.commit()
        }
    }
}