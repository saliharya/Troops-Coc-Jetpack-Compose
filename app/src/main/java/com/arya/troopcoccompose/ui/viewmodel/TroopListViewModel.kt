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
class TroopListViewModel @Inject constructor(
    private val troopRepository: TroopRepository,
) : ViewModel() {

    private val _troops = MutableLiveData<List<Troop>>()
    val troops: LiveData<List<Troop>> get() = _troops

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean> get() = _isEmpty

    private val _favoriteTroops = MutableLiveData<List<Troop>>()
    val favoriteTroops: LiveData<List<Troop>> get() = _favoriteTroops

    fun loadTroops() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val troopsList = withContext(Dispatchers.IO) {
                    troopRepository.getTroops()
                }
                _troops.value = troopsList
                _isEmpty.value = troopsList.isEmpty()
            } catch (e: Exception) {
                e.printStackTrace()
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
                _isEmpty.value = searchResult.isEmpty()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadFavoriteTroops() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val favoriteTroopsList = withContext(Dispatchers.IO) {
                    troopRepository.getFavoriteTroops()
                }
                _favoriteTroops.value = favoriteTroopsList
                _isEmpty.value = favoriteTroopsList.isEmpty()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
