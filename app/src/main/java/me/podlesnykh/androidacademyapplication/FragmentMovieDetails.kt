package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class FragmentMovieDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        // textView is used as a button
        val tvBack: TextView = view.findViewById(R.id.tv_back)
        tvBack.setOnClickListener {
            val navHostFragment = requireActivity()
                .supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.navigate_to_movies_list)
        }

        return view
    }
}