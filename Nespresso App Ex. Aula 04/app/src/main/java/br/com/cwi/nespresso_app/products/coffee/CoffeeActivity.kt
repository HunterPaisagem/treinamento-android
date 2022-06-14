package br.com.cwi.nespresso_app.products.coffee

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R

class CoffeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        val message = intent.getStringExtra("EXTRA_MESSAGE")

        AlertDialog.Builder(this)
            .setMessage(message)
            .setTitle("Click maquinas")
            .show()
    }
}