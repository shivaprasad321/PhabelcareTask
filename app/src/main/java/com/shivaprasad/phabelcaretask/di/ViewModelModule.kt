package com.shivaprasad.phabelcaretask.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shivaprasad.phabelcaretask.di.ViewModelKey
import com.shivaprasad.phabelcaretask.ui.home.ContactViewModelFatory
import com.shivaprasad.phabelcaretask.ui.home.ContactsViewModel
import com.shivaprasad.phabelcaretask.utils.AppController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class ViewModelModule {
/*
    @Provides
    @Singleton
    fun provideApplication(app: AppController): Context = app*/

    @Binds
    abstract fun bindViewModelFactory(factory: ContactViewModelFatory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    abstract fun bindContactsViewModel(viewModel: ContactsViewModel): ViewModel


}
