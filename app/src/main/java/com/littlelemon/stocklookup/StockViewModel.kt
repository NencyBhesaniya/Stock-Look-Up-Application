package com.littlelemon.stocklookup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.littlelemon.stocklookup.model.Price
import com.littlelemon.stocklookup.network.StockApi
import kotlinx.coroutines.launch

class StockViewModel : ViewModel() {

    private val _stockData = MutableLiveData<List<Price>?>()
    val stockData: LiveData<List<Price>?> = _stockData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    // This method calls the API and fetches stock data
    fun searchStock(symbol: String) {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val response = StockApi.retrofitService.getStockData(symbol)
                _stockData.value = response.prices.take(3) // Display at most 3 entries
            } catch (e: Exception) {
                _error.value = "Error fetching data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
