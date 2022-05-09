package common.di

import data.repositories.abs.MovieListRepositoryAbs
import data.repositories.impl.MovieListRepositoryImpl
import data.services.IMovieDBService
import data.services.MovieDBService
import domain.usecases.abs.MovieListUseCaseAbs
import domain.usecases.impl.MovieListUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewmodels.MovieListViewModel

object MovieAppModules {
    val movieAppModules = module {
        factory<IMovieDBService> { MovieDBService() }
        factory<MovieListRepositoryAbs> { MovieListRepositoryImpl(get()) }
        factory<MovieListUseCaseAbs> { MovieListUseCaseImpl(get()) }
        viewModel { MovieListViewModel(movieListUseCase = get()) }

    }
}