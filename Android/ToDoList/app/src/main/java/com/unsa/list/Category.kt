package com.unsa.list

sealed class Category {
    object Personal : Category()
    object Business : Category()
    object Other : Category()
}