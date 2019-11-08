package com.example.ejercicio3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejercicio3.Clases.Personaje;

import java.util.ArrayList;

public class AdapterTienda extends BaseAdapter {
    Context context;
    ArrayList<Personaje> imagenes;
    public AdapterTienda(Context contexto, ArrayList<Personaje> imagenes) {
        this.context=contexto;
        this.imagenes=imagenes;
    }
    @Override
    public int getCount() {
        return imagenes.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        view = inflater.inflate(R.layout.activity_contenedor,null); // inflate the layout
        ImageView imagen=view.findViewById(R.id.imagen1);
        TextView texto= view.findViewById(R.id.texto1);
        texto.setText("nombre: "+imagenes.get(i).getNombre()+"\n" +
                "Precio: "+imagenes.get(i).getPrecio());

        imagen.setImageURI(Uri.parse(imagenes.get(i).getRutaImagen()));

        view.findViewById(R.id.boton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantalla = new Intent(context,MostarProducto.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("persona",imagenes.get(i));
                pantalla.putExtras(bundle);
                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(3000,2));
                }else{
                    v.vibrate(2000);
                }
                context.startActivity(pantalla);
            }
        });
        return view;
    }
}
