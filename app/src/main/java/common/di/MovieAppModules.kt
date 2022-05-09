package common.di

import data.repositories.abs.MovieListRepositoryAbs
import data.repositories.impl.MovieListRepositoryImpl
import domain.usecases.abs.MovieListUseCaseAbs
import domain.usecases.impl.MovieListUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewmodels.MovieListViewModel

object MovieAppModules {
    val movieAppModules = module {
        factory<MovieListRepositoryAbs> { MovieListRepositoryImpl() }
        factory<MovieListUseCaseAbs> { MovieListUseCaseImpl(get()) }
        viewModel { MovieListViewModel(movieListUseCase = get()) }
    }
}