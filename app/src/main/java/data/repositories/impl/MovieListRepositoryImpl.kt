package data.repositories.impl

import data.repositories.abs.MovieListRepositoryAbs
import domain.models.Movie

class MovieListRepositoryImpl: MovieListRepositoryAbs {
    override fun getPopularMovies(): List<Movie> {
        return listOf(Movie("filme 1"))
    }
}