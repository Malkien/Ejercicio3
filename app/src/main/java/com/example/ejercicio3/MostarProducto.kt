package com.example.ejercicio3

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_mostar_producto.*

class MostarProducto : AppCompatActivity() {
    companion object {
        private const val PERMISO_LLAMADAS=1000;
        private  const val PERMISO_GRABAR=1001;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostar_producto)
        val bund = intent.extras
        var personaje:Personaje=(bund?.getSerializable("persona") as Personaje)
        imagen.setImageURI(Uri.parse(personaje.rutaImagen))
        descripcion.setText(personaje.nombre)
    }

    fun clickEscuchar(view: View) {

    }

    fun clickLlamar(view: View) {
        if (ActivityCompat.checkSelfPermission(
                this,
                CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED)
         {
            val intentLlamada = Intent(Intent.ACTION_CALL, Uri.parse("tel: " + "223141423"))
            startActivity(intentLlamada)
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, CALL_PHONE)) {
                val permisos = arrayOf(CALL_PHONE)
                ActivityCompat.requestPermissions(this, permisos, PERMISO_LLAMADAS)

            } else {
                Toast.makeText(this, "No tienes permisos", Toast.LENGTH_LONG).show()
            }
        }
    }


}
