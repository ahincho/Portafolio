package com.unsa.list

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vwCategoryDivider: View = view.findViewById(R.id.vwCategoryDivider)
    fun render(category: Category) {
        when (category) {
            Category.Business -> {
                tvCategoryName.text = "Business"
                vwCategoryDivider.setBackgroundColor(
                    ContextCompat.getColor(vwCategoryDivider.context, R.color.business_category)
                )
            }
            Category.Other -> {
                tvCategoryName.text = "Other"
                vwCategoryDivider.setBackgroundColor(
                    ContextCompat.getColor(vwCategoryDivider.context, R.color.other_category)
                )
            }
            Category.Personal -> {
                tvCategoryName.text = "Personal"
                vwCategoryDivider.setBackgroundColor(
                    ContextCompat.getColor(vwCategoryDivider.context, R.color.personal_category)
                )
            }
        }
    }
}