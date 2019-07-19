package com.application.mvvmmusicplayer.ui.main

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.di.application.AppComponent
import com.application.mvvmmusicplayer.ui.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    @BindView(R.id.mainContainer)
    lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        supportFragmentManager.beginTransaction().
            add(R.id.mainContainer, HomeFragment()).commit()
    }
}