package com.tonmoy.gakk.player.data.repository

import com.tonmoy.gakk.player.data.remote.VideoApis

class VideoRepository(private val videoApis: VideoApis) {
    suspend fun fetchVideos() = videoApis.fetchVideo()
}