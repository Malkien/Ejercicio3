package com.example.ejercicio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickIncioSesion(view: View) {
        var nombre:String=findViewById<EditText>(R.id.nombreOkInicio).text as String
        var pass:String=findViewById<EditText>(R.id.passOkInicio).text as String
        if(nombre.equals("kevin")&&pass.equals("KEVIN")){

        }

    }
}
