package com.shivaprasad.phabelcaretask.di
import android.content.Context
import com.shivaprasad.phabelcaretask.data.api.ContactRepository
import com.shivaprasad.phabelcaretask.utils.AppController
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return AppController().applicationContext
    }

    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)

   /* @Provides
    @Singleton
    fun provideContactRepository(repository: ContactRepository?): ContactRepository? {
        return repository
    }*/

  }
