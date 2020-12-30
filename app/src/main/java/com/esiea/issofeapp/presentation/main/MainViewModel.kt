package com.esiea.issofeapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.issofeapp.domain.usecase.CreateUserUseCase
import com.esiea.issofeapp.domain.usecase.GetUserUseCase
import com.esiea.issofeapp.presentation.main.LoginError
import com.esiea.issofeapp.presentation.main.LoginStatus
import com.esiea.issofeapp.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
   private val createUserUseCase: CreateUserUseCase,
   private val getUserUseCase: GetUserUseCase
): ViewModel() {


    val  loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }


}