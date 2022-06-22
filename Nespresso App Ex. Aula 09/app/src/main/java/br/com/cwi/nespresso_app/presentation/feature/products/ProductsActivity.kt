package br.com.cwi.nespresso_app.presentation.feature.products

import android.content.Intent
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.products.accessorie.AccessoryActivity
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeActivity
import br.com.cwi.nespresso_app.presentation.feature.products.machine.MachineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupProductsActions()
    }

    override val selectedTabId: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation

    private fun setupProductsActions() {
        binding.contentCoffees.root.setOnClickListener {
            startActivity(Intent(this, CoffeeActivity::class.java))
        }

        binding.contentMachines.root.setOnClickListener {
            startActivity(Intent(this, MachineActivity::class.java))
        }

        binding.contentAccessories.root.setOnClickListener {
            startActivity(Intent(this, AccessoryActivity::class.java))
        }
    }
}