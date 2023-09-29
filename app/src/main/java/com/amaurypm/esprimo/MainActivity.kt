package com.amaurypm.esprimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amaurypm.esprimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVerificar.setOnClickListener {

            var numero = 0
            if (binding.etNumero.text.isNotEmpty()) {
                numero = binding.etNumero.text.toString().toInt()

                if(esPrimo(numero)){
                    //Sí es primo
                    binding.tvResultado.text = "El número $numero sí es primo"
                }else{
                    //no es primo
                    binding.tvResultado.text = "El número $numero no es primo"
                }
                //numero = binding.etNumero.text.toString().toInt()
                //Toast.makeText(this, "El número ingresado es $numero", Toast.LENGTH_LONG).show()

            } else {
                binding.etNumero.error = "Se requiere un número"
                Toast.makeText(this, "Por favor ingresa un número", Toast.LENGTH_LONG).show()
            }

        }

    }

    fun esPrimo(numero: Int): Boolean{

        if(numero <= 1) return false

        for(i in 2 until numero){
            if(numero%i == 0) return false
        }

        return true
    }


}