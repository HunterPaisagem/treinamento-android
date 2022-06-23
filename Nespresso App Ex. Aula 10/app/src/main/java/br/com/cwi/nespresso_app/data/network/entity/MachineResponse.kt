package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

data class MachineResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val name: String,
    @Json(name = "preco") val price: Double,
    @Json(name = "descricao") val description: String,
    @Json(name = "imagem") val image: String
)