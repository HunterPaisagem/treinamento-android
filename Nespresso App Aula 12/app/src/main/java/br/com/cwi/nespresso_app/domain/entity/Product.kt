package br.com.cwi.nespresso_app.domain.entity

abstract class Product(
    val id: Int,
    val name: String,
    val urlImage: String?,
    val unitPrice: Double,
    val productType: ProductType
): Type(ItemType.PRODUCT)