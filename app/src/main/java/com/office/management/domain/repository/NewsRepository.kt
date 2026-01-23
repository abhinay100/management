package com.office.management.domain.repository

import com.office.management.domain.News
import kotlinx.coroutines.flow.Flow
import com.office.management.domain.common.Result

/**
 * Created by Abhinay on 08/01/26.
 */

interface NewsRepository {
    suspend fun getLatestNews(): Flow<Result<List<News>>>
    suspend fun getNewsById(id: String): Flow<Result<News>>
}