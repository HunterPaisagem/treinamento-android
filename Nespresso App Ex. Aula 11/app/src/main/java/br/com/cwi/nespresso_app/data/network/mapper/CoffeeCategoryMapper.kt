package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.CategoryCoffeeResponse
import br.com.cwi.nespresso_app.domain.entity.Category

class CoffeeCategoryMapper: DomainMapper<CategoryCoffeeResponse, Category> {

    override fun toDomain(from: CategoryCoffeeResponse) = Category(
        category = from.category,
        products = CoffeeMapper().toDomain(from.coffees)
    )

    override fun toDomain(from: List<CategoryCoffeeResponse>) = from.map {
        toDomain(it)
    }
}