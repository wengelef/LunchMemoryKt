package com.wengelef.lunchmemorykt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LunchModule(private val appContext: Context) {
    @Provides @Singleton fun provideContext(): Context = appContext
}