package com.example.msmtest.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.msmtest.common.Constants
import com.example.msmtest.data.database.AppDatabase
import com.example.msmtest.data.database.dao.PeopleDAO
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.respository.Repository
import com.example.msmtest.domain.respository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api: Api, peopleDAO: PeopleDAO, context: Context): Repository {
        return RepositoryImpl(api, peopleDAO,context)
    }

    @Provides
    fun providePeopleDAO(appDatabase: AppDatabase): PeopleDAO {
        return appDatabase.peopleDao()
    }


    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
}
