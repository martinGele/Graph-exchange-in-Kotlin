package com.martin.kotlincleanarchitecture.dependency

import com.martin.kotlincleanarchitecture.MainActivity
import com.martin.kotlincleanarchitecture.viewmodel.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}
