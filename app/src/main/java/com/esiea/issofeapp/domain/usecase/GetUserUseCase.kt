package com.esiea.issofeapp.domain.usecase

import com.esiea.issofeapp.data.repository.UserRepository
import com.esiea.issofeapp.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User?{
        return userRepository.getUser(email)
    }

    suspend fun invoke(email: String, password: String) : User? {
        return userRepository.getUserMailAndPass(email,password)
    }

    suspend fun invoke(username:String, email: String, password: String) : User? {
        return userRepository.getUserReg(username,email,password)
    }
}