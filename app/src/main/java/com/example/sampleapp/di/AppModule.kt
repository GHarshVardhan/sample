package com.example.sampleapp.di

import com.example.sampleapp.BuildConfig
import com.example.sampleapp.network.ApiHelper
import com.example.sampleapp.network.ApiHelperImpl
import com.example.sampleapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideBaseUrl() = "https://yh-finance.p.rapidapi.com/market/v2/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("X-RapidAPI-Key", "ce25293794msh4046ae4e0414840p1f5beejsn319e8901f24f")
                    builder.header("X-RapidAPI-Host", "yh-finance.p.rapidapi.com")
                    return@Interceptor chain.proceed(builder.build())
                })
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
        }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}