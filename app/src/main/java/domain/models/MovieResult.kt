package domain.models

data class MovieResult (
        val movies: List<Movie>,
        val page: Int,
        val totalPages: Int
    )
