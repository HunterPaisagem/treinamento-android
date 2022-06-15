package br.com.cwi.nespresso_app.data.entity

import com.squareup.moshi.Json

data class MachinesListResponse(
    @Json(name = "maquinas") val machines: List<MachineResponse>
)