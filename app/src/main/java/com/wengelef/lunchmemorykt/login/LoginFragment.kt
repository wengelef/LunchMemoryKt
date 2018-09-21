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
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.wengelef.lunchmemorykt.BaseFragment
import com.wengelef.lunchmemorykt.R
import com.wengelef.lunchmemorykt.di.LunchComponent
import com.wengelef.lunchmemorykt.domain.AuthInteractor
import com.wengelef.lunchmemorykt.domain.LoginResult
import com.wengelef.lunchmemorykt.ext.observe
import com.wengelef.lunchmemorykt.ext.withViewModel
import kotlinx.android.synthetic.main.fr_login.*
import java.util.logging.Logger
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

        Log.e("Tag", "onStart")

        withViewModel<LoginViewModel>(viewModelFactory) {
            observe(authenticationState) { result ->
                when (result) {
                    is LoginResult.Success -> activity?.onBackPressed()
                    is LoginResult.Error -> {} //todo show error
                }
            }

            login_button.setOnClickListener { login(username.text.toString(), pass.text.toString()) }
        }
    }
}

class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    val authenticationState = MutableLiveData<LoginResult>()

    fun login(user: String, pass: String) {
        authInteractor.login(user, pass) { result -> authenticationState.value = result }
    }
}
