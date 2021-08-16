package com.example.appmoviesclone.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import java.security.AccessControlContext
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class, MainComponent::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
    fun mainComponent(): MainComponent.Factory
}
@Module(subcomponents = [MainComponent::class])
object SubcomponentsModule