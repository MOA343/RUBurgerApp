package com.example.ruburger

import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ruburger.model.MenuItem
import com.example.ruburger.singleton.OrderManager

class OrderDetailsActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var textViewTotalPrice: TextView
    private lateinit var btnClear: Button
    private lateinit var btnComplete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        listView = findViewById(R.id.listView_order_items)
        textViewTotalPrice = findViewById(R.id.textView_total_price)
        btnClear = findViewById(R.id.btn_clear)
        btnComplete = findViewById(R.id.btn_complete)

        updateOrderDetails()

        btnClear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Clear Order")
                .setMessage("Are you sure you want to cancel and clear the current order?")
                .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    OrderManager.getInstance().clear()
                    updateOrderDetails()
                    Toast.makeText(this, "Order cleared.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
        }

        btnComplete.setOnClickListener {
            if (OrderManager.getInstance().getItems().isEmpty()) {
                Toast.makeText(this, "No items to complete order.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Order completed! Thank you!", Toast.LENGTH_SHORT).show()
            OrderManager.getInstance().clear()
            finish()
        }
    }

    private fun updateOrderDetails() {
        val items = OrderManager.getInstance().getItems()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items.map { it.toString() }
        )
        listView.adapter = adapter

        val totalPrice = items.sumOf { it.price() }
        textViewTotalPrice.text = String.format("Total: $%.2f", totalPrice)
    }
}
