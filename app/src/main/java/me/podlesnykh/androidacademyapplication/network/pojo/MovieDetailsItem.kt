package me.podlesnykh.androidacademyapplication.network.pojo

import com.google.gson.annotations.SerializedName

data class MovieDetailsItem(
	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("credits")
	val credits: Credits? = null,

	@field:SerializedName("genres")
	val genres: List<GenresItem>? = null,

	@field:SerializedName("release_dates")
	val releaseDates: ReleaseDates? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("runtime")
	val runtime: Int? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,
)

data class Credits(
	@field:SerializedName("cast")
	val cast: List<CastItem>? = null,
)

data class ReleaseDatesItem(
	@field:SerializedName("certification")
	val certification: String? = null
)

data class CastItem(
	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,
)

data class ReleaseDatesResultsItem(
	@field:SerializedName("release_dates")
	val releaseDates: List<ReleaseDatesItem>? = null,
)

data class ReleaseDates(
	@field:SerializedName("results")
	val results: List<ReleaseDatesResultsItem>? = null
)

data class GenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
