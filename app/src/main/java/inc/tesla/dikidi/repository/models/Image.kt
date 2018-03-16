package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("thumb")
        var thumb: String,

        @SerializedName("origin")
        var origin: String
)