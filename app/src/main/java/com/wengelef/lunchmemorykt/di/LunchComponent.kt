/*
 * Copyright (c) wengelef 2018
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wengelef.lunchmemorykt.di

import com.wengelef.lunchmemorykt.MainApplication
import com.wengelef.lunchmemorykt.login.LoginFragment
import com.wengelef.lunchmemorykt.memories.MemoriesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LunchModule::class,
    ViewModelModule::class,
    AuthModule::class,
    RestModule::class,
    FirebaseModule::class
])
interface LunchComponent {
    fun inject(application: MainApplication)
    fun inject(memoriesFragment: MemoriesFragment)
    fun inject(loginFragment: LoginFragment)
}