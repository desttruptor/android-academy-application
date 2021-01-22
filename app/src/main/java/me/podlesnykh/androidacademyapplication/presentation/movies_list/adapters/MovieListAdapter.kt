package me.podlesnykh.androidacademyapplication.movies_list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.databinding.MoviesListMovieItemBinding
import me.podlesnykh.androidacademyapplication.network.pojo.ResultsItem

class MovieListAdapter(
    private var movies: List<ResultsItem>,
    private val imagesBaseUrl: String?,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_list_movie_item, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) =
        holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size

    fun submitList(newList: List<ResultsItem>?) {
        val oldList = movies
        val diffResult = DiffUtil.calculateDiff(MovieListDiffUtilsCallback(oldList, newList ?: throw IllegalStateException("Movies list is null")))
        movies = newList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovieListDiffUtilsCallback(
        private val oldMovieList: List<ResultsItem>,
        private val newMovieList: List<ResultsItem>,
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

        fun bind(movie: ResultsItem) {
            // TODO display everything on ui

            binding.tvTitle.text = movie.title
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