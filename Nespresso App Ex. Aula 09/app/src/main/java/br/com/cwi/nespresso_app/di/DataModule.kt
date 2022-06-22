package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.mapper.AccessoryCategoryMapper
import br.com.cwi.nespresso_app.data.mapper.CoffeeCategoryMapper
import br.com.cwi.nespresso_app.data.mapper.CoffeeMapper
import br.com.cwi.nespresso_app.data.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.repository.AccessoryRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.MachineRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.AccessoryRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.domain.repository.MachineRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CoffeeCategoryMapper() }
    single { CoffeeMapper() }
    single { AccessoryCategoryMapper() }
    single { MachineMapper() }

    factory<CoffeeRepository> { CoffeeRepositoryImpl(get(), get(), get()) }
    factory<AccessoryRepository> { AccessoryRepositoryImpl(get(), get()) }
    factory<MachineRepository> { MachineRepositoryImpl(get(), get()) }
}