package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.database.AppDatabase
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.network.mapper.AccessoryCategoryMapper
import br.com.cwi.nespresso_app.data.network.mapper.CoffeeCategoryMapper
import br.com.cwi.nespresso_app.data.network.mapper.CoffeeMapper
import br.com.cwi.nespresso_app.data.network.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.repository.AccessoryRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.CoffeeLocalRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.MachineRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.AccessoryRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.domain.repository.MachineRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CoffeeCategoryMapper() }
    single { CoffeeMapper() }
    single { AccessoryCategoryMapper() }
    single { MachineMapper() }
    single { AppDatabase.create(androidApplication()) }

    factory<CoffeeRepository> { CoffeeRepositoryImpl(get(), get(), get()) }
    factory<AccessoryRepository> { AccessoryRepositoryImpl(get(), get()) }
    factory<MachineRepository> { MachineRepositoryImpl(get(), get()) }
    factory<CoffeeLocalRepository> { CoffeeLocalRepositoryImpl(get()) }
}