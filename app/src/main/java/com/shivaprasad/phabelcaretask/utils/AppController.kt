package com.shivaprasad.phabelcaretask.utils

import android.app.Activity
import android.app.Application
import android.content.BroadcastReceiver
import android.content.res.Configuration
import androidx.fragment.app.Fragment
import com.shivaprasad.phabelcaretask.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasBroadcastReceiverInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class AppController : Application(), HasActivityInjector, HasSupportFragmentInjector,
    HasBroadcastReceiverInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var receiverInjector: DispatchingAndroidInjector<BroadcastReceiver>

    override fun activityInjector(): AndroidInjector<Activity> {

        return dispatchingAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> {
        return receiverInjector
    }

    override fun onCreate() {
        super.onCreate()


        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
