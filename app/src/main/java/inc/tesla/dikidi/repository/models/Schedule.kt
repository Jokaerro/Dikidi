package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Schedule(
        @SerializedName("day")
        var day: String,

        @SerializedName("work_from")
        var workFrom: String,

        @SerializedName("work_to")
        var workTo: String
)
