package com.esiea.issofeapp.injection

import com.esiea.issofeapp.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}