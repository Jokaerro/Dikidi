package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class New(
        @SerializedName("id")
        val id: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("image")
        val image: Image,

        @SerializedName("street")
        val street: String,

        @SerializedName("house")
        val house: String,

        @SerializedName("schedule")
        val schedule: Any,

        @SerializedName("lat")
        val lat: String,

        @SerializedName("lng")
        val lng: String,

        @SerializedName("rating")
        val rating: Int,

        @SerializedName("categories")
        val categories: List<String>,

        @SerializedName("isMaster")
        val isMaster: Boolean,

        @SerializedName("master_id")
        val masterId: String
)