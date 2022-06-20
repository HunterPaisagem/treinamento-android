package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Category

interface AccessoryRepository {
    suspend fun getAccessories(): List<Category>
}