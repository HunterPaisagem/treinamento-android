package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.mapper.AccessoryCategoryMapper
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.repository.AccessoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccessoryRepositoryImpl(
    private val accessoryMapper: AccessoryCategoryMapper
): AccessoryRepository {

    private val api: NespressoApi = RetrofitConfig.service

    override suspend fun getAccessories(): List<Category>{
        return withContext(Dispatchers.IO){
            accessoryMapper.toDomain(api.getAccessories())
        }
    }
}
