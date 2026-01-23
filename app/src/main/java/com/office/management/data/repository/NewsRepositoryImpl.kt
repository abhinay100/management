package com.office.management.data.repository

import com.office.management.data.local.dao.NewsDao
import com.office.management.data.local.entity.NewsEntity
import com.office.management.data.local.entity.toDomain
import com.office.management.domain.News
import com.office.management.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.office.management.domain.common.Result
import kotlinx.coroutines.flow.first

/**
 * Created by Abhinay on 23/01/26.
 */

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
): NewsRepository {

    override suspend fun getLatestNews(): Flow<Result<List<News>>> = flow {
        try {
            emit(Result.Loading)
            // Check if we have cached data
            val cachedNews = newsDao.getAllNews().first()
            if(cachedNews.isEmpty()) {
                // Simulate fetching from API and cache
                val mockNews = getMockNews()
                newsDao.insertNews(mockNews)
                emit(Result.Success(mockNews.map {it.toDomain()}))
            } else {
                emit(Result.Success(cachedNews.map { it.toDomain() }))
            }

        }catch (e : Exception) {
            emit(Result.Error("Failed to get news: ${e.message}", e))
        }

    }

    override suspend fun getNewsById(id: String): Flow<Result<News>> = flow {
        try {
            emit(Result.Loading)
            val news = newsDao.getNewsById(id).first()
            if (news != null) {
                emit(Result.Success(news.toDomain()))
            } else {
                emit(Result.Error("News not found"))
            }
        } catch (e: Exception) {
            emit(Result.Error("Failed to get news: ${e.message}", e))
        }
    }

    private fun getMockNews(): List<NewsEntity> {
        return listOf(
            NewsEntity(
                id = "1",
                title = "Vaccine Together Orphans",
                description = "Join our vaccination program for orphans",
                imageUrl = null,
                publishedDate = "2025-01-05",
                category = "Health"
            ),
            NewsEntity(
                id = "2",
                title = "New Office Policy",
                description = "Updated office policies for 2025",
                imageUrl = null,
                publishedDate = "2025-01-04",
                category = "Policy"
            )
        )
    }

}