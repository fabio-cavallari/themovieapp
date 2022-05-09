package domain.usecases.impl

import data.repositories.abs.MovieListRepositoryAbs
import domain.models.Movie
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListUseCaseImpl(
    private val movieListRepository: MovieListRepositoryAbs
): MovieListUseCaseAbs {
    override fun getPopularMovies(): List<Movie> {
        return movieListRepository.getPopularMovies()
    }
}