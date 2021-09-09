package pl.adam.tv_search.util.di.module

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TAG = "Network"

    private const val TIMEOUT = 10L

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.addInterceptor {
            val request = it.request()
            Log.d(TAG, request.method)
            Log.d(TAG, request.url.toString())
            Log.d(TAG, request.headers.toString())
            val response = it.proceed(request)
            Log.d(TAG, response.code.toString())
            Log.d(TAG, response.message)
            Log.d(TAG, response.body?.string().toString())
            response
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl("https://api.tvmaze.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}