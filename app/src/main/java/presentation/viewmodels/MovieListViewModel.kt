package presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.dto.RequestResponse
import domain.models.Movie
import domain.models.MovieResult
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListViewModel(
    private val movieListUseCase: MovieListUseCaseAbs
): ViewModel() {
    private val _movieList = MutableLiveData<RequestResponse<MovieResult>>()
    val movieList: LiveData<RequestResponse<MovieResult>>
        get() = _movieList

    fun getPopularMovies() {
        val movieList = movieListUseCase.getPopularMovies()
        _movieList.value = movieList
    }
}