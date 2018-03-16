package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Error(
        @SerializedName("code")
        var code: Int,

        @SerializedName("message")
        var message: String
)