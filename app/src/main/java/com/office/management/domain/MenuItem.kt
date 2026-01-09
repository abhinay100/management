package com.office.management.domain

import androidx.compose.ui.graphics.Color

data class MenuItem(
    val id: String,
    val title: String,
    val icon: String,
    val route: String,
    val backgroundColor: Color
)
