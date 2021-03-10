package org.overheap.padpad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import org.overheap.padpad.databinding.FragmentHistoryBinding
import org.overheap.padpad.databinding.FragmentMainBinding
import org.overheap.padpad.databinding.HistoryListItemSoundBinding
import org.overheap.padpad.databinding.ListItemSoundBinding

class HistoryFragment : Fragment() {

    private val appViewModel: ApplicationViewModel
            by lazy { ViewModelProvider(requireActivity()).get(ApplicationViewModel::class.java) }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = SoundAdapter(appViewModel.historyList)
    }

    private inner class SoundHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        private lateinit var sound: Sound

        private val historyPosition: TextView = itemView.findViewById(R.id.history_position)
        private val title: TextView = itemView.findViewById(R.id.history_sound_name)

        fun bind(sound: Sound, position: Int) {
            historyPosition.text = getString(R.string.position, position)
            title.text = sound.name
        }

    }

    private inner class SoundAdapter(private val sounds: List<Sound>) :
        RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                SoundHolder {
            val view = layoutInflater.inflate(
                R.layout.history_list_item_sound,
                parent,
                false
            )
            return SoundHolder(view)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound = sounds[position]
            holder.bind(sound, position)
        }

        override fun getItemCount() = sounds.size
    }

}