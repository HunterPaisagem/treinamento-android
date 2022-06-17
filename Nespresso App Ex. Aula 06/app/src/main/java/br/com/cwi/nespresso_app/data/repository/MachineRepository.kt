package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.entity.MachineResponse
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MachineRepository() {

    private val api: NespressoApi = RetrofitConfig.service

    suspend fun getMachines(): List<MachineResponse> {
        return withContext(Dispatchers.IO) {
            api.getMachines()
        }
    }

}