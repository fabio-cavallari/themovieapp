package data.repositories.impl

import data.dto.RequestResponse
import data.dto.Status
import data.dto.asDomainModel
import data.repositories.abs.MovieListRepositoryAbs
import data.services.IMovieDBService
import domain.models.MovieResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieListRepositoryImpl(
    private val movieDBService: IMovieDBService
): MovieListRepositoryAbs {
    override suspend fun getPopularMovies(): RequestResponse<MovieResult> {
        return withContext(Dispatchers.IO) {
            val result = movieDBService.getPopularMovieList()
            if (result.status == Status.SUCCESS) {
                return@withContext RequestResponse.success(result.data!!.asDomainModel())
            }
            return@withContext RequestResponse.error(null, null)
        }
    }
}