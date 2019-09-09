package com.application.smoothplayer.ui.main.fragments.home

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.application.smoothplayer.R
import com.application.smoothplayer.ui.base.viewmodel.ViewModelFactory
import com.application.smoothplayer.ui.main.fragments.home.adapter.SongListAdapter
import com.application.smoothplayer.ui.main.fragments.home.viewmodel.HomeViewModel
import com.application.smoothplayer.utils.requestForASinglePermission
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment @Inject constructor() : DaggerFragment() {

    private val TAG: String = HomeFragment::class.java.simpleName

    @BindView(R.id.home_main_item_list_recycler_view)
    lateinit var songListView: RecyclerView

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var songListAdapter: SongListAdapter? = null
    private lateinit var viewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this,
                                          viewModelFactory)[HomeViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater
                .inflate(R.layout.home_fragment_layout, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        songListView =
                activity?.findViewById(R.id.home_main_item_list_recycler_view)!!
        getStoragePermissionAndContinue()
    }

    private fun getStoragePermissionAndContinue() {
        activity?.let {
            requestForASinglePermission(it,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        object : PermissionListener {
                                            override fun onPermissionGranted(
                                                    response: PermissionGrantedResponse?) {
                                                showSongs()
                                            }

                                            override fun onPermissionRationaleShouldBeShown(
                                                    permission: PermissionRequest?,
                                                    token: PermissionToken?) {
                                                Log
                                                        .d(TAG,
                                                           "PermissionRationale")
                                            }

                                            override fun onPermissionDenied(
                                                    response: PermissionDeniedResponse?) {
                                                Log.d(TAG, "PermissionDenied")
                                            }
                                        })

        }
    }

    private fun showSongs() {
        songListAdapter = context?.run { SongListAdapter(this) }
        songListView.adapter = songListAdapter
        songListView.layoutManager = LinearLayoutManager(context)
        viewModel.songs.observe(this, Observer { songList ->
            songList?.let {
                songListAdapter?.setData(it)
            }
        })
    }
}