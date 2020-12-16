package me.podlesnykh.androidacademyapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val numberOfRatings: Int,
    val minimumAge: Int,
    val runtime: Int,
    val genres: List<Genre>,
    val actors: List<Actor>
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (title != other.title) return false
        if (overview != other.overview) return false
        if (poster != other.poster) return false
        if (backdrop != other.backdrop) return false
        if (ratings != other.ratings) return false
        if (numberOfRatings != other.numberOfRatings) return false
        if (minimumAge != other.minimumAge) return false
        if (runtime != other.runtime) return false
        if (genres != other.genres) return false
        if (actors != other.actors) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + poster.hashCode()
        result = 31 * result + backdrop.hashCode()
        result = 31 * result + ratings.hashCode()
        result = 31 * result + numberOfRatings
        result = 31 * result + minimumAge
        result = 31 * result + runtime
        result = 31 * result + genres.hashCode()
        result = 31 * result + actors.hashCode()
        return result
    }
}