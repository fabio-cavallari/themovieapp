package data.services

import common.Constants.API_BASE_URL
import common.ServiceFactory.getBaseRetrofitClient
import data.clients.MovieDBClient
import data.dto.MovieResultDTO
import data.dto.RequestResponse

class MovieDBService: IMovieDBService {

    private val movieDBClient = getBaseRetrofitClient(API_BASE_URL)
        .build()
        .create(MovieDBClient::class.java)

    override suspend fun getPopularMovieList(page: Int): RequestResponse<MovieResultDTO> {
        try {
            val movieResult = movieDBClient.getPopularMovies(API_KEY, page)
            return RequestResponse.success(movieResult.body())
        } catch (t: Throwable) {
            return RequestResponse.error(null, null)
        }
    }

    companion object {
        const val API_KEY = "1b177e0639397148cb6fcf0b9302a68d"
    }
}