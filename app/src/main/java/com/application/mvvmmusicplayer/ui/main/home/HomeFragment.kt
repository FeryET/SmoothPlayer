package com.application.mvvmmusicplayer.ui.main.home

import android.Manifest
import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.base.MVVMMusicPlayerApplication
import com.application.mvvmmusicplayer.di.application.AppComponent
import com.application.mvvmmusicplayer.di.application.DaggerAppComponent
import com.application.mvvmmusicplayer.di.viewmodel.DaggerViewModelComponent
import com.application.mvvmmusicplayer.di.viewmodel.ViewModelComponent
import com.application.mvvmmusicplayer.ui.main.home.adapter.SongListAdapter
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModel
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModelFactory
import com.application.mvvmmusicplayer.utils.requestForASinglePermission
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import javax.inject.Inject

class HomeFragment @Inject constructor(): Fragment() {

    private val TAG: String = HomeFragment::class.java.simpleName
    @BindView(R.id.homeFragmentSongListView)
    lateinit var songListView: RecyclerView

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    private var songListAdapter: SongListAdapter? = null
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ButterKnife.bind(view)
        DaggerViewModelComponent.builder()
            .appComponent((activity?.application as MVVMMusicPlayerApplication).appComponent).
                build().inject(this)
        super.onViewCreated(view, savedInstanceState)
        getStoragePermissionAndContinue()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun getStoragePermissionAndContinue(){
        activity?.let {
            requestForASinglePermission(it,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                object: PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    showMusicList()
                }
                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    Log.d(TAG, "PermissionRationale")
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    Log.d(TAG, "PermissionDenied")
                }
            })

        }
    }
    private fun showMusicList(){
        songListAdapter = context?.let { SongListAdapter(it) }
        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        viewModel.getSongs().observe(this, Observer {songs ->
            songs?.let {
                songListAdapter?.setData(it)
            }
        })
    }
}