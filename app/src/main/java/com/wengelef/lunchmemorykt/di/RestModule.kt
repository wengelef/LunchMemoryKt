package com.wengelef.lunchmemorykt.di

import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wengelef.lunchmemorykt.data.AuthService
import com.wengelef.lunchmemorykt.data.AuthServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RestModule {

    @Provides @Singleton
    fun provideAuthService(auth: FirebaseAuth): AuthService {
        return AuthServiceImpl(auth)
    }

    @Provides @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }
}