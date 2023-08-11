package com.bastian.androidcaso2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val spinnerMarcas = findViewById<Spinner>(R.id.spinnerMarcas)
        val optionsMarcas = arrayOf("Seleccione", "HTC", "Huawei", "Samsung")
        spinnerMarcas.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsMarcas)
        val spinnerNumeros = findViewById<Spinner>(R.id.spinnerCantidad)
        val optionsNumeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        spinnerNumeros.adapter =
            ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, optionsNumeros)
        val etPrecio = findViewById<EditText>(R.id.etPrecio)
        val btnProcesar = findViewById<AppCompatButton>(R.id.btnProcesar)

        btnProcesar.setOnClickListener {
            val inputMarca = spinnerMarcas.selectedItem.toString()
            val inputPrecio = etPrecio.text.toString()
            val inputCantidad = spinnerNumeros.selectedItem as Int

            val isMarcaValid = inputMarca != "Seleccione"
            val isPrecioValid = !inputPrecio.isBlank()

            if (isMarcaValid && isPrecioValid) {
                val total = inputPrecio.toDouble() * inputCantidad
                val mensaje = "La marca es: $inputMarca La cantidad es: $inputCantidad El total es: $total"
                Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Rellene todos los campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}