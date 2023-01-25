package com.example.imc.services

import android.widget.EditText

class Validate(private val weight: EditText, private val height:EditText)
{

    fun validate() : Boolean = weight.text.isNullOrEmpty() || height.text.isNullOrEmpty()

}