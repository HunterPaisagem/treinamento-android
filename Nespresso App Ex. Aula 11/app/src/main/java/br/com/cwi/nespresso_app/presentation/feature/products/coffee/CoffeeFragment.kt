package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.FragmentCoffeeBinding
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.details.COFFEE_ID
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CoffeeFragment : Fragment() {

    private val viewModel: CoffeeViewModel by sharedViewModel()

    private lateinit var binding: FragmentCoffeeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCoffeeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.coffees.observe(viewLifecycleOwner) { list ->
            val recyclerView = binding.rvCapsules

            recyclerView.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = CapsulesAdapter(
                list,
                onCoffeeClick = { coffeeId ->
                    navigateToCoffeeDetail(coffeeId)
                },
                onFavoriteClick = { coffee ->
                    viewModel.setFavorite(coffee)
                })
        }
    }

    private fun navigateToCoffeeDetail(id: Int) {
        findNavController().navigate(
            R.id.coffeeDetailsFragment,
            bundleOf(Pair(COFFEE_ID, id))
        )
    }
}