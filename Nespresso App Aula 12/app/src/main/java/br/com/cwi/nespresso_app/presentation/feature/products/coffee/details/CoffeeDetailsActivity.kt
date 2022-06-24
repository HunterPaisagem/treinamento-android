package br.com.cwi.nespresso_app.presentation.feature.products.coffee.details

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeDetailsBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoffeeDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityCoffeeDetailsBinding

    private val viewModel: CoffeeDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupDetails()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    override val selectedTabId: Int = 0

    override fun getBottomNavigation(): BottomNavigationView? = null

    private fun setupDetails() {
        val coffeeId: Int = intent.getIntExtra("id", -1)

        viewModel.coffee.observe(this@CoffeeDetailsActivity){ coffee ->
            val recyclerView = binding.rvDegustationNames

            binding.coffeeDetails.tvCoffeeName.text = coffee.name
            binding.coffeeDetails.tvCoffeeOriginDescription.text = coffee.origin
            binding.coffeeDetails.tvCoffeeRoastingDescription.text = coffee.roasting
            binding.coffeeDetails.tvCoffeeAromaDescription.text = coffee.aroma
            binding.coffeeImageInfo.tvCapsulePrice.text = coffee.unitPrice.toMoneyFormat()
            binding.coffeeImageInfo.tvCoffeeIntensity.text = getString(R.string.intensity, coffee.intensity)

            Glide.with(this)
                .load(coffee.urlImage)
                .into(binding.coffeeImageInfo.ivCoffeeImage)

            recyclerView.adapter = CoffeeDetailsAdapter(this@CoffeeDetailsActivity, coffee.measures)
        }

        viewModel.fetchCoffeeDetail(coffeeId)
    }

}