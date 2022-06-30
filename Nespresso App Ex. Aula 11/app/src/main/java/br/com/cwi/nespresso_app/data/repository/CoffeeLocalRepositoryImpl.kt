package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.database.AppDatabase
import br.com.cwi.nespresso_app.data.database.entity.CoffeeEntity
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository

class CoffeeLocalRepositoryImpl(
    appDatabase: AppDatabase
): CoffeeLocalRepository {
    private val dao = appDatabase.getCoffeeDao()

    override fun saveToFavorites(coffeeEntity: CoffeeEntity){
        dao.add(coffeeEntity)
    }

    override fun add(coffeeEntity: CoffeeEntity) {
        dao.add(coffeeEntity)
    }

    override fun remove(coffeeEntity: CoffeeEntity) {
        dao.delete(coffeeEntity)
    }

    override fun getAll(): List<CoffeeEntity>? = dao.getAll()
}