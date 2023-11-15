package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.Format

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate : Button = findViewById(R.id.btnCalculate)
        val editWeight : EditText = findViewById(R.id.edittext_weight)
        val editHeight : EditText = findViewById(R.id.edittext_height)

        btnCalculate.setOnClickListener {
            val heightStr = editHeight.text.toString()
            val weightStr = editWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()

                val finalHeight: Float = height * height
                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_LONG).show()
            }
        }

    }
}