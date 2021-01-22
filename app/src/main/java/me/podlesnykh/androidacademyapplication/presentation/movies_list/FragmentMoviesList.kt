package me.podlesnykh.androidacademyapplication.movies_list

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
import me.podlesnykh.androidacademyapplication.network.Repository
import me.podlesnykh.androidacademyapplication.network.pojo.MoviesTopRatedPage
import me.podlesnykh.androidacademyapplication.network.pojo.ResultsItem
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MovieListViewModelFactory
import me.podlesnykh.androidacademyapplication.presentation.movies_list.MoviesListViewModel

class FragmentMoviesList : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MoviesListViewModel
    private var moviesList: List<ResultsItem> = listOf()
    private val adapter by lazy {
        MovieListAdapter(moviesList, imagesBaseUrl, ::openMovieDetailsScreen)
    }
    private val repository = Repository()
    private var imagesBaseUrl: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showProgress(true)
        viewModel = ViewModelProvider(this, MovieListViewModelFactory(repository)).get(MoviesListViewModel::class.java)
        viewModel.getConfiguration()
        imagesBaseUrl = viewModel.imagesBaseUrl.value
        viewModel.getMoviesTopRatedPage()
        viewModel.mutableMoviesListPage.observe(viewLifecycleOwner, this::setState)
        setupRecyclerView()
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

    private fun setState(moviesPage: MoviesTopRatedPage) {
        showProgress(false)
        adapter.submitList(moviesPage.results)
        adapter.notifyDataSetChanged()
    }

    private fun showProgress(isShown: Boolean) {
        if (isShown) {
            binding.progress?.visibility = View.VISIBLE
            binding.rvMoviesList.visibility = View.GONE
        } else {
            binding.progress?.visibility = View.GONE
            binding.rvMoviesList.visibility = View.VISIBLE
        }
    }
}