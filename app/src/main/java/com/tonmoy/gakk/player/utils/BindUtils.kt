package com.tonmoy.gakk.player.utils

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tonmoy.gakk.player.data.model.Video
import com.tonmoy.gakk.player.ui.adapter.VideoRecyclerAdapter


@BindingAdapter("nullableText")
fun TextView.nullableText(text:String?=null){
    this.text = text ?: "Unknown"
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