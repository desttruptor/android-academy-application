package me.podlesnykh.androidacademyapplication.movie_details.adapters

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
import me.podlesnykh.androidacademyapplication.presentation.models.Actor

class MovieDetailsActorListAdapter(
    private val actorsList: List<Actor>
) : RecyclerView.Adapter<ActorListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ActorListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_details_actor_item, parent, false))

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) =
        holder.bind(actorsList[position])

    override fun getItemCount() = actorsList.size
}

class ActorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = MovieDetailsActorItemBinding.bind(itemView)

    fun bind(actor: Actor) {
        val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(15))
        Glide.with(binding.root.context)
            .load(actor.profilePicturePath)
            .apply(requestOptions)
            .into(binding.actorPhoto)

        binding.actorName.text = actor.name
    }

}