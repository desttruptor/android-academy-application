package me.podlesnykh.androidacademyapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.data.Movie
import me.podlesnykh.androidacademyapplication.data.formatGenres
import me.podlesnykh.androidacademyapplication.databinding.MoviesListMovieItemBinding

class MovieListAdapter(
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_list_movie_item, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) =
        holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size

    fun submitList(newList: List<Movie>) {
        val oldList = movies
        val diffResult = DiffUtil.calculateDiff(MovieListDiffUtilsCallback(oldList, newList))
        movies = newList
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateMovies(newMoviesList: List<Movie>) {
        val movieDiffResult = DiffUtil.calculateDiff(MovieListDiffUtilsCallback(this.movies, newMoviesList))
        movieDiffResult.dispatchUpdatesTo(this)
    }

    inner class MovieListDiffUtilsCallback(
        private val oldMovieList: List<Movie>,
        private val newMovieList: List<Movie>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldMovieList.size

        override fun getNewListSize(): Int = newMovieList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldMovie = oldMovieList[oldItemPosition]
            val newMovie = newMovieList[newItemPosition]
            return oldMovie.id == newMovie.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldMovie = oldMovieList[oldItemPosition]
            val newMovie = newMovieList[newItemPosition]
            return oldMovie == newMovie
        }
    }

    inner class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: MoviesListMovieItemBinding = MoviesListMovieItemBinding.bind(itemView)

        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title

            Glide.with(itemView.context)
                .load(movie.poster)
                .into(binding.ivFilmPoster)

            val rating = movie.ratings / 2
            setRating(rating.toInt())

            val reviewsCount = movie.numberOfRatings.toString() + " " + binding.root.context.getString(R.string.string_reviews)
            binding.tvReviews.text = reviewsCount

            val age = movie.minimumAge.toString() + binding.root.context.getString(R.string.plus_symbol)
            binding.tvAgePg.text = age

            val runtime = movie.runtime.toString() + " " + binding.root.context.getString(R.string.str_min)
            binding.tvDuration.text = runtime

            binding.tvTagline.text = formatGenres(movie)

            binding.root.setOnClickListener {
                onClick(movie)
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
}