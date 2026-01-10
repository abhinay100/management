package com.office.management.domain.usecase

import com.office.management.domain.News
import com.office.management.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Abhinay on 09/01/26.
 */
class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): Flow<Result<List<News>>> {
        return newsRepository.getLatestNews()
    }
}