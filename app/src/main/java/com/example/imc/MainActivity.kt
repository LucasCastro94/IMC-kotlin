package com.example.imc

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imc.databinding.ActivityMainBinding
import com.example.imc.entity.Person
import com.example.imc.services.Result
import com.example.imc.services.ResultImages
import com.example.imc.services.Validate
import com.example.imc.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bind: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.buttonSum.setOnClickListener(this)
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]



    }


    override fun onClick(v: View)
    {
        when (v.id)
        {
            R.id.button_sum -> click()
        }
    }




    private fun popupResult(result: String, imageID : Int)
    {
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_dialog_result)
        dialog.setCancelable(true)
        val textResult = dialog.findViewById<TextView>(R.id.popup_sum)
        val imageResult = dialog.findViewById<ImageView>(R.id.popup_image)
        textResult.text = result
        imageResult.setImageResource(imageID)
        dialog.show()
    }

    private fun click()
    {

        if(!Validate(bind.inputWeight,bind.inputHeight).validate())
        {
            mViewModel.person.value = Person(bind.inputHeight.text.toString().toFloat(),bind.inputWeight.text.toString().toFloat())

            mViewModel.resultSum()

            popupResult(mViewModel.result.value!!,mViewModel.imageID.value!!)

        }else
        {
            Toast.makeText(this, "Campos Vazios", Toast.LENGTH_SHORT).show()
        }

    }

}