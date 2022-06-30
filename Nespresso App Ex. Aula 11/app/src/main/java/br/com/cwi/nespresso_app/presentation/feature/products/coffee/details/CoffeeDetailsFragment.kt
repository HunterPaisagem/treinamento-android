package br.com.cwi.nespresso_app.presentation.feature.products.coffee.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.FragmentCoffeeDetailsBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeHostActivity
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeViewModel
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

const val COFFEE_ID = "COFFEE_ID"

class CoffeeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeDetailsBinding

    private val viewModel: CoffeeViewModel by sharedViewModel()

    private val coffeeId by lazy {
        arguments?.getInt(COFFEE_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCoffeeDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.coffee.observe(viewLifecycleOwner){ coffee ->
            val recyclerView = binding.rvDegustationNames
            bindCoffee(coffee)
            (activity as CoffeeHostActivity).supportActionBar?.title = coffee.name
            recyclerView.adapter = CoffeeDetailsAdapter(coffee.measures)
        }

        viewModel.fetchCoffeeDetail(coffeeId!!)
    }

    private fun bindCoffee(coffee: Coffee) {
        binding.coffeeDetails.tvCoffeeName.text = coffee.name
        binding.coffeeDetails.tvCoffeeOriginDescription.text = coffee.origin
        binding.coffeeDetails.tvCoffeeRoastingDescription.text = coffee.roasting
        binding.coffeeDetails.tvCoffeeAromaDescription.text = coffee.aroma
        binding.coffeeImageInfo.tvCapsulePrice.text = coffee.unitPrice.toMoneyFormat()
        binding.coffeeImageInfo.tvCoffeeIntensity.text = getString(R.string.intensity, coffee.intensity)

        Glide.with(this)
            .load(coffee.urlImage)
            .into(binding.coffeeImageInfo.ivCoffeeImage)
    }
}