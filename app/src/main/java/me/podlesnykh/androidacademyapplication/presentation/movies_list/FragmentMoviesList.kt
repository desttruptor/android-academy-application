package me.podlesnykh.androidacademyapplication.presentation.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding
import me.podlesnykh.androidacademyapplication.movies_list.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.presentation.models.MovieListItem

class FragmentMoviesList : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MoviesListViewModel
    private var moviesList: List<MovieListItem> = emptyList()
    private val adapter = MovieListAdapter(moviesList, ::openMovieDetailsScreen)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        showProgress(true)
        viewModel = ViewModelProvider(this, MovieListViewModelFactory()).get(MoviesListViewModel::class.java)
        viewModel.getMoviesPage()
        viewModel.mutableMoviesListPage.observe(viewLifecycleOwner) {
            showProgress(false)
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openMovieDetailsScreen(movieId: Int) {
        findNavController().navigate(
            FragmentMoviesListDirections.navigateToMovieItem(movieId)
        )
    }

    private fun setupRecyclerView() {
        binding.rvMoviesList.adapter = adapter
        adapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun showProgress(isShown: Boolean) =
        if (isShown) {
            binding.progress?.visibility = View.VISIBLE
            binding.rvMoviesList.visibility = View.GONE
        } else {
            binding.progress?.visibility = View.GONE
            binding.rvMoviesList.visibility = View.VISIBLE
        }
}