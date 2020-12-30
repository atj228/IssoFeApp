package com.esiea.issofeapp.presentation.main
sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String) : LoginStatus()
object LoginError : LoginStatus()
object PassError : LoginStatus()
object LoginCreate : LoginStatus()
object LoginExist : LoginStatus()
