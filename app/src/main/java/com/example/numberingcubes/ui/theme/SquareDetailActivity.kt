package com.example.numberingcubes

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SquareDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_detail)

        val number = intent.getIntExtra("NUMBER", 1)
        val backgroundColor = intent.getIntExtra("BACKGROUND_COLOR", Color.BLUE)

        val numberText: TextView = findViewById(R.id.detailNumberText)
        val container: android.widget.LinearLayout = findViewById(R.id.detailContainer)

        numberText.text = number.toString()
        container.setBackgroundColor(backgroundColor)
        numberText.setTextColor(Color.WHITE)

        container.setOnClickListener {
            finish()
        }
    }
}