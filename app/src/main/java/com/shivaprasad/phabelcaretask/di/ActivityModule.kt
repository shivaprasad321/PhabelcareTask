package com.shivaprasad.phabelcaretask.di
import com.shivaprasad.phabelcaretask.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityModule {
    /*
     * We modify our com.shivaprasad.phabelcaretask.di.ActivityModule by adding the
     * com.shivaprasad.phabelcaretask.di.FragmentModule to the Activity which contains
     * the fragment
     */
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

}
