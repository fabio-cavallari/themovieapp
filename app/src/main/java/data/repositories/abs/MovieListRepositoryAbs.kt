package data.repositories.abs

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import domain.models.Movie

interface MovieListRepositoryAbs {
    suspend fun getPopularMovies(): LiveData<PagingData<Movie>>
}