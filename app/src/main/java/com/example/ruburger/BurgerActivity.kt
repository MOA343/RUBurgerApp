package com.example.ruburger

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ruburger.model.AddOn
import com.example.ruburger.model.Bread
import com.example.ruburger.model.Burger
import com.example.ruburger.singleton.OrderManager

class BurgerActivity : AppCompatActivity() {

    private lateinit var textViewPrice: TextView
    private var selectedBread: Bread? = null
    private val selectedAddOns = mutableListOf<AddOn>()
    private var selectedQty = 1
    private var isDoublePatty = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger)

        textViewPrice = findViewById(R.id.textViewPrice)

        val breadSpinner = findViewById<Spinner>(R.id.spinner_bread)
        val qtySpinner = findViewById<Spinner>(R.id.spinner_qty)
        val doublePattyCheckBox = findViewById<CheckBox>(R.id.checkbox_double_patty)
        val addOnCheese = findViewById<CheckBox>(R.id.checkbox_cheese)
        val addOnLettuce = findViewById<CheckBox>(R.id.checkbox_lettuce)
        val addOnTomato = findViewById<CheckBox>(R.id.checkbox_tomato)
        val addOnOnions = findViewById<CheckBox>(R.id.checkbox_onions)
        val addOnAvocado = findViewById<CheckBox>(R.id.checkbox_avocado)

        // Setup spinner for bread selection
        breadSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Bread.values().map { it.name }
        )

        // Setup spinner for quantity selection
        qtySpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            (1..10).toList()
        )

        breadSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedBread = Bread.values()[position]
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

        doublePattyCheckBox.setOnCheckedChangeListener { _, isChecked ->
            isDoublePatty = isChecked
            updatePrice()
        }

        val addOnCheckboxes = listOf(
            addOnCheese to AddOn.CHEESE,
            addOnLettuce to AddOn.LETTUCE,
            addOnTomato to AddOn.TOMATOES,
            addOnOnions to AddOn.ONIONS,
            addOnAvocado to AddOn.AVOCADO
        )

        for ((checkbox, addon) in addOnCheckboxes) {
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedAddOns.add(addon)
                } else {
                    selectedAddOns.remove(addon)
                }
                updatePrice()
            }
        }

        findViewById<Button>(R.id.btn_add_to_order).setOnClickListener {
            if (selectedBread == null) {
                Toast.makeText(this, "Please select a bread.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val burger = Burger(
                selectedBread!!,
                ArrayList(selectedAddOns),
                selectedQty,
                isDoublePatty
            )
            OrderManager.getInstance().addItem(burger)
            Toast.makeText(this, "Burger added to order!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun updatePrice() {
        if (selectedBread == null) {
            textViewPrice.text = "Price: $0.00"
            return
        }
        val tempBurger = Burger(
            selectedBread!!,
            ArrayList(selectedAddOns),
            selectedQty,
            isDoublePatty
        )
        val price = tempBurger.price()
        textViewPrice.text = String.format("Price: $%.2f", price)
    }
}
