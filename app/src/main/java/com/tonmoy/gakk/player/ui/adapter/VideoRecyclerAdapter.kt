package com.tonmoy.gakk.player.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.util.Util
import com.tonmoy.gakk.player.data.model.Video
import com.tonmoy.gakk.player.databinding.RowVideoLayoutBinding
typealias SelectVideoFunc = (video:Video) -> Unit
class VideoRecyclerAdapter: ListAdapter<Video,VideoRecyclerAdapter.VideoRecyclerViewHolder>(VideoRecyclerDiffCallBack()){

    private var selectVideoFunc:SelectVideoFunc? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoRecyclerViewHolder {
        return VideoRecyclerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: VideoRecyclerViewHolder, position: Int) {
        val video = getItem(position)
        holder.bind(video)
        holder.binding.mainContainer.setOnClickListener {
            selectVideoFunc?.invoke(video)
        }
    }
    fun onVideoSelectedListener(selectVideoFunc:SelectVideoFunc){
        this.selectVideoFunc = selectVideoFunc
    }
    class VideoRecyclerViewHolder private constructor(val binding: RowVideoLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(video: Video){
            binding.video = video
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent:ViewGroup): VideoRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding:RowVideoLayoutBinding  = RowVideoLayoutBinding.inflate(layoutInflater,parent,false)
                return VideoRecyclerViewHolder(binding)
            }
        }
    }
}
class  VideoRecyclerDiffCallBack: DiffUtil.ItemCallback<Video>() {
    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }

}