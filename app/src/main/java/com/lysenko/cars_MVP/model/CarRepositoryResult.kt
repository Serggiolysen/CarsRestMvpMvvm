package com.lysenko.cars_MVP.model

import com.lysenko.cars_MVP.model.entity.Poi

interface CarRepositoryResult {
    fun onSuccess(list: List<Poi>)
    fun onError(throwable: Throwable)
}

interface SelectCarInterface{
    fun select(item: Poi)
}