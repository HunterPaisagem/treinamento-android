package br.com.cwi.nespresso_app.domain.entity

class Coffee(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    var description: String,
    var intensity: Int?,
    var measures: List<String>,
    var origin: String?,
    var roasting: String?,
    var aroma: String?,
    var isFavorite: Boolean = false
): Product(id, name, urlImage, unitPrice, productType = ProductType.COFFEE)