package data.repositories.abs

import data.dto.RequestResponse
import domain.models.MovieResult

interface MovieListRepositoryAbs {
    fun getPopularMovies(): RequestResponse<MovieResult>
}