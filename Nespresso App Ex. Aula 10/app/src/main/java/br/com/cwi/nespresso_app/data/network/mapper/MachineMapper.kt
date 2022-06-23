package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.MachineResponse
import br.com.cwi.nespresso_app.domain.entity.Machine

class MachineMapper: DomainMapper<MachineResponse, Machine> {
    override fun toDomain(from: MachineResponse) = Machine(
        id = from.id,
        name = from.name,
        unitPrice = from.price,
        description = from.description,
        urlImage = from.image
    )

    override fun toDomain(from: List<MachineResponse>) = from.map {
        toDomain(it)
    }
}