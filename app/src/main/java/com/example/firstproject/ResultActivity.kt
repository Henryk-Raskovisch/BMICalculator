package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5){
            "UNDERWEIGHT"
        }else if(result in 18.5..24.9){
            "NORMAL"
        }else if(result in 25.0..29.9){
            "OVERWEIGHT"
        }else if (result in 30.0..39.9){
            "OBESITY"
        }else{
            "SEVERE OBESITY"
        }

        tvClassification.text = getString(R.string.message_classification, classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}