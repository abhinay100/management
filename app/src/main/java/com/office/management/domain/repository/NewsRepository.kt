package com.office.management.domain.repository

import com.office.management.domain.News
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abhinay on 08/01/26.
 */

interface NewsRepository {
    suspend fun getLatestNews(): Flow<Result<List<News>>>
    suspend fun getNewsById(): Flow<Result<News>>
}