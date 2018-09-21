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

package com.wengelef.lunchmemorykt.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wengelef.lunchmemorykt.BaseFragment
import com.wengelef.lunchmemorykt.R
import com.wengelef.lunchmemorykt.di.LunchComponent
import com.wengelef.lunchmemorykt.domain.AuthInteractor
import com.wengelef.lunchmemorykt.ext.withViewModel
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_login, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent<LunchComponent>().inject(this)
    }

    override fun onStart() {
        super.onStart()

        withViewModel<LoginViewModel>(viewModelFactory) {

        }
    }
}

class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel()
