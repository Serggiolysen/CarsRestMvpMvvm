package com.lysenko.cars_MVP.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lysenko.cars_MVP.*
import com.lysenko.cars_MVP.model.CarRepositoryResult
import com.lysenko.cars_MVP.model.RVAdapter
import com.lysenko.cars_MVP.model.RetrofitProvider
import com.lysenko.cars_MVP.model.SelectCarInterface
import com.lysenko.cars_MVP.model.entity.Poi

class BonttomSheetFragment(private val selectCarInterface: SelectCarInterface) : Fragment(),
    RVAdapter.Clicklistener, CarRepositoryResult {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.some_fragment, null)
        recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        RetrofitProvider.getPoiFromNet(this)
        return v
    }

    override fun onItemClick(item: Poi) {
        selectCarInterface.select(item)
    }

    override fun onSuccess(list: List<Poi>) {
        recyclerView.adapter = RVAdapter(list, this)
        println("AAA -------->  BonttomSheetFragment() onSuccess")

    }

    override fun onError(throwable: Throwable) {
        println("AAA -------->  onError" + throwable)
    }

}