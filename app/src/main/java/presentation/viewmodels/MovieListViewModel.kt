package presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.models.Movie
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListViewModel(
    private val movieListUseCase: MovieListUseCaseAbs
): ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun getPopularMovies() {
        val movieList = movieListUseCase.getPopularMovies()
        _movieList.value = movieList
    }
}