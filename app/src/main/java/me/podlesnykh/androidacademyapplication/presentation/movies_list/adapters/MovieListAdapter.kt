package me.podlesnykh.androidacademyapplication.movies_list.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.databinding.MoviesListMovieItemBinding
import me.podlesnykh.androidacademyapplication.presentation.helpers.formatGenres
import me.podlesnykh.androidacademyapplication.presentation.models.MovieListItem

class MovieListAdapter(
    private var movies: List<MovieListItem>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_list_movie_item, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) =
        holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size

    fun submitList(newList: List<MovieListItem>) {
        val oldList = movies
        val diffResult = DiffUtil.calculateDiff(MovieListDiffUtilsCallback(oldList, newList))
        movies = newList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovieListDiffUtilsCallback(
        private val oldMovieList: List<MovieListItem>,
        private val newMovieList: List<MovieListItem>,
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

        fun bind(movie: MovieListItem) {
            if (movie.certification.isEmpty()) {
                binding.tvAgePg.visibility = View.GONE
            } else {
                binding.tvAgePg.text = movie.certification
            }

            //imageView part start
            binding.backdropProgressBar.visibility = View.VISIBLE
            Glide.with(itemView.context)
                .load(movie.posterPath)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        binding.backdropProgressBar.visibility = View.GONE
                        return false
                    }
                })
                .into(binding.ivFilmPoster)
            //imageView part end

            binding.tvGenres.text = formatGenres(movie.genres)
            setRating(movie.voteAverage)
            val reviews = movie.voteCount.toString() + " reviews"
            binding.tvReviews.text = reviews
            binding.tvTitle.text = movie.title
            val duration = movie.runtime.toString() + "min"
            binding.tvDuration.text = duration
        }

        // setting stars to show rating
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