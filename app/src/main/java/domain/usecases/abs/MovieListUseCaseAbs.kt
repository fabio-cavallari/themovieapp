package domain.usecases.abs

import data.dto.RequestResponse
import domain.models.MovieResult

interface MovieListUseCaseAbs {
    fun getPopularMovies(): RequestResponse<MovieResult>
}