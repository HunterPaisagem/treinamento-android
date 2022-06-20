package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.mapper.CoffeeCategoryMapper
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoffeeRepositoryImpl(
    private val coffeeMapper: CoffeeCategoryMapper
): CoffeeRepository {

    private val api: NespressoApi = RetrofitConfig.service

    override suspend fun getCapsules(): List<Category> {
        return withContext(Dispatchers.IO) {
            coffeeMapper.toDomain(api.getCoffees())
        }
    }
}