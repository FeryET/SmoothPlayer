package com.androidapplication.smoothplayer.player

import android.app.Application
import android.content.Context
import com.androidapplication.smoothplayer.constants.NetworkingConstants.Companion.USER_AGENT
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class PlayerEntitiesProvider(val context: Context) {
    private val dataSourceFactory: DefaultDataSourceFactory =
        DefaultDataSourceFactory(context, USER_AGENT)
    private val extractorFactory: ExtractorsFactory = DefaultExtractorsFactory()
    val mediaSourceFactory: ProgressiveMediaSource.Factory =
        ProgressiveMediaSource.Factory(dataSourceFactory, extractorFactory)
    val player: SimpleExoPlayer =
        ExoPlayerFactory.newSimpleInstance(context)
}