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
        //img1
        img1= Personaje(
            "dante", 100f,
            "android.resource://" + packageName + "//" + R.drawable.dante
        )
        var carta:CardView = findViewById<CardView>(R.id.contenedor1)
        carta.texto1.text="nombre: "+img1.nombre+"\n" +
                "Precio: "+img1.precio
        carta.imagen1.setImageURI(Uri.parse(img1.rutaImagen))
        carta.boton1.setOnClickListener({cambiarPantalla(img1)})
        //img2
        img2= Personaje(
            "vergil", 150f,
            "android.resource://" + packageName + "//" + R.drawable.vergil
        )
        var carta2:CardView = findViewById<CardView>(R.id.contenedor2)
        carta2.texto2.text="nombre: "+img2.nombre+"\n" +
                "Precio: "+img2.precio
        carta2.imagen2.setImageURI(Uri.parse(img2.rutaImagen))
        carta2.boton2.setOnClickListener({cambiarPantalla(img2)})
        //img3
        img3= Personaje(
            "nero", 80.5f,
            "android.resource://" + packageName + "//" + R.drawable.nero
        )
        var carta3:CardView = findViewById<CardView>(R.id.contenedor3)
        carta3.texto3.text="nombre: "+img3.nombre+"\n" +
                "Precio: "+img3.precio
        carta3.imagen3.setImageURI(Uri.parse(img3.rutaImagen))
        carta3.boton3.setOnClickListener({cambiarPantalla(img3)})
        //Img4
        img4= Personaje(
            "lucia", 19.99f,
            "android.resource://" + packageName + "//" + R.drawable.lucia
        )
        var carta4:CardView = findViewById<CardView>(R.id.contenedor4)
        carta4.texto4.text="nombre: "+img4.nombre+"\n" +
                "Precio: "+img4.precio
        carta4.imagen4.setImageURI(Uri.parse(img4.rutaImagen))
        carta4.boton4.setOnClickListener({cambiarPantalla(img4)})
        //img5
        img5= Personaje(
            "trish", 110f,
            "android.resource://" + packageName + "//" + R.drawable.trish
        )
        var carta5:CardView = findViewById<CardView>(R.id.contenedor5)
        carta5.texto5.text="nombre: "+img5.nombre+"\n" +
                "Precio: "+img5.precio
        carta5.imagen5.setImageURI(Uri.parse(img5.rutaImagen))
        carta5.boton5.setOnClickListener({cambiarPantalla(img5)})
        //img6
        img6= Personaje(
            "lady", 500f,
            "android.resource://" + packageName + "//" + R.drawable.lady
        )
        var carta6:CardView = findViewById<CardView>(R.id.contenedor6)
        carta6.texto6.text="nombre: "+img6.nombre+"\n" +
                "Precio: "+img6.precio
        carta6.imagen6.setImageURI(Uri.parse(img6.rutaImagen))
        carta6.boton6.setOnClickListener({cambiarPantalla(img6)})

    }
    fun cambiarPantalla(personaje: Personaje){
        var pantalla:Intent= Intent(this,MostarProducto::class.java)
        var bund:Bundle=Bundle()
        bund.putSerializable("persona",personaje)
        pantalla.putExtras(bund)
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(3000,0))
        }else{
            v.vibrate(2000)
        }
        this.startActivity(pantalla)
    }
}
