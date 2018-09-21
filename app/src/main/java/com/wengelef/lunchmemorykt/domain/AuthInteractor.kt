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

package com.wengelef.lunchmemorykt.domain

import com.wengelef.lunchmemorykt.data.AuthService

interface AuthInteractor {
    fun isAuthenticated(): Boolean
    fun logout()
}

class AuthInteractorImpl(private val authService: AuthService) : AuthInteractor {
    override fun isAuthenticated(): Boolean {
        return authService.getCurrentUser() != null
    }

    override fun logout() {
        authService.logout()
    }
}