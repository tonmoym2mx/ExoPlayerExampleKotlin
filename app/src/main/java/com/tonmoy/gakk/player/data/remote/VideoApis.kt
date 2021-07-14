package com.tonmoy.gakk.player.data.remote

import com.tonmoy.gakk.player.data.model.Video
import kotlinx.coroutines.delay

class VideoApis {
    //Fake Data
    suspend fun fetchVideo(): List<Video> {
        delay(1000L)
        return listOf(
            Video(
                title = "Demo Video 1",
                description = "Demo Video 1",
                views = 100,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/Funny%20Cats%20And%20Babies%20Playing%20Together%20%E2%98%85%20Animals%20Trolling%20Babies.mp4?alt=media&token=b7b2d60d-b970-4723-a7ea-dd460e1e9fc3",

                videoThumbnailImage = null
            ),
            Video(
                title = "Demo Video 2",
                description = "Demo Video 2",
                views = 200,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/Funny%20Cats%20And%20Babies%20Playing%20Together%20%E2%98%85%20Animals%20Trolling%20Babies.mp4?alt=media&token=b7b2d60d-b970-4723-a7ea-dd460e1e9fc3",

                videoThumbnailImage = null
            ),
            Video(
                title = "Demo Video 3",
                description = "Demo Video 3",
                views = 300,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/Funny%20Cats%20And%20Babies%20Playing%20Together%20%E2%98%85%20Animals%20Trolling%20Babies.mp4?alt=media&token=b7b2d60d-b970-4723-a7ea-dd460e1e9fc3",
                videoThumbnailImage = null
            )
        )
    }
}