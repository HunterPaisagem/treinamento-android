package br.com.cwi.nespresso_app.presentation.feature.products.accessorie

import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.mapper.AccessoryCategoryMapper
import br.com.cwi.nespresso_app.data.repository.AccessoryRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class AccessoryViewModel: BaseViewModel() {

    private val repository = AccessoryRepositoryImpl(AccessoryCategoryMapper())

    private val _accessory = MutableLiveData<List<Type>>()
    val accessory: MutableLiveData<List<Type>> = _accessory

    fun fetchAccessories() {
        launch {
            repository.getAccessories().let { accessoryList ->
                _accessory.postValue(getAccessoriesTypeList(accessoryList))
            }
        }
    }

    private fun getAccessoriesTypeList(accessoryList: List<Category>): List<Type> {
        val accessoryTypeList: MutableList<Type> = mutableListOf()

        accessoryList.forEach {
            accessoryTypeList.add(it)
            accessoryTypeList.addAll(it.products)
        }

        return accessoryTypeList
    }
}