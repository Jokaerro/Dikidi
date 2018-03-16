package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Shares(
        @SerializedName("list")
        var list: List<SharesList>,

        @SerializedName("count")
        var count: String
)