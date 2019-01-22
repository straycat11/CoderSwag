package com.roasloa.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.roasloa.coderswag.Adapters.CategoryAdapter
import com.roasloa.coderswag.R
import com.roasloa.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryAdapter(this,
            DataService.categories)
        categoryListView.adapter = adapter

    }
}
