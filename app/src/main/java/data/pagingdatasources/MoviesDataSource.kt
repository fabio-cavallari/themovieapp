package data.pagingdatasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import data.dto.asDomainModel
import data.services.IMovieDBService
import domain.models.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviesDataSource (
    private val service: IMovieDBService
): PagingSource<Int, Movie>() {
    private val STARTING_PAGE_INDEX = 1

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: STARTING_PAGE_INDEX
//        val apiQuery = query + IN_QUALIFIER
        return try {
            val response = service.getPopularMovieList(page)
            val movies = response.data?.results?.asDomainModel()?: listOf()
            val nextKey = if (movies.isNullOrEmpty() || page == response.data?.totalPages) {
                null
            } else {
                page + 1
            }
            LoadResult.Page(
                data = movies,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}

/*
* class PostsDataSource(private val scope: CoroutineScope) :
    PageKeyedDataSource<String, RedditPost>() {
    private val apiService = ApiClient.getClient().create(ApiService::class.java)

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, RedditPost>) {
        scope.launch {
            try {
                val response = apiService.fetchPosts(loadSize = params.requestedLoadSize)
                when{
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val redditPosts = listing?.children?.map { it.data }
                        callback.onResult(redditPosts ?: listOf(), listing?.before, listing?.after)
                    }
                }

            }catch (exception : Exception){
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }

    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, RedditPost>) {
        scope.launch {
            try {
                val response =
                    apiService.fetchPosts(loadSize = params.requestedLoadSize, after = params.key)
                when{
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val items = listing?.children?.map { it.data }
                        callback.onResult(items ?: listOf(), listing?.after)
                    }
                }

            }catch (exception : Exception){
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, RedditPost>) {
        scope.launch {
            try {
                val response =
                    apiService.fetchPosts(loadSize = params.requestedLoadSize, before = params.key)
                when{
                    response.isSuccessful -> {
                        val listing = response.body()?.data
                        val items = listing?.children?.map { it.data }
                        callback.onResult(items ?: listOf(), listing?.after)
                    }
                }

            }catch (exception : Exception){
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }

}
* */