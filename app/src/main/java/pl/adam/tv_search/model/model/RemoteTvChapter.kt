package pl.adam.tv_search.model.model

import java.io.Serializable

data class RemoteTvChapter(
    val show: Show? = null
) : Serializable {
    data class Show(
        val name: String? = null,
        val genres: List<String>? = null,
        val image: Image? = null
    ) : Serializable {
        data class Image(
            val medium: String? = null
        ) : Serializable
    }
}