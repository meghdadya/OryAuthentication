package com.example.data.di

import com.example.data.data_source.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.data.data_source.remote.network.adapter.NetworkCallAdapterFactory
import com.example.data.models.base.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Reusable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .create()

    @Provides
    @Reusable
    fun provideOkHttpClient(
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor { message ->
                println("LOG-NET: $message")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        )
        .build()

    @Provides
    fun providesNetworkCallAdapterFactory(): CallAdapter.Factory {
        return NetworkCallAdapterFactory()
    }

    @Provides
    fun providesRetrofit(
        client: OkHttpClient,
        gson: Gson,
//        json: Json,
        networkCallAdapterFactory: CallAdapter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(networkCallAdapterFactory)
            .build()
    }

    @Provides
    fun provideAppService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}