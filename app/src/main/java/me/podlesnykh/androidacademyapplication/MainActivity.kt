package me.podlesnykh.androidacademyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentMovieDetails = FragmentMovieDetails()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_activity_root, fragmentMovieDetails)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}