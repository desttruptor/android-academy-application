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

    private var moviesList: List<Movie> = listOf()
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Default)

    private val adapter = MovieListAdapter(moviesList, ::openMovieDetailsScreen)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()

        scope.launch {
            showProgress(true)
            moviesList = loadMovies(requireContext())
            withContext(Dispatchers.Main) {
                adapter.submitList(moviesList)
                showProgress(false)
            }
        }
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

    private fun setupRecyclerView() {
        binding.rvMoviesList.adapter = adapter
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun showProgress(isShow: Boolean) {
        if (isShow) {
            binding.progress?.visibility = View.VISIBLE
            binding.rvMoviesList.visibility = View.GONE
        } else {
            binding.progress?.visibility = View.GONE
            binding.rvMoviesList.visibility = View.VISIBLE
        }
    }
}