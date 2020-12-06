package me.podlesnykh.androidacademyapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
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
        val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(15))
        Glide.with(binding.root.context)
            .load(actorPhotoLink)
            .apply(requestOptions)
            .into(binding.actorPhoto)

        binding.actorName.text = actorName
    }

}