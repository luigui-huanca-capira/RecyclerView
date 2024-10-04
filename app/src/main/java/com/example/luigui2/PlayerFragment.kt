package com.example.luigui2

import android.app.Fragment
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayerFragment : Fragment() {
    private lateinit var audio: Audio
    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button
    private lateinit var audioImageView: ImageView
    private lateinit var audioNameTextView: TextView

    companion object {
        private const val ARG_AUDIO = "arg_audio"

        fun newInstance(audio: Audio): PlayerFragment {
            val fragment = PlayerFragment()
            val args = Bundle()
            args.putParcelable(ARG_AUDIO, audio)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        audio = arguments?.getParcelable(ARG_AUDIO) ?: throw IllegalArgumentException("Audio must be provided")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_player, container, false)

        audioImageView = view.findViewById(R.id.audioImageView)
        audioNameTextView = view.findViewById(R.id.audioNameTextView)
        playButton = view.findViewById(R.id.playButton)
        pauseButton = view.findViewById(R.id.pauseButton)
        stopButton = view.findViewById(R.id.stopButton)

        audioImageView.setImageResource(audio.imageResId)
        audioNameTextView.text = audio.name

        // Usa directamente el audioResId para inicializar el MediaPlayer
        mediaPlayer = MediaPlayer.create(context, audio.audioResId)

        playButton.setOnClickListener { mediaPlayer.start() }
        pauseButton.setOnClickListener { mediaPlayer.pause() }
        stopButton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}