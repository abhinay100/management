package com.office.management.domain

data class News(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val publishedDate: String,
    val category: String
)
