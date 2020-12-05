package me.podlesnykh.androidacademyapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.podlesnykh.androidacademyapplication.R
import me.podlesnykh.androidacademyapplication.databinding.MovieDetailsActorItemBinding

class MovieDetailsActorListAdapter(
    private val actorNames: List<String>,
    private val actorPhotoLinks: List<String>
) : RecyclerView.Adapter<ActorListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ActorListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_details_actor_item, parent, false))

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) =
        holder.bind(actorNames[position], actorPhotoLinks[position])

    override fun getItemCount() = actorNames.size
}

class ActorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = MovieDetailsActorItemBinding.bind(itemView)

    fun bind(actorName: String, actorPhotoLink: String) {
        Glide.with(binding.root.context)
            .load(actorPhotoLink)
            .into(binding.actorPhoto)

        binding.actorName.text = actorName
    }

}