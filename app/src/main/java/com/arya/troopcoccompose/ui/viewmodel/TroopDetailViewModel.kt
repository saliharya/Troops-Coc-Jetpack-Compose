package com.arya.troopcoccompose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arya.troopcoccompose.model.Troop
import com.arya.troopcoccompose.repository.TroopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TroopDetailViewModel @Inject constructor(
    private val troopRepository: TroopRepository,
) : ViewModel() {

    private val _troop = MutableLiveData<Troop>()
    val troop: LiveData<Troop> get() = _troop

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun setInitialTroop(troop: Troop) {
        viewModelScope.launch {
            val isFavorite = troopRepository.checkIsFavoriteById(troop.id)
            _isFavorite.postValue(isFavorite)
            _troop.postValue(troop)
        }
    }

    fun toggleFavoriteUser() {
        viewModelScope.launch {
            troop.value?.let { troop ->
                val isFavorite = isFavorite.value == true
                if (isFavorite) troopRepository.deleteFromFavorite(troop)
                else troopRepository.insertToFavorite(troop)

                _isFavorite.postValue(!isFavorite)
            }
        }
    }
}
