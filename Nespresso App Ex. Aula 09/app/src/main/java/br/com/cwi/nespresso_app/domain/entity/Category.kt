package br.com.cwi.nespresso_app.domain.entity

class Category(
    var category: String,
    var products: List<Product>
): Type(ItemType.CATEGORY)