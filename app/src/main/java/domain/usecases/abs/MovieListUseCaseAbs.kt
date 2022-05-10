package domain.usecases.abs

import data.dto.RequestResponse
import domain.models.MovieResult

interface MovieListUseCaseAbs {
    suspend fun getPopularMovies(): RequestResponse<MovieResult>
}