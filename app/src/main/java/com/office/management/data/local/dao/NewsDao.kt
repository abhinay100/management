package com.office.management.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.office.management.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abhinay on 11/01/26.
 */
@Dao
interface NewsDao {

    @Query("SELECT * FROM news ORDER BY publishedDate DESC")
    fun getAllNews(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM news WHERE id = :id")
    fun getNewsById(id: String): Flow<NewsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)

    @Delete
    suspend fun deleteNews(news: NewsEntity)

    @Query("DELETE FROM news")
    suspend fun deleteAll()

}