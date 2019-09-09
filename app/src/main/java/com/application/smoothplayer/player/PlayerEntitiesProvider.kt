package com.application.smoothplayer.player

import android.app.Application
import com.application.smoothplayer.constants.NetworkingConstants.Companion.USER_AGENT
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class PlayerEntitiesProvider(val application: Application) {
    private val dataSourceFactory: DefaultDataSourceFactory =
        DefaultDataSourceFactory(application, USER_AGENT)
    private val extractorFactory: ExtractorsFactory = DefaultExtractorsFactory()
    val mediaSourceFactory: ProgressiveMediaSource.Factory =
        ProgressiveMediaSource.Factory(dataSourceFactory, extractorFactory)
    val player: SimpleExoPlayer =
        ExoPlayerFactory.newSimpleInstance(application)
}