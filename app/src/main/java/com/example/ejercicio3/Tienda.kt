package com.example.ejercicio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_tienda.view.*

class Tienda : AppCompatActivity() {
    lateinit private var img1:Personaje
    lateinit private var img2:Personaje
    lateinit private var img3:Personaje
    lateinit private var img4:Personaje
    lateinit private var img5:Personaje
    lateinit private var img6:Personaje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)
        var img1:Personaje=Personaje("dante", 100f,"@drawable/dante")
        var img2:Personaje=Personaje("vergil", 150f,"@drawable/vergil")
        var img3:Personaje=Personaje("nero", 80.5f,"@drawable/nero")
        var img4:Personaje=Personaje("lucia", 19.99f,"@drawable/lucia")
        var img5:Personaje=Personaje("trish", 110f,"@drawable/trish")
        var img6:Personaje=Personaje("lady", 500f,"@drawable/lady")
        escribirImagenes(img1)
    }
    fun escribirImagenes(personaje:Personaje){
        var carta:CardView = findViewById<CardView>(R.id.contenedor1)
        carta.texto1.text="Hola"
        personaje.
    }
    fun clickProducto(view: View) {

    }
}
