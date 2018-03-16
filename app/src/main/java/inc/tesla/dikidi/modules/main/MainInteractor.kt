package inc.tesla.dikidi.modules.main

import inc.tesla.dikidi.application.core.BaseInteractor
import inc.tesla.dikidi.repository.ApiService
import inc.tesla.dikidi.repository.models.Info
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor
@Inject constructor() : BaseInteractor {

    @Inject
    lateinit var apiService: ApiService

    fun getCurrentInfo(): Single<Info> {
        val body:HashMap<String, Int> = HashMap()
        body["city_id"] = 468902

        return apiService.getInfo(468902)
                .map {
                    it.body()?.data
                }
    }
}