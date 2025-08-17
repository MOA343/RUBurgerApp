package com.example.ruburger

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ruburger.model.*
import com.example.ruburger.singleton.OrderManager

class SandwichActivity : AppCompatActivity() {

    private lateinit var textViewPrice: TextView
    private var selectedBread: Bread? = null
    private var selectedProtein: Protein? = null
    private val selectedAddOns = mutableListOf<AddOn>()
    private var selectedQty = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandwich)

        textViewPrice = findViewById(R.id.textViewPrice)

        val breadSpinner = findViewById<Spinner>(R.id.spinner_bread)
        val proteinSpinner = findViewById<Spinner>(R.id.spinner_protein)
        val qtySpinner = findViewById<Spinner>(R.id.spinner_qty)

        val addOnCheese = findViewById<CheckBox>(R.id.checkbox_cheese)
        val addOnLettuce = findViewById<CheckBox>(R.id.checkbox_lettuce)
        val addOnTomato = findViewById<CheckBox>(R.id.checkbox_tomato)
        val addOnOnions = findViewById<CheckBox>(R.id.checkbox_onions)
        val addOnAvocado = findViewById<CheckBox>(R.id.checkbox_avocado)

        // Setup spinners
        breadSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Bread.values().map { it.name }
        )

        proteinSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Protein.values().map { it.name }
        )

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

        proteinSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedProtein = Protein.values()[position]
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
            if (selectedBread == null || selectedProtein == null) {
                Toast.makeText(this, "Please select bread and protein.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val sandwich = Sandwich(
                selectedBread!!,
                selectedProtein!!,
                ArrayList(selectedAddOns),
                selectedQty
            )
            OrderManager.getInstance().addItem(sandwich)
            Toast.makeText(this, "Sandwich added to order!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun updatePrice() {
        if (selectedBread == null || selectedProtein == null) {
            textViewPrice.text = "Price: $0.00"
            return
        }
        val tempSandwich = Sandwich(
            selectedBread!!,
            selectedProtein!!,
            ArrayList(selectedAddOns),
            selectedQty
        )
        val price = tempSandwich.price()
        textViewPrice.text = String.format("Price: $%.2f", price)
    }
}
