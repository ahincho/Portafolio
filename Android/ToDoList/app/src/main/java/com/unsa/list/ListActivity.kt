package com.unsa.list

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initComponent()
        initUserInterface()
        initListeners()
    }
    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }
    private fun initUserInterface() {
        categoryAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoryAdapter
        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter
    }
    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)
        dialog.show()
    }
}