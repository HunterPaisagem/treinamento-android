package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.domain.repository.MachineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MachineRepositoryImpl(
    private val api: NespressoApi,
    private val machineMapper: MachineMapper
): MachineRepository {

    override suspend fun getMachines(): List<Machine> {
        return withContext(Dispatchers.IO) {
            machineMapper.toDomain(api.getMachines())
        }
    }

}