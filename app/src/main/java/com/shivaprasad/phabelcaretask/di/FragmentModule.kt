package com.shivaprasad.phabelcaretask.di

import com.shivaprasad.phabelcaretask.ui.home.AddandEditFragment
import com.shivaprasad.phabelcaretask.ui.home.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun contributeAddandEditFragment(): AddandEditFragment


}
