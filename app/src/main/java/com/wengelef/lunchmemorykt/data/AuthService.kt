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

package com.wengelef.lunchmemorykt.data

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

interface AuthService {
    fun getCurrentUser(): User?
    fun logout()
}

class AuthServiceImpl @Inject constructor(private val auth: FirebaseAuth): AuthService {

    override fun getCurrentUser(): User? {
        return auth.currentUser?.let { user -> User(user.email!!) }
    }

    override fun logout() {
        auth.signOut()
    }
}

data class User(val mail: String)