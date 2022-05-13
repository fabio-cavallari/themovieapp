package data.services

import data.dto.MovieResultDTO
import data.dto.RequestResponse

interface IMovieDBService {
    suspend fun getPopularMovieList(page: Int): RequestResponse<MovieResultDTO>
}