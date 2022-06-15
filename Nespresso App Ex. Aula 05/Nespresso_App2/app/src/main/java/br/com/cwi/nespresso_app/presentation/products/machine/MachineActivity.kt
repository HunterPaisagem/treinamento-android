package br.com.cwi.nespresso_app.presentation.products.machine

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.repository.MachineRepository
import br.com.cwi.nespresso_app.databinding.ActivityMachineBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MachineActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityMachineBinding

    private val repository = MachineRepository(this)

    override val selectedTabId: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView =
        binding.machineBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupMachinesList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setupMachinesList() {
        repository.getMachines()?.machines?.let { machine ->
            binding.rvMachines.adapter = MachineAdapter(machine)
        }
    }
}