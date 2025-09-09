package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R

class MainActivity : AppCompatActivity() {

    private lateinit var etItemName: EditText
    private lateinit var etItemPrice: EditText
    private lateinit var etItemUrl: EditText
    private lateinit var btnAddItem: Button
    private lateinit var rvWishlist: RecyclerView
    private lateinit var wishlistAdapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        setupRecyclerView()
        setupClickListener()
    }

    private fun initializeViews() {
        etItemName = findViewById(R.id.et_item_name)
        etItemPrice = findViewById(R.id.et_item_price)
        etItemUrl = findViewById(R.id.et_item_url)
        btnAddItem = findViewById(R.id.btn_add_item)
        rvWishlist = findViewById(R.id.rv_wishlist)
    }

    private fun setupRecyclerView() {
        wishlistAdapter = WishlistAdapter(wishlistItems)
        rvWishlist.apply {
            adapter = wishlistAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupClickListener() {
        btnAddItem.setOnClickListener {
            addItemToWishlist()
        }
    }

    private fun addItemToWishlist() {
        val name = etItemName.text.toString().trim()
        val price = etItemPrice.text.toString().trim()
        val url = etItemUrl.text.toString().trim()

        if (name.isEmpty() || price.isEmpty() || url.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val newItem = WishlistItem(name, price, url)
        wishlistAdapter.addItem(newItem)

        // Clear input fields
        etItemName.text.clear()
        etItemPrice.text.clear()
        etItemUrl.text.clear()

        Toast.makeText(this, "Item added to wishlist!", Toast.LENGTH_SHORT).show()
    }
}