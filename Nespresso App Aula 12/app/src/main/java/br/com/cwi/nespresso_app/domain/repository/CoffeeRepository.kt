package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Category
import br.com.cwi.nespresso_app.domain.entity.Coffee

interface CoffeeRepository {
    suspend fun getCapsules(): List<Category>
    suspend fun getCoffeeDetails(id: Int): Coffee
}