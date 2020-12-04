package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import me.podlesnykh.androidacademyapplication.adapters.MovieListAdapter
import me.podlesnykh.androidacademyapplication.data.MovieStorage
import me.podlesnykh.androidacademyapplication.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        val view = binding.root

        bindRecyclerView()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindRecyclerView() {
        binding.rvMoviesList.adapter = MovieListAdapter(MovieStorage.getMovies)
        binding.rvMoviesList.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }
}