package data.repositories.impl

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import data.pagingdatasources.MoviesDataSource
import data.repositories.abs.MovieListRepositoryAbs
import data.services.IMovieDBService
import domain.models.Movie

class MovieListRepositoryImpl(
    private val movieDBService: IMovieDBService
): MovieListRepositoryAbs {
    override suspend fun getPopularMovies(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
                prefetchDistance = 10
            ),
            pagingSourceFactory = {
                MoviesDataSource(movieDBService)
            }
        ).liveData
    }
}