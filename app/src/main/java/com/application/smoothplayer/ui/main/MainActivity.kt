package com.application.smoothplayer.ui.main

import android.os.Bundle
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.application.smoothplayer.R
import com.application.smoothplayer.datamanagers.LibraryManager
import com.application.smoothplayer.repositories.SongsRepository
import com.application.smoothplayer.ui.main.fragments.home.HomeFragment
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