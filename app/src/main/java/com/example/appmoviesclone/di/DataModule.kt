package com.example.appmoviesclone.di

import com.example.appmoviesclone.repository.HomeDataSource
import com.example.appmoviesclone.repository.HomeDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun provideHomeDataSource(datasource: HomeDataSourceImpl): HomeDataSource
}