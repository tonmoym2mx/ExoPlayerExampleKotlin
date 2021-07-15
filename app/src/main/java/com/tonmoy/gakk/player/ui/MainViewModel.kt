package com.tonmoy.gakk.player.ui

import androidx.lifecycle.*
import com.google.android.exoplayer2.MediaItem


import com.tonmoy.gakk.player.data.model.Video
import com.tonmoy.gakk.player.data.repository.VideoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val videoRepository: VideoRepository): ViewModel() {
    val isShowProgressBar: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }
    val videoList: MutableLiveData<List<Video>> by lazy { MutableLiveData<List<Video>>() }
    val selectedVideo: MutableLiveData<Video> by lazy { MutableLiveData<Video>() }

    fun fetchVideo() = viewModelScope.launch(Dispatchers.IO) {
        isShowProgressBar.postValue(true)
        val videos = videoRepository.fetchVideos()
        videoList.postValue(videos)
        selectedVideo.postValue(videos?.first())
        isShowProgressBar.postValue(false)
    }

    fun selectVideo(video: Video) {
        selectedVideo.postValue(video)
    }


}