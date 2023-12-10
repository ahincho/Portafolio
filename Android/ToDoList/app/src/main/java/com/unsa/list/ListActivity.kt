package com.unsa.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    private val categories = listOf(
        Category.Business,
        Category.Personal,
        Category.Other
    )
    private val tasks = mutableListOf(
        Task("Business", Category.Business, false),
        Task("Other", Category.Other, false),
        Task("Personal", Category.Personal, false)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initComponent()
        initUserInterface()
    }
    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
    }
    private fun initUserInterface() {
        categoryAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoryAdapter
        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter
    }
}