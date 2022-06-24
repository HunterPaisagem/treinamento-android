package br.com.cwi.nespresso_app.presentation.base

import android.os.Bundle
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.databinding.ViewLoadingBinding
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone

abstract class BaseActivity: BaseBottomNavigation() {

    override fun onResume() {
        super.onResume()

        setupViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    abstract fun getViewModel(): BaseViewModel

    abstract fun getErrorBinding(): ViewErrorBinding

    abstract fun getLoadingBinding(): ViewLoadingBinding

    private fun setupViewModel() {
        getViewModel().loading.observe(this) { isLoading ->
            getLoadingBinding().root.visibleOrGone(isLoading)
        }

        getViewModel().error.observe(this) { hasError ->
            getErrorBinding().root.visibleOrGone(hasError)
            getErrorBinding().buttonError.setOnClickListener {
                finish()
                startActivity(intent)
            }
        }
    }
}