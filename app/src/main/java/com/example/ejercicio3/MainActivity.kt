package com.example.ejercicio3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickIncioSesion(view: View) {
        var nombre:String=findViewById<EditText>(R.id.nombreOkInicio).text.toString() as String
        var pass:String=findViewById<EditText>(R.id.passOkInicio).text.toString() as String
        if(nombre.equals("kevin")&&pass.equals("KEVIN")){
            var pantallaTienda = Intent(this, Tienda::class.java)
            startActivity(pantallaTienda)
        }else{
            Toast.makeText(this,"Error al introducir la contraseña",Toast.LENGTH_LONG).show()
        }

    }
}
