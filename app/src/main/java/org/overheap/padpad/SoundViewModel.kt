package org.overheap.padpad

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(val beatBox: BeatBox): BaseObservable() {

    var sound: Sound? = null
        set(sound){
            field = sound
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    val title: String?
        get() = sound?.name

    fun onButtonClicked(){
        sound?.let { beatBox.play(it) }
    }

}