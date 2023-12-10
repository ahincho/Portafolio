package com.unsa.list

sealed class Category(var isSelected: Boolean = true) {
    object Personal : Category()
    object Business : Category()
    object Other : Category()
}