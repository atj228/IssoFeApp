package com.esiea.issofeapp.data.repository

import com.esiea.issofeapp.data.local.DatabaseDao
import com.esiea.issofeapp.data.local.models.toData
import com.esiea.issofeapp.data.local.models.toEntity
import com.esiea.issofeapp.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String): User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}