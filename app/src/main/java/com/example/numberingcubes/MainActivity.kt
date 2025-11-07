package com.example.numberingcubes

import android.widget.Button
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.res.Configuration

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RectangleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = RectangleAdapter()

        if (savedInstanceState != null) {
            val savedCount = savedInstanceState.getInt("squares_count", 0)
            if (savedCount > 0) {
                adapter.setCount(savedCount)
            }
        }

        SetupRecyclerView()

        val button = findViewById<Button>(R.id.addButton)
        button.text = "+"
        button.setOnClickListener {
            adapter.AddItem()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("squares_count", adapter.getCurrentCount())
    }

    fun SetupRecyclerView() {
        val Landscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        val spanCount = if (Landscape) 4 else 3
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        SetupRecyclerView()
    }
}