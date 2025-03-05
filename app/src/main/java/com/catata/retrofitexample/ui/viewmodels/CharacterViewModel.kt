package com.catata.retrofitexample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catata.retrofitexample.datasource.RetrofitServiceFactory
import com.catata.retrofitexample.datasource.model.CharacterInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharacterViewModel() : ViewModel() {

    // List of characters
    private val _characters = MutableLiveData<List<CharacterInfo>>()
    val characters: LiveData<List<CharacterInfo>> = _characters

    // Variable to indicate that data is being fetched from the API
    private var _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    // Variable to indicate if an error occurred in the API request
    private var _responseError = MutableLiveData<Boolean>(false)
    val responseError: LiveData<Boolean> = _responseError

    fun loadCharacterList(searchedCharacter: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue( true)
            delay(2000) // Delay time to display the ProgressIndicator
            val service = RetrofitServiceFactory.getRetrofit()
            try {
                val searchResults = service.getCharactersByName(searchedCharacter)
                _characters.postValue(searchResults.characters)
                _responseError.postValue( false)
            } catch (e: Exception) {
                _responseError.postValue( true)
            }
            _isLoading.postValue( false)
        }
    }
}