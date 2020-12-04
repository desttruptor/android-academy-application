package me.podlesnykh.androidacademyapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.podlesnykh.androidacademyapplication.FragmentMoviesListDirections
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.databinding.MoviesListMovieItemBinding

class MovieListAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_list_movie_item, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) =
        holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size
}

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: MoviesListMovieItemBinding = MoviesListMovieItemBinding.bind(itemView)

    fun bind(movie: Movie) {

        if (movie.like)
            binding.ivLike.setImageResource(R.drawable.ic_like_marked)
        else
            binding.ivLike.setImageResource(R.drawable.ic_like)
        
        Glide.with(binding.root.context)
            .load(movie.posterLink)
            .into(binding.ivFilmPoster)

        binding.tvAgePg.text = movie.minAge
        setRating(movie.rating)

        val reviews = movie.reviewsCount.toString() + " " + itemView.context.getString(R.string.string_reviews)
        binding.tvReviews.text = reviews

        binding.tvTagline.text = movie.genre
        binding.tvTitle.text = movie.title

        val duration = movie.duration.toString() + " " + itemView.context.getString(R.string.string_duration)
        binding.tvDuration.text = duration

        binding.root.setOnClickListener {
            val action = FragmentMoviesListDirections.navigateToMovieItem(movie)
            binding.root.findNavController().navigate(action)
        }
    }

    // setting red stars to show rating
    private fun setRating(rating: Int) {
        val stars = listOf(
            binding.star1,
            binding.star2,
            binding.star3,
            binding.star4,
            binding.star5
        )

        for (i in 0 until rating) {
            stars[i].setImageResource(R.drawable.ic_star_icon_marked)
        }
    }
}