package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Vip(
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
        var schedule: List<Schedule>,

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

        @SerializedName("currency")
        var currency: Currency
)