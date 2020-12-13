package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.*
import me.podlesnykh.androidacademyapplication.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding
import me.podlesnykh.androidacademyapplication.data.loadMovies
import java.lang.Exception

class FragmentMoviesList : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesList: List<Movie>
    private val scope = CoroutineScope(Dispatchers.IO)
    private lateinit var loadMoviesJob: Job

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        val view = binding.root

        loadMoviesJob = scope.async {
            moviesList = loadMovies(requireContext())
            bindRecyclerView(moviesList)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        loadMoviesJob.cancel()
    }

    val onClick = fun(movie: Movie){
        val action = FragmentMoviesListDirections.navigateToMovieItem(movie)
        binding.root.findNavController().navigate(action)
    }

    private fun bindRecyclerView(moviesList: List<Movie>) {
        binding.rvMoviesList.adapter = MovieListAdapter(moviesList, onClick)
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }
}