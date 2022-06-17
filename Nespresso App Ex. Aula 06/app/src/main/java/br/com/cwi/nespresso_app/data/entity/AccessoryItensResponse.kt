package br.com.cwi.nespresso_app.data.entity

import com.squareup.moshi.Json

data class AccessoryItensResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val name: String,
    @Json(name = "preco") val price: Double,
    @Json(name = "imagem") val image: String,
    @Json(name = "descricao") val description: String?
): AccessoryType(type = 1)
