package com.example.luigui2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AudioAdapter(
    private val audioList: List<Audio>,
    private val onItemClick: (Audio) -> Unit
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.audioNameTextView)
        val imageView: ImageView = view.findViewById(R.id.audioImageView)
        val durationTextView: TextView = view.findViewById(R.id.audioDurationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audioList[position]
        holder.nameTextView.text = audio.name
        holder.imageView.setImageResource(audio.imageResId)
        holder.durationTextView.text = audio.duration
        holder.itemView.setOnClickListener { onItemClick(audio) }
    }

    override fun getItemCount() = audioList.size
}
