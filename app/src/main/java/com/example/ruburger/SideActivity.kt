package com.example.ruburger

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ruburger.model.Side
import com.example.ruburger.model.SideOption
import com.example.ruburger.model.Size
import com.example.ruburger.singleton.OrderManager

class SideActivity : AppCompatActivity() {

    private lateinit var textViewPrice: TextView
    private var selectedOption: SideOption? = null
    private var selectedSize: Size? = null
    private var selectedQty = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side)

        textViewPrice = findViewById(R.id.textViewPrice)

        val optionSpinner = findViewById<Spinner>(R.id.spinner_side_option)
        val sizeSpinner = findViewById<Spinner>(R.id.spinner_side_size)
        val qtySpinner = findViewById<Spinner>(R.id.spinner_qty)

        optionSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            SideOption.values().map { it.name }
        )

        sizeSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Size.values().map { it.name }
        )

        qtySpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            (1..10).toList()
        )

        optionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedOption = SideOption.values()[position]
                updatePrice()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        sizeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedSize = Size.values()[position]
                updatePrice()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        qtySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedQty = position + 1
                updatePrice()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        findViewById<Button>(R.id.btn_add_to_order).setOnClickListener {
            if (selectedOption == null || selectedSize == null) {
                Toast.makeText(this, "Please select a side option and size.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val side = Side(
                selectedOption!!,
                selectedSize!!,
                selectedQty
            )
            OrderManager.getInstance().addItem(side)
            Toast.makeText(this, "Side added to order!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun updatePrice() {
        if (selectedOption == null || selectedSize == null) {
            textViewPrice.text = "Price: $0.00"
            return
        }
        val tempSide = Side(
            selectedOption!!,
            selectedSize!!,
            selectedQty
        )
        val price = tempSide.price()
        textViewPrice.text = String.format("Price: $%.2f", price)
    }
}
