package br.com.cwi.nespresso_app.domain.entity

class Machine(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    var description: String
): Product(id, name, urlImage, unitPrice)