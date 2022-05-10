package presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.dto.RequestResponse
import domain.models.MovieResult
import domain.usecases.abs.MovieListUseCaseAbs
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val movieListUseCase: MovieListUseCaseAbs
): ViewModel() {
    private val _movieList = MutableLiveData<RequestResponse<MovieResult>>()
    val movieList: LiveData<RequestResponse<MovieResult>>
        get() = _movieList

    fun getPopularMovies() {
        viewModelScope.launch {
            val movieList = movieListUseCase.getPopularMovies()
            _movieList.postValue(movieList)
        }
    }
}