package com.esiea.issofeapp.injection

import android.content.Context
import androidx.room.Room
import com.esiea.issofeapp.data.local.AppDatabase
import com.esiea.issofeapp.data.local.DatabaseDao
import com.esiea.issofeapp.data.repository.UserRepository
import com.esiea.issofeapp.domain.usecase.CreateUserUseCase
import com.esiea.issofeapp.domain.usecase.GetUserUseCase
import com.esiea.issofeapp.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

