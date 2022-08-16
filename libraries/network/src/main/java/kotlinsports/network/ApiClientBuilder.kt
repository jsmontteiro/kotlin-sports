package kotlinsports.network

import com.google.gson.Gson
import kotlinsports.libraries.network.BuildConfig
import kotlinsports.network.interceptors.BasicLoggerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientBuilder {
    private val baseClient = OkHttpClient.Builder().build()

    private val defaultUrl = "https://ancient-wood-1161.getsandbox.com:443/"

    fun <T> createServiceApi(
        serviceClass: Class<T>,
        baseUrl: String = defaultUrl,
        gson: Gson = gsonDefault,
        vararg interceptors: Interceptor
    ): T {
        val clientBuilder = baseClient.newBuilder()

        clientBuilder.addInterceptor(BasicLoggerInterceptor())

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(loggingInterceptor)
        }

        interceptors.forEach { clientBuilder.addInterceptor(it) }

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(serviceClass)
    }
}
