package me.podlesnykh.androidacademyapplication.movies_list

import android.app.Application
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding
import me.podlesnykh.androidacademyapplication.domain.movie.Movie
import me.podlesnykh.androidacademyapplication.movies_list.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MovieListViewModelFactory
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MoviesListViewModel

class FragmentMoviesList : Fragment() {

    private lateinit var viewModel: MoviesListViewModel

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
        viewModel = ViewModelProvider(this, MovieListViewModelFactory(requireActivity().application))
            .get(MoviesListViewModel::class.java)
        viewModel.mutableMoviesList.observe(this.viewLifecycleOwner, this::setState)
        showProgress(true)
        viewModel.getMoviesList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openMovieDetailsScreen(movie: Movie) {
        findNavController().navigate(
            FragmentMoviesListDirections.navigateToMovieItem(movie)
        )
    }

    private fun setupRecyclerView() {
        binding.rvMoviesList.adapter = adapter
        adapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun setState(listMovie: List<Movie>) {
        showProgress(false)
        adapter.submitList(listMovie)
        adapter.notifyDataSetChanged()
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