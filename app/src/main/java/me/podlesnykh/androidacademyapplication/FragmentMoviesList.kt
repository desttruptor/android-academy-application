package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.*
import me.podlesnykh.androidacademyapplication.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.data.loadMovies
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesList: List<Movie>
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Default)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        val view = binding.root

        scope.launch {
            binding.progress?.visibility = View.VISIBLE
            moviesList = loadMovies(requireContext())
            withContext(Dispatchers.Main) {
                bindRecyclerView(moviesList)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun openMovieDetailsScreen(movie: Movie) {
        findNavController().navigate(
            FragmentMoviesListDirections.navigateToMovieItem(movie)
        )
    }

    private fun bindRecyclerView(moviesList: List<Movie>) {
        binding.rvMoviesList.adapter = MovieListAdapter(moviesList, ::openMovieDetailsScreen)
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.progress?.visibility = View.GONE
    }
}