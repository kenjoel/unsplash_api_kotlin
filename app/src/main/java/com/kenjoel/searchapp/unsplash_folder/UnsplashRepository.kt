package com.kenjoel.searchapp.unsplash_folder

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.kenjoel.searchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unspashApi: UnsplashApi) {
    fun getSearchResult(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = ( UnsplashPagingSource(unspashApi, query) )
    ).liveData
}