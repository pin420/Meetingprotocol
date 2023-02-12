package com.pinkin.meetingprotocol.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pinkin.businesslogic.UseCase.DeleteProtocolUseCase
import com.pinkin.businesslogic.UseCase.GetProtocolsUseCase
import com.pinkin.businesslogic.UseCase.GetSearchProtocolsUseCase
import com.pinkin.businesslogic.UseCase.SaveProtocolUseCase
import com.pinkin.datasource.Room.Repositories

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val roomRepository by lazy(LazyThreadSafetyMode.NONE) {
        Repositories.roomRepository}

    private val saveProtocolUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveProtocolUseCase(repository = roomRepository) }

    private val getProtocolsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetProtocolsUseCase(repository = roomRepository) }

    private val getSearchProtocolsUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetSearchProtocolsUseCase(repository = roomRepository) }

    private val deleteProtocolUseCase by lazy(LazyThreadSafetyMode.NONE) {
        DeleteProtocolUseCase(repository = roomRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveProtocolUseCase = saveProtocolUseCase,
            getProtocolsUseCase = getProtocolsUseCase,
            deleteProtocolUseCase = deleteProtocolUseCase,
            getSearchProtocolsUseCase = getSearchProtocolsUseCase
        ) as T
    }
}
