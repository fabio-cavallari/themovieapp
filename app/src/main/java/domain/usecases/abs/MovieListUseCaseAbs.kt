package domain.usecases.abs

import domain.models.Movie

interface MovieListUseCaseAbs {
    fun getPopularMovies(): List<Movie>
}