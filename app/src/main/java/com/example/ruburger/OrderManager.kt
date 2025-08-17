package com.example.ruburger.singleton

import com.example.ruburger.model.MenuItem

class OrderManager private constructor() {

    private val currentOrderItems = mutableListOf<MenuItem>()

    companion object {
        private var instance: OrderManager? = null

        fun getInstance(): OrderManager {
            if (instance == null) {
                instance = OrderManager()
            }
            return instance!!
        }
    }

    fun addItem(item: MenuItem) {
        currentOrderItems.add(item)
    }

    fun getItems(): List<MenuItem> {
        return currentOrderItems
    }

    fun clear() {
        currentOrderItems.clear()
    }
}
