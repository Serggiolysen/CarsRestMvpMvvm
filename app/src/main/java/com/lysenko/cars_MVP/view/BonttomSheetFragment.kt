package com.lysenko.cars_MVP.view

import android.os.Bundle
import android.view.View
import com.lysenko.cars_MVP.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.lysenko.cars_MVP.presenter.BottomSheetPresenter

class BonttomSheetFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.some_fragment, null)

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)

        BottomSheetPresenter().createRV(recyclerView, context!!)

        return v
    }
}
