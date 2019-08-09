package com.application.mvvmmusicplayer.ui.main

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.base.MVVMMusicPlayerApplication
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.repositories.SongsRepository
import com.application.mvvmmusicplayer.ui.main.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.main_container)
    lateinit var container: FrameLayout

    @Inject
    lateinit var repository: SongsRepository

    @Inject
    lateinit var libraryManager: LibraryManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MVVMMusicPlayerApplication).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        supportFragmentManager.beginTransaction().
            add(R.id.main_container, HomeFragment()).commit()
    }
}