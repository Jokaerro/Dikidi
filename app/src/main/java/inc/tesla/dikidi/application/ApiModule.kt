package inc.tesla.dikidi.application

import android.content.Context
import android.util.Log
import auto.parcelgson.gson.AutoParcelGsonTypeAdapterFactory
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import dagger.Module
import dagger.Provides
import inc.tesla.dikidi.BuildConfig
import inc.tesla.dikidi.application.DateUtils.API_DATE_PATTERN
import inc.tesla.dikidi.component.networks.RxErrorHandlingCallAdapterFactory
import inc.tesla.dikidi.repository.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApiModule(private val context: Context)  {

    private val longTypeAdapter = object : TypeAdapter<Number>() {

        @Throws(IOException::class)
        override fun write(out: JsonWriter, value: Number) {
            out.value(value)
        }

        @Throws(IOException::class)
        override fun read(`in`: JsonReader): Number? {
            if (`in`.peek() === JsonToken.NULL) {
                `in`.nextNull()
                return null
            }
            try {
                val result = `in`.nextString()
                return if ("" == result) {
                    null
                } else java.lang.Long.parseLong(result)
            } catch (e: NumberFormatException) {
                throw JsonSyntaxException(e)
            }

        }
    }

    @Provides
    internal fun provideGson(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder()
                .registerTypeAdapterFactory(AutoParcelGsonTypeAdapterFactory())
                .setDateFormat(API_DATE_PATTERN)
                .registerTypeAdapter(Long::class.java, longTypeAdapter)
                .create())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                ))
                .addInterceptor { chain ->

                    val request = chain.request()
                    val response = chain.proceed(request)

                    response
                }
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .build()

        return okHttpClient
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .build()

        return retrofit
    }

    @Provides
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
