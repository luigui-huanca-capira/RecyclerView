package com.example.luigui2


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AudioListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var audioAdapter: AudioAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_audio_list, container, false)
        recyclerView = view.findViewById(R.id.audioRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Incluimos el ID del recurso de audio directamente
        val audioList = listOf(
            Audio("Audio 1", R.raw.audio1, R.drawable.audio_image_1, "3:45"),
            Audio("Audio 2", R.raw.audio2, R.drawable.audio_image_2, "4:20"),
            Audio("Audio 3", R.raw.audio3, R.drawable.audio_image_3, "2:55"),
            Audio("Audio 4", R.raw.audio4, R.drawable.audio_image_4, "3:30"),
            Audio("Audio 5", R.raw.audio5, R.drawable.audio_image_5, "5:15")
        )

        audioAdapter = AudioAdapter(audioList) { audio ->
            // Implementar la lógica para abrir el fragmento de reproducción
            val playerFragment = PlayerFragment.newInstance(audio)
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, playerFragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = audioAdapter

        return view
    }
}
