package com.example.msmtest.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.respository.Repository
import com.example.msmtest.domain.respository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRequestQueue(@ApplicationContext context: Context): RequestQueue {
        return Volley.newRequestQueue(context)
    }



    @Provides
    @Singleton
    fun provideRepository(requestQueue: RequestQueue, api: Api): Repository {
        return RepositoryImpl(requestQueue, api)
    }

}
