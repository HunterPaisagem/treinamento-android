package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.AccessoryResponse
import br.com.cwi.nespresso_app.domain.entity.Accessory

class AccessoryMapper: DomainMapper<AccessoryResponse, Accessory> {

    override fun toDomain(from: AccessoryResponse) = Accessory(
        id = from.id,
        name = from.name,
        urlImage = from.image,
        unitPrice = from.price,
        description = from.description
    )

    override fun toDomain(from: List<AccessoryResponse>): List<Accessory> = from.map {
        toDomain(it)
    }

}