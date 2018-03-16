package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Popular(
        @SerializedName("id")
        val id: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("image")
        val image: Image,

        @SerializedName("image_id")
        val imageId: String,

        @SerializedName("street")
        val street: String,

        @SerializedName("house")
        val house: String,

        @SerializedName("schedule")
        val schedule: List<Schedule>,

        @SerializedName("rating")
        val rating: Float
)