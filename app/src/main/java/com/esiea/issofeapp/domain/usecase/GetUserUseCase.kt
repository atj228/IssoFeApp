package com.esiea.issofeapp.domain.usecase

import com.esiea.issofeapp.data.repository.UserRepository
import com.esiea.issofeapp.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User?{
        return userRepository.getUser(email)
    }
}