package com.androidapplication.smoothplayer.ui.main

import android.os.Bundle
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.datamanagers.LibraryManager
import com.androidapplication.smoothplayer.repositories.SongsRepository
import com.androidapplication.smoothplayer.ui.main.fragments.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : DaggerAppCompatActivity() {

    @BindView(R.id.main_container)
    lateinit var container: FrameLayout

    @Inject
    lateinit var repository: SongsRepository

    @Inject
    lateinit var libraryManager: LibraryManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        supportFragmentManager.beginTransaction().add(
            R.id.main_container,
            HomeFragment()
        ).commit()
    }
}