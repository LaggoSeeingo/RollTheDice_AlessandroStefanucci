package com.example.rollthedice_stefanucci

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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
    }
}