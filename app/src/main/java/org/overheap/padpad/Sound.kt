package org.overheap.padpad

import androidx.core.text.isDigitsOnly
import java.util.*

private const val WAV = ".wav"

class Sound(val assetPath: String, var soundId: Int? = null) {

    val name = assetPath.split("/").last().removeSuffix(WAV).normalize()

}

fun String.normalize(): String {
    return this.split("_")
        .filter { !it.isDigitsOnly() }
        .joinToString(" ")
        .toLowerCase(Locale.ROOT)
        .capitalize(Locale.ROOT)
}