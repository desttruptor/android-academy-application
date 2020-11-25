package me.podlesnykh.androidacademyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class FragmentMoviesList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)

        val card: View = view.findViewById(R.id.movie_item_container)
        card.setOnClickListener {
            val navHostFragment = requireActivity()
                .supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.navigate_to_movie_item)
        }

        return view
    }
}