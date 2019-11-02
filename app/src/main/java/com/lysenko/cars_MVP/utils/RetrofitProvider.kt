package com.lysenko.cars_MVP.utils

import retrofit2.*
import com.lysenko.cars_MVP.MainContract
import com.lysenko.cars_MVP.model.JsonApi
import com.lysenko.cars_MVP.model.entity.CarResponse
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun getCall(): Call<CarResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://kiparo.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonApi = retrofit.create(JsonApi::class.java)
        val call = jsonApi.getCars(3333.0, 342.0, 3242.0, 3453.0)
        return call
    }

    fun getPoiFromNet(iPresenterBottomFragment: MainContract.IPresenterBottomFragment) {
        getCall().enqueue(object : Callback<CarResponse> {
            override fun onFailure(call: Call<CarResponse>, t: Throwable) {
                iPresenterBottomFragment.onErrorList(Throwable("onFailure retrofit"))
            }
            override fun onResponse(call: Call<CarResponse>, response: Response<CarResponse>) {
                if (response.isSuccessful) {
                    iPresenterBottomFragment.onSucsessList(response.body()!!.poiList)
                }
            }
        })
    }
}



