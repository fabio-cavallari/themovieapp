package domain.usecases.impl

import data.dto.RequestResponse
import data.repositories.abs.MovieListRepositoryAbs
import domain.models.MovieResult
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListUseCaseImpl(
    private val movieListRepository: MovieListRepositoryAbs
): MovieListUseCaseAbs {
    override fun getPopularMovies(): RequestResponse<MovieResult> {
        return movieListRepository.getPopularMovies()
    }
}