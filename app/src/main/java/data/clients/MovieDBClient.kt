package data.clients

import data.dto.MovieResultDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBClient {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Response<MovieResultDTO>
}