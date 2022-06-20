package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Category

interface CoffeeRepository {
    suspend fun getCapsules(): List<Category>
}