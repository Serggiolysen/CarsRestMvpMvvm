package com.lysenko.carsNoArch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lysenko.carsNoArch.entity.Poi
import com.lysenko.cars_MVP.R

class BonttomSheetFragment(private val selectCarInterface: SelectCarInterface) : Fragment(), RVAdapter.Clicklistener,
    CarRepositoryResult {
    private lateinit var recyclerView: RecyclerView

    override fun onItemClick(item: Poi) {
        selectCarInterface.select(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.some_fragment, null)
        recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        println("AAA -------->  BonttomSheetFragment() onCreateView   ")

        RetrofitProvider.getPoiFromNet(this)
        return v
    }

    override fun onSuccess(list: List<Poi>) {

        recyclerView.adapter = RVAdapter(list, this)
        println("AAA -------->  BonttomSheetFragment() onSuccess")

    }

    override fun onError(throwable: Throwable) {
        println("AAA -------->  onError" + throwable)
    }

}