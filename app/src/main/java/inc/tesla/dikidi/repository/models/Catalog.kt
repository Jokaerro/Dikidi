package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Catalog(
        @SerializedName("id")
        var id: String,

        @SerializedName("name")
        var name: String,

        @SerializedName("image")
        var image: Image,
        @SerializedName("street")
        var street: String,

        @SerializedName("house")
        var house: String,

        @SerializedName("schedule")
        var schedule: Any,

        @SerializedName("lat")
        var lat: String,

        @SerializedName("lng")
        var lng: String,

        @SerializedName("rating")
        var rating: Float,

        @SerializedName("categories")
        var categories: List<String>,

        @SerializedName("isMaster")
        var isMaster: Boolean,

        @SerializedName("master_id")
        var masterId: String,

        @SerializedName("advertising")
        var advertising: String
)