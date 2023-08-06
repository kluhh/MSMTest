package com.example.msmtest.di

import android.app.Application
import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.msmtest.common.Constants
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.respository.Repository
import com.example.msmtest.domain.respository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }




    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): Api {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(Api::class.java)
    }





    @Provides
    @Singleton
    fun provideRepository(api: Api): Repository {
        return RepositoryImpl(api)
    }



}
