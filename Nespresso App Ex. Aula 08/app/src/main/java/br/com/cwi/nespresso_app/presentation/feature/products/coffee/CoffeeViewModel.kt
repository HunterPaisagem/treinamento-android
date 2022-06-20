package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.mapper.CoffeeCategoryMapper
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class CoffeeViewModel: BaseViewModel() {

    private val _coffees = MutableLiveData<List<Type>>()
    val coffees: LiveData<List<Type>> = _coffees

    private val repository: CoffeeRepository =  CoffeeRepositoryImpl(CoffeeCategoryMapper())

    fun fetchCoffees() {
        launch {
            repository.getCapsules().let { categoryList ->
                _coffees.postValue(getCoffeesType(categoryList))
            }
        }
    }

    private fun getCoffeesType(categoryList: List<Category>): List<Type> {
        val capsuleTypeList: MutableList<Type> = mutableListOf()

        categoryList.forEach {
            capsuleTypeList.add(it)
            capsuleTypeList.addAll(it.products)
        }

        return capsuleTypeList
    }

}