package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.mapper.CoffeeCategoryMapper
import br.com.cwi.nespresso_app.data.mapper.CoffeeMapper
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoffeeRepositoryImpl(
    private val api: NespressoApi,
    private val coffeeCategoryMapper: CoffeeCategoryMapper,
    private val coffeeMapper: CoffeeMapper
): CoffeeRepository {

    override suspend fun getCapsules(): List<Category> {
        return withContext(Dispatchers.IO) {
            coffeeCategoryMapper.toDomain(api.getCoffees())
        }
    }

    override suspend fun getCoffeeDetails(id: Int): Coffee {
        return withContext(Dispatchers.IO) {
            coffeeMapper.toDomain(api.getCoffeeDetails(id))
        }
    }
}