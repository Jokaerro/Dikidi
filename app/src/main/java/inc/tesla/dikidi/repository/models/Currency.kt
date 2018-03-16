package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Currency(
        @SerializedName("id")
        var id: String,

        @SerializedName("title")
        var title: String,

        @SerializedName("abbr")
        var abbr: String
)