package org.overheap.padpad

import androidx.lifecycle.ViewModel

class ApplicationViewModel : ViewModel() {

    val historyList: MutableList<Sound> = mutableListOf()

    fun add(sound: Sound) = historyList.add(sound)

}