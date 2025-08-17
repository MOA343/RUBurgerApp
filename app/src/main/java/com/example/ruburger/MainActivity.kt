package com.example.ruburger

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_burger).setOnClickListener {
            startActivity(Intent(this, BurgerActivity::class.java))
        }
        findViewById<Button>(R.id.btn_sandwich).setOnClickListener {
            startActivity(Intent(this, SandwichActivity::class.java))
        }
        findViewById<Button>(R.id.btn_beverage).setOnClickListener {
            startActivity(Intent(this, BeverageActivity::class.java))
        }
        findViewById<Button>(R.id.btn_side).setOnClickListener {
            startActivity(Intent(this, SideActivity::class.java))
        }
        findViewById<Button>(R.id.btn_view_order).setOnClickListener {
            startActivity(Intent(this, OrderDetailsActivity::class.java))
        }
    }
}
