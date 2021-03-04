package com.kenjoel.searchapp.unsplash_folder

import androidx.paging.PagingSource
import com.kenjoel.searchapp.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException

private const val FIRST_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, Unsplash>(), () -> PagingSource<Any, Any> {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Unsplash> {
        val position = params.key?: FIRST_PAGE_INDEX

        return try {
            val response = unsplashApi.getImages(query, position, params.loadSize)
            val images = response.results

            LoadResult.Page(
                data = images,
                prevKey = if (position == FIRST_PAGE_INDEX) null else position - 1,
                nextKey = if (images.isEmpty()) null else position + 1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)

        }catch (http: HttpException){
            LoadResult.Error(http)
        }
    }

    override fun invoke(): PagingSource<Any, Any> {
        TODO("Not yet implemented")
    }
}