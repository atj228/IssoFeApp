package com.esiea.issofeapp.domain.usecase

import com.esiea.issofeapp.data.repository.UserRepository
import com.esiea.issofeapp.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}