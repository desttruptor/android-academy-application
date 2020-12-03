package me.podlesnykh.androidacademyapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.databinding.MoviesListMovieItemBinding

class MovieListAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_list_movie_item, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: MoviesListMovieItemBinding = MoviesListMovieItemBinding.bind(itemView)

    fun onBind(movie: Movie) {
        binding.ivFilmPoster.setImageResource(movie.posterPath)
        binding.tvAgePg.text = movie.age
        setRating(movie.rating)

        val reviews = movie.reviewsCount.toString() + " " + itemView.context.getString(R.string.string_reviews)
        binding.tvReviews.text = reviews

        binding.tvTagline.text = movie.tagline
        binding.tvTitle.text = movie.title

        val duration = movie.duration.toString() + " " + itemView.context.getString(R.string.string_duration)
        binding.tvDuration.text = duration
    }

    private fun setRating(rating: Int) {
        val stars = listOf<ImageView>(
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