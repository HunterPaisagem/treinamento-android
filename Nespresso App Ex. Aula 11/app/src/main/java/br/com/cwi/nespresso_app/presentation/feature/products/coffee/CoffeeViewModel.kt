package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.database.mapper.toEntity
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class CoffeeViewModel(
    private val repository: CoffeeRepository,
    private val coffeeLocalRepository: CoffeeLocalRepository
): BaseViewModel() {

    private val _coffees = MutableLiveData<List<Type>>()
    val coffees: LiveData<List<Type>> = _coffees

    private val _coffee = MutableLiveData<Coffee>()
    val coffee: LiveData<Coffee> = _coffee

    fun fetchCoffees() {
        launch {
            repository.getCapsules().let { categoryList ->
                _coffees.postValue(getCoffeesType(categoryList))
            }
        }
    }

    fun fetchCoffeeDetail(id: Int){
        launch {
            repository.getCoffeeDetails(id).let { coffee ->
                _coffee.postValue(coffee)
            }
        }
    }

    private fun getCoffeesType(categoryList: List<Category>): List<Type> {
        val capsuleTypeList: MutableList<Type> = mutableListOf()
        val favoritesList = coffeeLocalRepository.getAll()?.takeIf { it.isNotEmpty() }

        categoryList.forEach { category ->
            capsuleTypeList.add(category)
            favoritesList?.let { favoritedCoffes ->
                val favoritesIdList = favoritedCoffes.map { it.id }
                val productsList = category.products.map { it as Coffee }

                setIsCoffeeFavorite(favoritesIdList, productsList)
            }
            capsuleTypeList.addAll(category.products)
        }

        return capsuleTypeList
    }

    private fun setIsCoffeeFavorite(favoriteList: List<Int>, coffeeList: List<Coffee>) {
        coffeeList.forEach {
            it.isFavorite = favoriteList.contains(it.id)
        }
    }

    fun setFavorite(coffee: Coffee) {
        if(coffee.isFavorite) coffeeLocalRepository.add(coffee.toEntity())
        else coffeeLocalRepository.remove(coffee.toEntity())
    }
}