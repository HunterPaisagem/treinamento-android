package br.com.cwi.nespresso_app.presentation.feature.products.accessorie

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityAccessorieBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccessoryActivity : BaseActivity() {

    private lateinit var binding: ActivityAccessorieBinding

    override val selectedTabId: Int = R.id.products_menu

    private val viewModel = AccessoryViewModel()

    override fun getBottomNavigation(): BottomNavigationView = binding.accessoriesBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessorieBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupAccessoriesList()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    private fun setupAccessoriesList() {
        viewModel.accessory.observe(this@AccessoryActivity) { list ->
            val recyclerView = binding.rvAccessories

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@AccessoryActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = AccessorieAdapter(this@AccessoryActivity, list)
        }

        viewModel.fetchAccessories()
    }
}