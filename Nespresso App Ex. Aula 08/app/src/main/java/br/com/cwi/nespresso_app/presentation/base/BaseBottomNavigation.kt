package br.com.cwi.nespresso_app.presentation.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.feature.bag.BagActivity
import br.com.cwi.nespresso_app.presentation.feature.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.presentation.feature.products.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation: AppCompatActivity() {

    abstract val selectedTabId: Int

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0 ,0)
    }

    override fun onResume() {
        super.onResume()

        setupBottomNavigation()
        getBottomNavigation().selectedItemId = selectedTabId
    }

    abstract fun getBottomNavigation(): BottomNavigationView

    private fun setupBottomNavigation() {
        getBottomNavigation().selectedItemId = selectedTabId

        getBottomNavigation().setOnItemSelectedListener  {
            if(it.itemId != selectedTabId) when(it.itemId) {
                R.id.products_menu -> {
                    startActivity(Intent(this, ProductsActivity::class.java))
                }

                R.id.bag_menu -> {
                    startActivity(Intent(this, BagActivity::class.java))
                }

                R.id.favorites_menu -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                }
            }

            return@setOnItemSelectedListener  true
        }
    }
}