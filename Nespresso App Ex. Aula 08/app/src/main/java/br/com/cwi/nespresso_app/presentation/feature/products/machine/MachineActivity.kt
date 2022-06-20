package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityMachineBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MachineActivity : BaseActivity() {

    private lateinit var binding: ActivityMachineBinding

    override val selectedTabId: Int = R.id.products_menu

    private val viewModel = MachineViewModel()

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    override fun getBottomNavigation(): BottomNavigationView =
        binding.machineBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.machines.observe(this@MachineActivity) { list ->
            val recyclerView = binding.rvMachines

            recyclerView.adapter = MachineAdapter(this@MachineActivity, list)
        }

        viewModel.fetchMachines()
    }
}