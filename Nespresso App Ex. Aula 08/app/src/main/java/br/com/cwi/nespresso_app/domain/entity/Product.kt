package br.com.cwi.nespresso_app.domain.entity

abstract class Product(
    val id: Int,
    val name: String,
    val urlImage: String?,
    val unitPrice: Double
): Type(ItemType.PRODUCT)