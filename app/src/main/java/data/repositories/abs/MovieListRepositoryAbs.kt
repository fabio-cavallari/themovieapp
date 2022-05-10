package data.repositories.abs

import data.dto.RequestResponse
import domain.models.MovieResult

interface MovieListRepositoryAbs {
    suspend fun getPopularMovies(): RequestResponse<MovieResult>
}