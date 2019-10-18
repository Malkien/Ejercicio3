package com.example.ejercicio3

import kotlin.properties.Delegates

class Personaje {
    private var lateinit nombre:String
    private var precio:Float by Delegates.notNull<Float>()
    lateinit private var rutaImagen:String

    constructor(nombre: String, precio: Float, rutaImagen: String) {
        this.nombre = nombre
        this.precio = precio
        this.rutaImagen = rutaImagen
    }


}