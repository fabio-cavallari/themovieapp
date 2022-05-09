package data.clients

import data.dto.MovieResultDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBClient {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Response<MovieResultDTO>
}