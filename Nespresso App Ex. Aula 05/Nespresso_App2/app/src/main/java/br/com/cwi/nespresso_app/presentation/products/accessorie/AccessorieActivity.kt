package br.com.cwi.nespresso_app.presentation.products.accessorie

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityAccessorieBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccessorieActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityAccessorieBinding

    override val selectedTabId: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.accessoriesBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessorieBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}