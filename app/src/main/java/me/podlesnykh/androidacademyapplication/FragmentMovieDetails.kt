package me.podlesnykh.androidacademyapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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

    @SuppressLint("SetTextI18n")
    private fun setupView() {
        context?.let {
            Glide.with(it)
                .load(args.Movie.backDropPosterLink)
                .into(binding.ivMovieBackdrop)
        }

        binding.tvAgePg.text = args.Movie.minAge
        binding.tvTitle.text = args.Movie.title
        binding.tvTagline.text = args.Movie.genre
        binding.rbRatingBar.rating = args.Movie.rating.toFloat()
        binding.reviews.text = args.Movie.reviewsCount.toString() + " " + context?.getString(R.string.string_reviews)
        binding.filmDescription.text = args.Movie.movieDescription

        context?.let {
            Glide.with(it)
                .load(args.Movie.actor1PhotoLink)
                .into(binding.actorPhoto1)
        }
        binding.actorName1.text = args.Movie.actor1Name
        context?.let {
            Glide.with(it)
                .load(args.Movie.actor2PhotoLink)
                .into(binding.actorPhoto2)
        }
        binding.actorName2.text = args.Movie.actor2Name
        context?.let {
            Glide.with(it)
                .load(args.Movie.actor3PhotoLink)
                .into(binding.actorPhoto3)
        }
        binding.actorName3.text = args.Movie.actor3Name
        context?.let {
            Glide.with(it)
                .load(args.Movie.actor4PhotoLink)
                .into(binding.actorPhoto4)
        }
        binding.actorName4.text = args.Movie.actor4Name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}