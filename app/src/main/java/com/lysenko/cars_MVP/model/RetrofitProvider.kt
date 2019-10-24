package com.lysenko.cars_MVP.model

import com.lysenko.cars_MVP.model.entity.CarResponse
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun getCall(): Call<CarResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://kiparo.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        val call = jsonPlaceHolderApi.getCars(3333.0, 342.0, 3242.0, 3453.0)
        return call
    }

    fun getPoiFromNet(carRepositoryResult: CarRepositoryResult) {
        println("AAA --------> RetrofitProvider getPoiFromNet " )
        getCall().enqueue(object : Callback<CarResponse> {
            override fun onFailure(call: Call<CarResponse>, t: Throwable) {
                carRepositoryResult.onError(Throwable("onFailure retrofit"))
            }
            override fun onResponse(call: Call<CarResponse>, response: Response<CarResponse>) {
                if (response.isSuccessful) {
                    println("AAA --------> RetrofitProvider onResponse " + response.body()!!.poiList)
                    carRepositoryResult.onSuccess(response.body()!!.poiList)
                }
            }
        })
    }
}



