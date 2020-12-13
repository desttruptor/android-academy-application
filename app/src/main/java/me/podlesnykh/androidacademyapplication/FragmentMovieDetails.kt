package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import me.podlesnykh.androidacademyapplication.adapters.MovieDetailsActorListAdapter
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.databinding.FragmentMovieDetailsBinding

class FragmentMovieDetails : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: FragmentMovieDetailsArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        setupView()

        binding.tvBack.setOnClickListener {
            findNavController().navigate(R.id.navigate_to_movies_list)
        }

        return view
    }

    private fun setupView() {
        val movie = args.Movie

        binding.tvTitle.text = movie.title
        binding.filmDescription.text = movie.overview

        Glide.with(binding.root.context)
            .load(movie.backdrop)
            .into(binding.ivMovieBackdrop)

        binding.rbRatingBar.rating = movie.ratings/2

        val reviews = movie.numberOfRatings.toString() + " " + R.string.string_reviews
        binding.reviews.text = reviews

        val minAge = movie.minimumAge.toString() + R.string.plus_symbol
        binding.tvAgePg.text = minAge

        binding.tvTagline.text = genreStringConstructor(movie)

        binding.rvActorsList.apply {
            adapter = MovieDetailsActorListAdapter(movie.actors)
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun genreStringConstructor(movie: Movie): String {
        var result = ""
        for (genre in movie.genres) {
            result += genre.name + ", "
        }
        return result.trim()
    }
}