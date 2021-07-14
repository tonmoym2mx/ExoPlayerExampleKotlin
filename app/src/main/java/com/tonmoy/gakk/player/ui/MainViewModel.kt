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
    val mediaItemList:LiveData<List<MediaItem>> = Transformations.map(videoList){
        it.map { video -> video.toMediaItem() }.toList()
    }
    fun fetchVideo() = viewModelScope.launch(Dispatchers.IO) {
        isShowProgressBar.postValue(true)
        val video = videoRepository.fetchVideos()
        videoList.postValue(video)
        isShowProgressBar.postValue(false)
    }


}