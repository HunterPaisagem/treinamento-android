package br.com.cwi.nespresso_app.data.repository

import android.content.Context
import br.com.cwi.nespresso_app.data.entity.CapsuleResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class CoffeeRepository(private val context: Context) {

    private val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

    fun getCapsules(): CapsuleResponse? {
        val jsonCapsules = getJsonFromFile("nespresso-capsulas.json")
        val jsonAdapter: JsonAdapter<CapsuleResponse> = moshi.adapter(CapsuleResponse::class.java)

        return jsonAdapter.fromJson(jsonCapsules)
    }

    private fun getJsonFromFile(filePath: String) = context.assets.open(filePath).bufferedReader().readText()
}