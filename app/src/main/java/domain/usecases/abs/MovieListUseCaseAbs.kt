package domain.usecases.abs

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import domain.models.Movie

interface MovieListUseCaseAbs {
    suspend fun getPopularMovies(): LiveData<PagingData<Movie>>
}