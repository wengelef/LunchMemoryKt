package com.wengelef.lunchmemorykt.memories

import androidx.lifecycle.ViewModel
import com.wengelef.lunchmemorykt.SingleLiveEvent
import com.wengelef.lunchmemorykt.domain.AuthInteractor
import javax.inject.Inject

class MemoriesViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {

    val isAuthenticated = SingleLiveEvent<Boolean>()

    fun authenticate() {
        isAuthenticated.value = authInteractor.isAuthenticated()
    }

    fun logout() {
        authInteractor.logout()
        isAuthenticated.value = false
    }
}
