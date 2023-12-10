package com.unsa.list

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cbTaskSelected: CheckBox = view.findViewById(R.id.cbTaskSelected)
    private val tvTaskName: TextView = view.findViewById(R.id.tvTaskName)
    fun render(task: Task) {
        cbTaskSelected.isChecked = task.selected
        tvTaskName.text = task.name
        if (task.selected) {
            tvTaskName.paintFlags = tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTaskName.paintFlags = tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        val color = when (task.category) {
            Category.Business -> R.color.business_category
            Category.Personal -> R.color.personal_category
            Category.Other -> R.color.other_category
        }
        cbTaskSelected.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTaskSelected.context, color)
        )
    }
}