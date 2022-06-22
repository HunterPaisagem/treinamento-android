package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.details.CoffeeDetailsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoffeeActivity : BaseActivity() {

    private lateinit var binding: ActivityCoffeeBinding

    private val viewModel: CoffeeViewModel by viewModel()

    override val selectedTabId: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupViewModel()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.coffeeBottomNavigation.bottomNavigation

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    private fun setupViewModel() {
        viewModel.coffees.observe(this@CoffeeActivity) { list ->
            val recyclerView = binding.rvCapsules

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@CoffeeActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = CapsulesAdapter(this@CoffeeActivity, list) { id ->
                startActivity(Intent(this@CoffeeActivity, CoffeeDetailsActivity::class.java)
                    .putExtra("id", id))
            }
        }

        viewModel.fetchCoffees()
    }
}