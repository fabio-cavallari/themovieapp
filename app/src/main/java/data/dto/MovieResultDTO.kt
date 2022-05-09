package data.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import domain.models.MovieResult

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieResultDTO (
        @JsonProperty(value = "results") val results: List<MovieDTO>,
        @JsonProperty(value = "page") val page: Int,
        @JsonProperty(value = "total_pages") val totalPages: Int
    )

fun MovieResultDTO.asDomainModel() = MovieResult(results.asDomainModel(), page, totalPages)