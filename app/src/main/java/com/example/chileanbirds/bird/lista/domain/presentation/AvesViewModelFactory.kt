package com.example.chileanbirds.bird.lista.domain.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chileanbirds.bird.lista.domain.ObtenerAveUseCase

class AvesViewModelFactory(
    private val aveUseCase : ObtenerAveUseCase
) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerAveUseCase::class.java)
            .newInstance(aveUseCase)
    }


}