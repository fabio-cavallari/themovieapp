package presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import domain.models.Movie
import domain.usecases.abs.MovieListUseCaseAbs

class MovieListViewModel(
    private val movieListUseCase: MovieListUseCaseAbs
): ViewModel() {

    suspend fun getPopularMovies(): LiveData<PagingData<Movie>> {
            val movieListResult = movieListUseCase.getPopularMovies()
            return movieListResult
    }
}