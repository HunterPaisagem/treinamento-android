package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.entity.CategoryAccessoryResponse
import br.com.cwi.nespresso_app.data.entity.CategoryCoffeeResponse
import br.com.cwi.nespresso_app.data.entity.CoffeeResponse
import br.com.cwi.nespresso_app.data.entity.MachineResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NespressoApi {

    @GET("/capsulas")
    suspend fun getCoffees(): List<CategoryCoffeeResponse>

    @GET("/maquinas")
    suspend fun getMachines(): List<MachineResponse>

    @GET("/acessorios")
    suspend fun getAccessories(): List<CategoryAccessoryResponse>

    @GET("/cafes/{id}")
    suspend fun getCoffeeDetails(@Path("id") id: Int): CoffeeResponse
}