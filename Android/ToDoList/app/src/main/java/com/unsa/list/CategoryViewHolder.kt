package com.unsa.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vwCategoryDivider: View = view.findViewById(R.id.vwCategoryDivider)
    fun render(category: Category) {
        tvCategoryName.text = "Category"
    }
}