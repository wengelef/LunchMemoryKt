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

package com.wengelef.lunchmemorykt.memories

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.wengelef.lunchmemorykt.BaseFragment
import com.wengelef.lunchmemorykt.di.LunchComponent
import com.wengelef.lunchmemorykt.ext.observe
import com.wengelef.lunchmemorykt.ext.withViewModel
import com.wengelef.lunchmemorykt.R
import kotlinx.android.synthetic.main.fr_memories.*
import javax.inject.Inject

class MemoriesFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_memories, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent<LunchComponent>().inject(this)
    }

    override fun onStart() {
        super.onStart()

        withViewModel<MemoriesViewModel>(viewModelFactory) {
            observe(isAuthenticated) { isAuthenticated ->
                when (isAuthenticated) {
                    null, false -> findNavController().navigate(R.id.action_memoriesfragment_to_signupfragment)
                }
            }

            authenticate()

            logout_button.setOnClickListener { logout() }
        }
    }
}