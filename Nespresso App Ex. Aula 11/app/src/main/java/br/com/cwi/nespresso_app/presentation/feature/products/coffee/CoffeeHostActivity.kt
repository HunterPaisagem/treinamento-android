package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityHostCoffeeBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoffeeHostActivity : BaseActivity() {

    private val viewModel: CoffeeViewModel by viewModel()

    private lateinit var binding: ActivityHostCoffeeBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostContainer.id) as NavHostFragment)
            .findNavController()
    }

    override val selectedTabId: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHostCoffeeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupViewModel()
        setupNavController()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    override fun getBottomNavigation(): BottomNavigationView = binding.coffeeBottomNavigation.bottomNavigation

    private fun setupViewModel() {
        viewModel.fetchCoffees()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.coffeeDetailsFragment ->
                    binding.coffeeBottomNavigation.bottomNavigation.visibleOrGone(false)
                R.id.coffeeFragment -> {
                    binding.coffeeBottomNavigation.bottomNavigation.visibleOrGone(true)
                    supportActionBar?.title = getString(R.string.txt_coffees)
                }
            }
        }
    }
}