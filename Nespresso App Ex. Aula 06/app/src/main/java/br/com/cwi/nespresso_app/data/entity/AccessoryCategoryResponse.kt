package br.com.cwi.nespresso_app.data.entity

import com.squareup.moshi.Json

data class AccessoryCategoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "itens") val itens: List<AccessoryItensResponse>
): AccessoryType(type = 0)