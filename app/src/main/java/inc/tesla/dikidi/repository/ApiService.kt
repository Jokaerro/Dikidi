package inc.tesla.dikidi.repository

import inc.tesla.dikidi.repository.models.Info
import inc.tesla.dikidi.repository.models.TypedData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("home/info")
    fun getInfo(@Field("city_id") id: Int): Single<Response<TypedData<Info>>>
    //Single<Response<TypedData<List<Child>>>>
}