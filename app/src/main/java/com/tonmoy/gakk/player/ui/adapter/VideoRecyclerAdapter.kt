package com.tonmoy.gakk.player.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tonmoy.gakk.player.data.model.Video
import com.tonmoy.gakk.player.databinding.RowVideoLayoutBinding

class VideoRecyclerAdapter: ListAdapter<Video,VideoRecyclerAdapter.VideoRecyclerViewHolder>(VideoRecyclerDiffCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoRecyclerViewHolder {
        return VideoRecyclerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: VideoRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
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
        return oldItem.videoUrl == newItem.videoUrl
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }

}