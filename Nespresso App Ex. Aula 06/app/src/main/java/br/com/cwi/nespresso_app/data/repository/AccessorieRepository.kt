package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.entity.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccessorieRepository {

    private val api: NespressoApi = RetrofitConfig.service

    suspend fun getAccessories(): List<AccessoryCategoryResponse>{
        return withContext(Dispatchers.IO){
            api.getAccessories()
        }
    }
}
