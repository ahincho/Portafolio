package com.unsa.list

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        Task("Business Task", Category.Business, false),
        Task("Other Task", Category.Other, false),
        Task("Personal Task", Category.Personal, false)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initComponents()
        initUserInterface()
        initListeners()
    }
    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }
    private fun initUserInterface() {
        categoryAdapter = CategoryAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoryAdapter
        taskAdapter = TaskAdapter(tasks) { position -> onItemSelected(position) }
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
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
        btnAddTask.setOnClickListener {
            val task = etTask.text.toString()
            if (task.isNotEmpty()) {
                val selected = rgCategories.checkedRadioButtonId
                val radioButton: RadioButton = rgCategories.findViewById(selected)
                val category: Category = when (radioButton.text) {
                    getString(R.string.business) -> Category.Business
                    getString(R.string.personal) -> Category.Personal
                    else -> Category.Other
                }
                tasks.add(Task(etTask.text.toString(), category, false))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()
    }
    private fun updateTasks() {
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val selectedTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = selectedTasks
        taskAdapter.notifyDataSetChanged()
    }
    private fun onItemSelected(position: Int) {
        tasks[position].selected = !tasks[position].selected
        updateTasks()
    }
    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoryAdapter.notifyDataSetChanged()
        updateTasks()
    }
}