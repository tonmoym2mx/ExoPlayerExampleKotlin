package com.tonmoy.gakk.player.data.model

import android.media.browse.MediaBrowser
import com.google.android.exoplayer2.MediaItem
import java.io.Serializable

data class Video(
    val id:Int,
    val title:String?=null,
    val description:String?=null,
    val views:Int?=null,
    val videoUrl:String?=null,
    val videoThumbnailImage:Int?=null,
):Serializable{
    fun viewString() = "${this.views} Views"
    fun toMediaItem(): MediaItem  = MediaItem.fromUri(this.videoUrl?:"")
}
