package br.com.cwi.nespresso_app.presentation.products

import android.content.Intent
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.presentation.products.accessorie.AccessorieActivity
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.products.coffee.CoffeeActivity
import br.com.cwi.nespresso_app.presentation.products.machine.MachineActivity
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
            val intent = Intent(this, CoffeeActivity::class.java)
                .putExtra("EXTRA_MESSAGE", "Ola tudo bem")

            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener {
            val intent = Intent(this, MachineActivity::class.java)

            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener {
            val intent = Intent(this, AccessorieActivity::class.java)

            startActivity(intent)
        }
    }
}