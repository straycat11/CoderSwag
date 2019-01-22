package com.roasloa.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.roasloa.coderswag.Model.Category
import com.roasloa.coderswag.R
import com.roasloa.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataService.categories)
        categoryListView.adapter = adapter
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
