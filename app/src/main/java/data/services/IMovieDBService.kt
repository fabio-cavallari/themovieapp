package data.services

import data.dto.MovieDTO
import data.dto.MovieResultDTO
import data.dto.RequestResponse
import retrofit2.Response

interface IMovieDBService {
    fun getPopularMovieList(): RequestResponse<MovieResultDTO>
}