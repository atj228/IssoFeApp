package com.esiea.issofeapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.issofeapp.domain.entity.User
import com.esiea.issofeapp.domain.usecase.CreateUserUseCase
import com.esiea.issofeapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val  regLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedReg(usernameUser: String, emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user: User? = getUserUseCase.invoke(emailUser)
            val loginStatus: LoginStatus = if(user != null){
                LoginExist
            }
            else{
                LoginCreate
            }
            if(loginStatus == LoginCreate){
                createUserUseCase.invoke(User(usernameUser,emailUser,password))
            }
            withContext(Dispatchers.Main){
                regLiveData.value = loginStatus
            }
        }
    }
}