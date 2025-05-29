package com.example.rollthedice_stefanucci

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerificaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verifica)

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        var imgPantera: ImageView = findViewById<ImageView>(R.id.activity_verifica__imRisultato)
        var txtTesto: TextView = findViewById<TextView>(R.id.activity_verifica__tvRisultato)


        val message = intent.getStringExtra("TXT")
        txtTesto.text = message

        val imgRes = intent.getIntExtra("IMG",0)
        imgPantera.setImageResource(imgRes)

    }
}