package com.example.md_lab05__gson

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import timber.log.Timber
import timber.log.Timber.Forest.plant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        plant(Timber.DebugTree())
    }

    data class Photo(
        val id: String,
        val owner: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val title: String,
        val isPublic: Int,
        val isFriend: Int,
        val isFamily: Int
    )

    data class PhotoPage(
        val page: Int,
        val pages: Int,
        val perPage: Int,
        val total: Int,
        val photo: List<Photo>
    )

    data class Wrapper(
        val photos: PhotoPage
    )
}