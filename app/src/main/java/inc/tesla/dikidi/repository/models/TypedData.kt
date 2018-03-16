package inc.tesla.dikidi.repository.models

import com.google.gson.annotations.SerializedName

class TypedData<T: Any> {
    @SerializedName("error")
    var error: Error? = null

    @SerializedName("data")
    var data: T? = null
}