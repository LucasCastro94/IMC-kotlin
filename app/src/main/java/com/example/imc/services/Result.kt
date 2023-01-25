package com.example.imc.services

class Result (private val soma : Float, private val image: setImage ){


 fun result() : String
 {
     if(soma<18.5f)
     {
         image.imageID(ResultImages.MAGRESA)
         return String.format("Seu IMC é: %.2f\nMagresa",soma)
     }
     else if(soma in 18.5f..24.9f)
     {
         image.imageID(ResultImages.NORMAL)
         return String.format("Seu IMC é: %.2f\nNormal",soma)
     }
     else if( soma in 25f..29.9f)
     {
         image.imageID(ResultImages.SOBREPESO)
         return String.format("Seu IMC é: %.2f\nSobrepeso",soma)
     }
     else if( soma in 30f..39.9f)
     {
         image.imageID(ResultImages.OBESIDADE)
         return String.format("Seu IMC é: %.2f\nObesidade",soma)
     }
     else{
         image.imageID(ResultImages.OBESIDADE_GRAVE)
         return String.format("Seu IMC é: %.2f\nObesidade grave",soma)
     }

 }

    interface setImage{
        fun imageID(id:Int)
    }
}