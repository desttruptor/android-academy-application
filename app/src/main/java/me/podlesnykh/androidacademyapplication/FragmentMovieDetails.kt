package me.podlesnykh.androidacademyapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentMovieDetails : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.activity_movie_details, container, false)

        // textView is used as a button
        val tvBack: TextView = rootView.findViewById(R.id.tv_back)
        tvBack.setOnClickListener{
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .remove(this)
                .commit()
        }

        return rootView
    }
}
