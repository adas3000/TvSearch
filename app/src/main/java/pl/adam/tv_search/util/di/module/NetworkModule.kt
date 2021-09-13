package pl.adam.tv_search.util.di.module

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import pl.adam.tv_search.model.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    private const val TAG = "Network"

    private const val TIMEOUT = 10L

    @Provides
    @ViewModelScoped
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
            Log.d(TAG, response.peekBody(2048).string())
            response
        }
        return okHttpClient.build()
    }

    @Provides
    @ViewModelScoped
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl("https://api.tvmaze.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @ViewModelScoped
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}