package com.example.appmoviesclone.di

import android.app.Application

class MoviesApplication: Application() {
    lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}