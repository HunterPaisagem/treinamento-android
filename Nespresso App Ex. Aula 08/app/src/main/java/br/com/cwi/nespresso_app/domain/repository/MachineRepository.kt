package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Machine

interface MachineRepository {
    suspend fun getMachines(): List<Machine>
}