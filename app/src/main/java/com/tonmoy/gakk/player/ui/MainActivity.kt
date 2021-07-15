package com.tonmoy.gakk.player.ui

import android.app.PictureInPictureParams
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.tonmoy.gakk.player.R
import com.tonmoy.gakk.player.databinding.ActivityMainBinding
import com.tonmoy.gakk.player.ui.adapter.VideoRecyclerAdapter
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var player: SimpleExoPlayer? = null
    private var isPortrait: Boolean = true
    private lateinit var toggleOrientationButton: ImageButton
    private lateinit var buttonLayout: LinearLayout
    private lateinit var playerProgressBar: ProgressBar
    private lateinit var videoRecyclerAdapter: VideoRecyclerAdapter
    private val viewModel:MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUi()
        initializePlayer()
        setupVideoAdapter()
        orientationAction()
        viewModel.fetchVideo()
    }



    private fun orientationAction() {
        toggleOrientationButton.setOnClickListener {
            isPortrait = if (isPortrait) {
                doLandscape()
                false
            } else {
                doPortrait()
                true
            }
        }
    }

    private fun setupUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        supportActionBar?.hide()
        buttonLayout = binding.playerView.findViewById(R.id.buttonLinearLayout)
        playerProgressBar = binding.playerView.findViewById(R.id.progressBar)
        toggleOrientationButton = binding.playerView.findViewById(R.id.toggleOrientationButton)
    }
    private fun setupVideoAdapter() {
        videoRecyclerAdapter = VideoRecyclerAdapter()
        binding.videoRecyclerView.adapter = videoRecyclerAdapter
        videoRecyclerAdapter.onVideoSelectedListener { viewModel.selectVideo(it) }
    }

    private fun doLandscape() {
        prepareLandscapeUI()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun doPortrait() {
        preparePortraitUI()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    private fun prepareLandscapeUI() {
        toggleOrientationButton.setImageResource(R.drawable.ic_baseline_fullscreen_exit_24)
        val layoutParams = binding.playerView.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.width = ConstraintLayout.LayoutParams.MATCH_PARENT
        layoutParams.height = ConstraintLayout.LayoutParams.MATCH_PARENT
        hideSystemUI()
    }

    private fun preparePortraitUI() {
        toggleOrientationButton.setImageResource(R.drawable.ic_baseline_fullscreen_24)
        val layoutParams = binding.playerView.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.width = 0
        layoutParams.height = 0
        showSystemUI()
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.mainContainer).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            binding.mainContainer
        ).show(WindowInsetsCompat.Type.systemBars())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            prepareLandscapeUI()
            isPortrait = false
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            preparePortraitUI()
            isPortrait = true
        }
    }

    private fun initializePlayer() {
        if (player == null) {
            player = SimpleExoPlayer.Builder(this)
                .build()
            player?.addListener(playbackStatus())
            binding.playerView.player = player
        }
    }
    private fun playVideo(mediaItem: MediaItem){
        player?.clearMediaItems()
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.playWhenReady = true
    }

    private fun playbackStatus() = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
            when (playbackState) {
                ExoPlayer.STATE_BUFFERING -> showBuffering()
                ExoPlayer.STATE_READY -> hideBuffering()
                else -> hideBuffering()
            }
        }
    }

    private fun showBuffering() {
        buttonLayout.visibility = View.GONE
        playerProgressBar.visibility = View.VISIBLE
    }

    private fun hideBuffering() {
        buttonLayout.visibility = View.VISIBLE
        playerProgressBar.visibility = View.GONE
    }

    private fun showPip() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pictureInPictureParams = PictureInPictureParams
                .Builder()
                .build()
            enterPictureInPictureMode(pictureInPictureParams)
        } else {
            player?.playWhenReady = false
        }
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            prepareLandscapeUI()
            binding.playerView.hideController()
        } else {
            preparePortraitUI()
            binding.playerView.showController()
        }
    }

    override fun onStop() {
        super.onStop()
        player?.playWhenReady = false
    }

    public override fun onPause() {
        super.onPause()
        showPip()
    }
}