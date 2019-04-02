package com.martin.kotlincleanarchitecture.viewmodel

import com.martin.kotlincleanarchitecture.models.Graph
import com.martin.kotlincleanarchitecture.repository.Repository


class MainActivityViewModel(private val repository: Repository) {

    suspend fun showDataFromApi(): Graph = repository.getDataFromApi().await()
}