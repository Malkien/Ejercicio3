package com.example.ejercicio3

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ActivityCompat.checkSelfPermission(
                this,
                CALL_PHONE
            ) == PackageManager.PERMISSION_DENIED ||
                ActivityCompat.checkSelfPermission(
                    this,
                    WRITE_EXTERNAL_STORAGE
                )==PackageManager.PERMISSION_DENIED ||
                ActivityCompat.checkSelfPermission(
                    this,
                    RECORD_AUDIO
                )==PackageManager.PERMISSION_DENIED)
        {
            val permisos = arrayOf(CALL_PHONE, WRITE_EXTERNAL_STORAGE, RECORD_AUDIO)
            ActivityCompat.requestPermissions(this, permisos, 0)
        }


    }

    fun clickIncioSesion(view: View) {
        var nombre:String=findViewById<EditText>(R.id.nombreOkInicio).text.toString() as String
        var pass:String=findViewById<EditText>(R.id.passOkInicio).text.toString() as String
        if(nombre.equals("")&&pass.equals("")){
            var pantallaTienda = Intent(this, Tienda::class.java)
            startActivity(pantallaTienda)
        }else{
            Toast.makeText(this,"Error al introducir la contraseña",Toast.LENGTH_LONG).show()
        }

    }
}
