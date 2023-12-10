package com.unsa.list

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cbTaskSelected: CheckBox = view.findViewById(R.id.cbTaskSelected)
    private val tvTaskName: TextView = view.findViewById(R.id.tvTaskName)
    fun render(task: Task) {
        tvTaskName.text = task.name
    }
}