package br.com.cwi.nespresso_app.presentation.feature.products.coffee.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class CoffeeDetailsViewModel(
    private val repository: CoffeeRepository
): BaseViewModel() {

    private val _coffee = MutableLiveData<Coffee>()
    val coffee: LiveData<Coffee> = _coffee

    fun fetchCoffeeDetail(id: Int){
        launch {
            repository.getCoffeeDetails(id).let { coffee ->
                _coffee.postValue(coffee)
            }
        }
    }
}