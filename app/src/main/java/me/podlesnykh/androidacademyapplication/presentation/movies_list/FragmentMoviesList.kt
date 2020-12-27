package me.podlesnykh.androidacademyapplication.movies_list

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding
import me.podlesnykh.androidacademyapplication.domain.movie.Movie
import me.podlesnykh.androidacademyapplication.movies_list.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MovieListViewModelFactory
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MoviesListViewModel

class FragmentMoviesList : Fragment() {

    private val viewModel = MovieListViewModelFactory(requireContext() as Application).create(MoviesListViewModel::class.java)

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private var moviesList: List<Movie> = listOf()

    private val adapter = MovieListAdapter(moviesList, ::openMovieDetailsScreen)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewModel.state.observe(this.viewLifecycleOwner, this::setState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
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

    private fun setState(state: MoviesListViewModel.State) =
        when (state) {
            is MoviesListViewModel.State.Default -> {
                showProgress(false)
                showErrorMessage(false)
            }
            is MoviesListViewModel.State.Loading -> {
                showProgress(true)
                showErrorMessage(false)
            }
            is MoviesListViewModel.State.LoadingError -> {
                showProgress(false)
                showErrorMessage(true)
            }
            is MoviesListViewModel.State.Success -> {
                showProgress(false)
                showErrorMessage(false)
                adapter.submitList(viewModel.mutableMoviesList.value!!)
            }
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

    private fun showErrorMessage(isShow: Boolean) {
        if (isShow) {
            binding.tvLabelMoviesList.text = getString(R.string.loading_error)
        } else {
            binding.tvLabelMoviesList.text = getString(R.string.label_movies_list)
        }
    }
}