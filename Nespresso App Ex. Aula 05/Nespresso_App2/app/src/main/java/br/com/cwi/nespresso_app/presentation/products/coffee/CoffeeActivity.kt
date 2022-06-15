package br.com.cwi.nespresso_app.presentation.products.coffee

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.entity.CapsuleType
import br.com.cwi.nespresso_app.data.repository.CoffeeRepository
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class CoffeeActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCoffeeBinding

    private val repository = CoffeeRepository(this)

    override val selectedTabId: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.coffeeBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupCapsulesList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupCapsulesList() {
        repository.getCapsules()?.capsules?.let { categoryList ->
            val capsuleTypeList: MutableList<CapsuleType> = mutableListOf()

            categoryList.forEach {
                capsuleTypeList.add(it)
                capsuleTypeList.addAll(it.coffees)
            }

            binding.rvCapsules.adapter = CapsulesAdapter(capsuleTypeList)
        }
    }
}