package com.esiea.issofeapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.issofeapp.domain.entity.User
import com.esiea.issofeapp.domain.usecase.CreateUserUseCase
import com.esiea.issofeapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
   private val createUserUseCase: CreateUserUseCase,
   private val getUserUseCase: GetUserUseCase
): ViewModel() {


    val counter: MutableLiveData<Int> = MutableLiveData()
    init {
        counter.value = 0
    }

    fun onClickedLogin(emailUser: String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User(emailUser))
        }
    }
}