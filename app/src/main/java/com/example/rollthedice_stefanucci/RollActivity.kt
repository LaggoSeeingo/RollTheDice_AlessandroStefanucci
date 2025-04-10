package com.example.rollthedice_stefanucci

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_roll)

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        var imgDice: ImageView = findViewById<ImageView>(R.id.activity_roll__imgDado)
        var txtNumber: TextView = findViewById<TextView>(R.id.activity_roll__tvNumber)


        val message = intent.getStringExtra("NUMERO")
        txtNumber.text = message

        val imgRes = intent.getIntExtra("IMGRES",0)
        imgDice.setImageResource(imgRes)

        var btnVerifica : Button = findViewById(R.id.activity_roll__btnVerifica)

        btnVerifica.setOnClickListener(View.OnClickListener {
            var toast = Toast.makeText(this, R.string.btn_roll_toast, Toast.LENGTH_LONG)
            toast.show()
            verify()
        })

    }

    private fun verify(){

        val message = intent.getStringExtra("Numero")

        val risultato = when(message){
            "1" -> "Numero dispari, hai perso..."
            "2" -> "Numero pari! Hai vinto!"
            "3" -> "Numero dispari, hai perso..."
            "4" -> "Numero pari! Hai vinto!"
            "5" -> "Numero dispari, hai perso..."
            else -> "Numero pari! Hai vinto!"
        }


        val intentVerifica = Intent(this, VerificaActivity::class.java).apply{
            putExtra("IMG", 0 /*da modificare */)
            putExtra("TXT", risultato)
        }
        startActivity(intentVerifica)
    }
}