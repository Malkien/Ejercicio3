package com.example.ejercicio3

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_tienda.view.*
import android.os.Vibrator
import android.os.Build
import android.os.VibrationEffect
import android.widget.GridView
import com.example.ejercicio3.Clases.Personaje


class Tienda : AppCompatActivity() {
    lateinit private var img1: Personaje;
    lateinit private var img2: Personaje;
    lateinit private var img3: Personaje;
    lateinit private var img4: Personaje;
    lateinit private var img5: Personaje;
    lateinit private var img6: Personaje;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        var gridView:GridView=this.findViewById(R.id.dinamico)
        var img=ArrayList<Personaje>();

        //img1
        img.add(Personaje(
            "dante", 100f,
            "android.resource://" + packageName + "//" + R.drawable.dante
        ))
        //img2
        img.add(Personaje(
            "vergil", 150f,
            "android.resource://" + packageName + "//" + R.drawable.vergil
        ))
        //img3
        img.add( Personaje(
            "nero", 80.5f,
            "android.resource://" + packageName + "//" + R.drawable.nero
        ))
        //Img4
        img.add(Personaje(
            "lucia", 19.99f,
            "android.resource://" + packageName + "//" + R.drawable.lucia
        ))
        //img5
        img.add(Personaje(
            "trish", 110f,
            "android.resource://" + packageName + "//" + R.drawable.trish
        ))
        //img6
        img.add(Personaje(
            "lady", 500f,
            "android.resource://" + packageName + "//" + R.drawable.lady
        ))
        var adapter:AdapterTienda=AdapterTienda(this,img)
        gridView.adapter=adapter
    }
}
