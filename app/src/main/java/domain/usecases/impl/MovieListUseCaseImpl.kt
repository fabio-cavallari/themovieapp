package domain.usecases.impl

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import data.repositories.abs.MovieListRepositoryAbs
import domain.models.Movie
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListUseCaseImpl(
    private val movieListRepository: MovieListRepositoryAbs
): MovieListUseCaseAbs {
    override suspend fun getPopularMovies(): LiveData<PagingData<Movie>> {
        return movieListRepository.getPopularMovies()
    }
}