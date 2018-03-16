package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Info(
        @SerializedName("title")
        var title: String,

        @SerializedName("image")
        var image: String,

        @SerializedName("catalog_count")
        var catalogCount: Int,

        @SerializedName("blocks")
        var blocks: Block
)
