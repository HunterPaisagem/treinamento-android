package br.com.cwi.nespresso_app.domain.entity

enum class ProductType(val value: String) {
    MACHINE(value = "Máquina"),
    COFFEE(value = "Café"),
    ACCESSORY(value = "Acessório")
}
