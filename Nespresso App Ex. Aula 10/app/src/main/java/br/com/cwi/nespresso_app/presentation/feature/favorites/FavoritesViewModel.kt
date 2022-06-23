package br.com.cwi.nespresso_app.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.database.mapper.toCoffee
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class FavoritesViewModel(
    private val coffeeLocalRepository: CoffeeLocalRepository
): BaseViewModel() {

    private val _favorites = MutableLiveData<List<Coffee>>()
    val favorites: LiveData<List<Coffee>> = _favorites

    fun fetchFavorites() {
        launch {
            coffeeLocalRepository.getAll().let { favoritesList ->
                _favorites.postValue(favoritesList?.map{ it.toCoffee() })
            }
        }
    }
}