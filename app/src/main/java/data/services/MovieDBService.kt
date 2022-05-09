package data.services

import common.Constants.API_BASE_URL
import common.ServiceFactory.getBaseRetrofitClient
import data.clients.MovieDBClient
import data.dto.MovieDTO
import data.dto.MovieResultDTO
import data.dto.RequestResponse

class MovieDBService: IMovieDBService {

    private val movieDBClient = getBaseRetrofitClient(API_BASE_URL)
        .build()
        .create(MovieDBClient::class.java)

    override fun getPopularMovieList(): RequestResponse<MovieResultDTO> {
        try {
            val movieResult = movieDBClient.getPopularMovies(API_BASE_URL)
            return RequestResponse.success(
                MovieResultDTO(
                    listOf(MovieDTO(
                    "title",
                    "poster",
                    "10")),
                    1,
                    10))

        } catch (t: Throwable) {
            return RequestResponse.error(null, null)
        }
    }
}