package com.example.imc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imc.entity.Person
import com.example.imc.services.Calculator
import com.example.imc.services.Result


class MainViewModel: ViewModel(), Result.setImage {


    private var mPerson = MutableLiveData<Person>()
    var person = mPerson

    private var mResult = MutableLiveData<String>()
    var result = mResult

    private val mImage = MutableLiveData<Int>()
    var imageID = mImage


    override fun imageID(id: Int) {
     imageID.value=id
    }

    fun resultSum()
    {
        result.value = Result(Calculator(person).calculate(),this).result()

    }




}