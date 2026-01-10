package com.office.management.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.office.management.domain.News

/**
 * Created by Abhinay on 10/01/26.
 */
@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String?,
    val publishedDate: String,
    val category: String
)

fun NewsEntity.toDomain() : News {
    return News (
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        publishedDate = publishedDate,
        category = category
    )
}

fun News.toEntity(): NewsEntity {
    return NewsEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        publishedDate = publishedDate,
        category = category
    )
}