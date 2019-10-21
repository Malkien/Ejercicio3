package com.example.ejercicio3

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ejercicio3.Clases.Personaje
import kotlinx.android.synthetic.main.activity_mostar_producto.*
import java.io.IOException

class MostarProducto : AppCompatActivity() {
    companion object {
        private const val PERMISO_LLAMADAS=1000;
        private  const val PERMISO_GRABAR=1001;
    }
    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostar_producto)
        val bund = intent.extras
        var personaje: Personaje =(bund?.getSerializable("persona") as Personaje)
        imagen.setImageURI(Uri.parse(personaje.rutaImagen))
        descripcion.setText("Nombre: "+personaje.nombre+"\n" +
                "Precio: "+personaje.precio)


    }

    fun clickEscuchar(view: View) {
        if (ActivityCompat.checkSelfPermission(
                this,
                RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    this,
                    WRITE_EXTERNAL_STORAGE
                )==PackageManager.PERMISSION_GRANTED)
        {
            try{
                println("He llegado")
                output = getExternalFilesDir(Environment.DIRECTORY_MUSIC)?.absolutePath+ "/recording.mp3"
                mediaRecorder = MediaRecorder()
                println("Aqui llega: "+output)
                mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
                mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                mediaRecorder?.setOutputFile(output)
                mediaRecorder?.prepare()
                mediaRecorder?.start()
                state = true
                Toast.makeText(this, "Grabando", Toast.LENGTH_SHORT).show()
                botonEscuchar.visibility = View.GONE
                botonParar.visibility = View.VISIBLE
            }catch (e: IllegalStateException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, CALL_PHONE)||
                ActivityCompat.shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE)) {
                val permisos = arrayOf(RECORD_AUDIO, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this, permisos, 0)

            } else {
                Toast.makeText(this, "No tienes permisos", Toast.LENGTH_LONG).show()
            }
        }
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

    fun clickPararAudio(view: View) {
        if(state){
            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false

        }else{
            Toast.makeText(this, "Como coño has llegado aqui, si no tendria que salir el boton ¬.¬", Toast.LENGTH_SHORT).show()
        }
        println("Adios botones")
        botonParar.visibility = View.GONE
        botonEscuchar.visibility = View.VISIBLE
        botonReproducir.visibility = View.VISIBLE
    }

    fun clickReproducir(view: View) {
        val mediaPlayer = MediaPlayer()

        mediaPlayer?.setDataSource(output)
        mediaPlayer?.prepare()
        mediaPlayer?.start()
    }


}
