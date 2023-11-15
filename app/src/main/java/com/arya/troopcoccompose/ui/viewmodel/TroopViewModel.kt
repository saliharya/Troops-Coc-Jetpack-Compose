package com.arya.troopcoccompose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.repository.TroopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TroopViewModel @Inject constructor(
    private val troopRepository: TroopRepository,
) : ViewModel() {

    private val _troops = MutableLiveData<List<Troop>>()
    val troops: LiveData<List<Troop>> get() = _troops

    private val _troop = MutableLiveData<Troop>()
    val troop: LiveData<Troop> get() = _troop

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean> get() = _isEmpty

    init {
        loadTroops()
    }

    private fun loadTroops() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val troopsList = withContext(Dispatchers.IO) {
                    troopRepository.getTroops()
                }
                _troops.value = troopsList
            } catch (e: Exception) {
                e.stackTrace
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchTroops(query: String) {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val searchResult = withContext(Dispatchers.IO) {
                    troopRepository.searchTroops(query)
                }
                _troops.value = searchResult
            } catch (e: Exception) {
                e.stackTrace
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun toggleFavoriteUser() {
        viewModelScope.launch {
            troop.value?.let { troop ->
                if (troop.isFavorite) troopRepository.deleteFromFavorite(troop)
                else troopRepository.insertToFavorite(troop)

                troop.isFavorite = !troop.isFavorite

                _troop.postValue(troop)
            }
        }
    }
}