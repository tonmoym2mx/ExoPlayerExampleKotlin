package com.tonmoy.gakk.player.di

import com.tonmoy.gakk.player.data.remote.VideoApis
import com.tonmoy.gakk.player.data.repository.VideoRepository
import com.tonmoy.gakk.player.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { VideoApis() }
    factory { VideoRepository(get()) }
}


val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}