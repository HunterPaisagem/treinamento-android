package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.entity.CategoryResponse
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoffeeRepository {

    private val api: NespressoApi = RetrofitConfig.service

    suspend fun getCapsules(): List<CategoryResponse> {
        return withContext(Dispatchers.IO) {
            api.getCoffees()
        }
    }
}