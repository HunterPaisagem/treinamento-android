package br.com.cwi.nespresso_app.presentation.products.accessorie

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.mapper.AccessoryCategoryMapper
import br.com.cwi.nespresso_app.data.repository.AccessoryRepositoryImpl
import br.com.cwi.nespresso_app.databinding.ActivityAccessorieBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccessoryActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityAccessorieBinding

    private val repository = AccessoryRepositoryImpl(
        AccessoryCategoryMapper()
    )

    override val selectedTabId: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.accessoriesBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessorieBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupAccessoriesList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAccessoriesList() {
        CoroutineScope(Dispatchers.Main).launch {
            repository.getAccessories().let { accessoryList ->
                val accessoryTypeList: MutableList<Type> = mutableListOf()
                val recyclerView = binding.rvAccessories

                recyclerView.addItemDecoration(
                    DividerItemDecoration(this@AccessoryActivity, DividerItemDecoration.VERTICAL)
                )

                accessoryList.forEach {
                    accessoryTypeList.add(it)
                    accessoryTypeList.addAll(it.products)
                }

                recyclerView.adapter = AccessorieAdapter(this@AccessoryActivity, accessoryTypeList)
            }
        }
    }
}