package com.example.imc.services

import androidx.lifecycle.MutableLiveData
import com.example.imc.entity.Person

data class Calculator (val person: MutableLiveData<Person>){

    fun calculate() : Float = person.value?.weight!! / (person.value?.height!!*person.value?.height!!)

}