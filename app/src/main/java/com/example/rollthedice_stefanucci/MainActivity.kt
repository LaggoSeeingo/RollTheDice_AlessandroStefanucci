package com.example.rollthedice_stefanucci

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var txtNumber: TextView //= findViewById<TextView>(R.id.activity_roll__tvNumber)
    private lateinit var imgDice: ImageView //= findViewById<ImageView>(R.id.activity_roll__imgDado)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } */

        var btnRoll : Button = findViewById(R.id.activity_main__btnRoll)

        btnRoll.setOnClickListener(View.OnClickListener {
            var toast = Toast.makeText(this, R.string.btn_roll_toast, Toast.LENGTH_LONG)
            toast.show()
            rollDice()
        })


    }

    private fun rollDice(){

        Log.d(TAG, "Dice rolling")
        val randomNumber = (1..6).random()
        Log.d(TAG, "Numero estratto: "+ randomNumber.toString())

       // txtNumber.text = randomNumber.toString()

        val imgDiceRes = when(randomNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //imgDice.setImageResource(imgDiceRes)

        val intent = Intent(this, RollActivity::class.java).apply{
            putExtra("NUMERO", randomNumber.toString())
            putExtra("IMGRES", imgDiceRes)
        }
        startActivity(intent)

    }

}