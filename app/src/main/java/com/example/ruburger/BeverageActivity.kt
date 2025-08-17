package com.example.ruburger

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ruburger.adapter.FlavorAdapter
import com.example.ruburger.model.Beverage
import com.example.ruburger.model.Flavor
import com.example.ruburger.model.OrderManager
import com.example.ruburger.model.Size
//Muhammad Abbasi moa55 Aaman Gafur atg80
class BeverageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beverage)

        val recycler = findViewById<RecyclerView>(R.id.rv_flavors)
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = FlavorAdapter(Flavor.values())
        recycler.adapter = adapter

        findViewById<Button>(R.id.btn_add_to_order).setOnClickListener {
            // Iterate through adapter items to collect quantities
            adapter.selectedQuantities.forEach { (flavor, qty) ->
                if (qty > 0) {
                    val beverage = Beverage(Size.MEDIUM, flavor, qty)
                    OrderManager.getInstance().addItem(beverage)
                }
            }
            Toast.makeText(this, getString(R.string.btn_add_to_order), Toast.LENGTH_SHORT).show()
        }
    }
}
