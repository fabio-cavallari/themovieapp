package data.repositories.impl

import data.dto.RequestResponse
import data.dto.Status
import data.dto.asDomainModel
import data.repositories.abs.MovieListRepositoryAbs
import data.services.IMovieDBService
import domain.models.MovieResult

class MovieListRepositoryImpl(
    private val movieDBService: IMovieDBService
): MovieListRepositoryAbs {
    override fun getPopularMovies(): RequestResponse<MovieResult> {
        val result = movieDBService.getPopularMovieList()
        if (result.status == Status.SUCCESS) {
            return RequestResponse.success(result.data!!.asDomainModel())
        }
        return RequestResponse.error(null, null)
    }
}