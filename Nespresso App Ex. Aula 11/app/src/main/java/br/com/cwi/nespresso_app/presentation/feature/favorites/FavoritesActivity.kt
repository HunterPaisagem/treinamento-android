package br.com.cwi.nespresso_app.presentation.feature.favorites

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityFavoritesBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.base.BaseActivity
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesActivity : BaseActivity() {

    private lateinit var binding: ActivityFavoritesBinding

    private val viewModel: FavoritesViewModel by viewModel()

    override val selectedTabId: Int = R.id.favorites_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupViewModel()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getErrorBinding(): ViewErrorBinding = binding.viewError

    override fun getLoadingBinding(): ViewLoadingBinding = binding.viewLoading

    private fun setupViewModel() {
        viewModel.favorites.observe(this@FavoritesActivity) { list ->
            val recyclerView = binding.rvFavorites

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@FavoritesActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = FavoritesAdapter(this@FavoritesActivity, list)
        }

        viewModel.fetchFavorites()
    }
}