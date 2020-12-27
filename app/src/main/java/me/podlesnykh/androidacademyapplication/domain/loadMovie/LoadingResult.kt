package me.podlesnykh.androidacademyapplication.domain.loadMovie

sealed class LoadingResult {
    class Success : LoadingResult()
    class Error : LoadingResult()
}