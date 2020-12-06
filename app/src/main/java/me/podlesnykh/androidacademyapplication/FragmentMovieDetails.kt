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
        Glide.with(binding.root.context)
            .load(args.Movie.backDropPosterLink)
            .into(binding.ivMovieBackdrop)

        binding.tvAgePg.text = args.Movie.minAge
        binding.tvTitle.text = args.Movie.title
        binding.tvTagline.text = args.Movie.genre
        binding.rbRatingBar.rating = args.Movie.rating.toFloat()

        val reviews = args.Movie.reviewsCount.toString() + " " + context?.getString(R.string.string_reviews)
        binding.reviews.text = reviews

        binding.filmDescription.text = args.Movie.movieDescription

        binding.rvActorsList.apply {
            adapter = MovieDetailsActorListAdapter(args.Movie.actorNames, args.Movie.actorPhotoLinks)
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}