package me.podlesnykh.androidacademyapplication.presentation.helpers

import me.podlesnykh.androidacademyapplication.presentation.models.Genre

fun formatGenres(genres: List<Genre>) : String {
    var res = ""
    genres.forEach {
        res += it.name + " "
    }
    return res.trim()
}