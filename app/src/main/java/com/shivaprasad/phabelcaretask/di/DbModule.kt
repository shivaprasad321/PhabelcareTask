package com.shivaprasad.phabelcaretask.di

import android.app.Application
import com.shivaprasad.phabelcaretask.data.db.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): AppDataBase {
        return AppDataBase(application)
    }

    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */
    /*  @Provides
      @Singleton
      internal fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
          return appDatabase.movieDao()
      }*/
}
