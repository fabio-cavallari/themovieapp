package data.repositories.abs

import domain.models.Movie

interface MovieListRepositoryAbs {
    fun getPopularMovies(): List<Movie>
}