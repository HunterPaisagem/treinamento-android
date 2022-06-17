package br.com.cwi.nespresso_app.presentation.products.coffee

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.entity.CapsuleType
import br.com.cwi.nespresso_app.data.repository.CoffeeRepository
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoffeeActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCoffeeBinding

    private val repository = CoffeeRepository()

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
        CoroutineScope(Dispatchers.Main).launch {
            repository.getCapsules().let { categoryList ->
                val capsuleTypeList: MutableList<CapsuleType> = mutableListOf()
                val recyclerView = binding.rvCapsules

                recyclerView.addItemDecoration(
                    DividerItemDecoration(this@CoffeeActivity, DividerItemDecoration.VERTICAL)
                )

                categoryList.forEach {
                    capsuleTypeList.add(it)
                    capsuleTypeList.addAll(it.coffees)
                }

                recyclerView.adapter = CapsulesAdapter(this@CoffeeActivity, capsuleTypeList)
            }
        }
    }
}