package data.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import domain.models.Movie

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieDTO (
        @JsonProperty(value = "title") val title: String,
        @JsonProperty(value = "poster_path") val poster: String,
        @JsonProperty(value = "vote_average") val score: String,
    )

fun MovieDTO.asDomainModel(): Movie = Movie(title)

fun List<MovieDTO>.asDomainModel(): List<Movie> = map {it.asDomainModel()}