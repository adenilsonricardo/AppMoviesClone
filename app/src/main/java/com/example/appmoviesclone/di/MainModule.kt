package com.example.appmoviesclone.di

import com.example.appmoviesclone.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule{
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(HomeViewModel: HomeViewModel): HomeViewModel
}