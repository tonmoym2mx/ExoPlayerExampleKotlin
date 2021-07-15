package com.tonmoy.gakk.player.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ui.PlayerView
import com.tonmoy.gakk.player.data.model.Video
import com.tonmoy.gakk.player.ui.adapter.VideoRecyclerAdapter


@BindingAdapter("nullableText")
fun TextView.nullableText(text:String?=null){
    this.text = text ?: "--"
}
@BindingAdapter("submitVideo")
fun RecyclerView.submitVideo(list:List<Video>?=null){
    if(this.adapter is VideoRecyclerAdapter && list != null){
        (this.adapter as VideoRecyclerAdapter).submitList(list)
    }
}
@BindingAdapter("isShowProgressBar")
fun ProgressBar.isShowProgressBar(isShow:Boolean?=null){
    val visibility = if (isShow == true) View.VISIBLE else View.GONE
    this.visibility = visibility
}
@BindingAdapter("setImage")
fun ImageView.setImage(image:Int?=null){
    image?.let { this.setImageResource(it) }
}

@BindingAdapter("playVideo")
fun PlayerView.playVideo(video: Video?=null){
    if(video!=null) {
        player?.clearMediaItems()
        player?.setMediaItem(video.toMediaItem())
        player?.prepare()
        player?.playWhenReady = true
    }
}