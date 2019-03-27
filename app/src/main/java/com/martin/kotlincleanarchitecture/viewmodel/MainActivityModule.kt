package com.martin.kotlincleanarchitecture.viewmodel

import com.martin.kotlincleanarchitecture.repository.Repository
import com.martin.kotlincleanarchitecture.util.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)
}