package com.example.appmoviesclone.di

import android.app.Activity
import com.example.appmoviesclone.MainActivity
import com.example.appmoviesclone.ui.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [])
interface MainComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): MainComponent
    }
    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
}