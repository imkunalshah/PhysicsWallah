package com.kunal.physicswallah.di

import com.kunal.physicswallah.data.network.MyApi
import com.kunal.physicswallah.data.repositories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(
        api: MyApi
    ): DataRepository {
        return DataRepository(api)
    }

}