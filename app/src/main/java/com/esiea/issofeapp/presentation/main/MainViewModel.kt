package com.esiea.issofeapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.issofeapp.domain.entity.User
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
            val user: User? = getUserUseCase.invoke(emailUser)
            var userPassword: User? = null
            if(user != null){
                userPassword = getUserUseCase.invoke(emailUser, password)
            }
            val loginStatus = if(userPassword != null){
                LoginSuccess(userPassword.email, userPassword.password)
            } else {
                if(user != null){
                    PassError
                }
                else{
                    LoginError
                }
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }


}