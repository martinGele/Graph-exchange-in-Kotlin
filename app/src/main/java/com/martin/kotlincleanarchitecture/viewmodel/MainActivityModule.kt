package com.martin.kotlincleanarchitecture.viewmodel

import com.martin.kotlincleanarchitecture.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository) = MainActivityViewModel(repository)
}