package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

data class Block(
        @SerializedName("favorites")
        var favorites: List<Object>,

        @SerializedName("vip")
        var vip: List<Vip>,

        @SerializedName("categories")
        var categories: List<Category>,

        @SerializedName("popular")
        var popular: List<Popular>,

        @SerializedName("examples")
        var examples: String,

        @SerializedName("shares")
        var shares: Shares,

        @SerializedName("new")
        var news: List<New>,

        @SerializedName("catalog")
        var catalog: List<Catalog>
)