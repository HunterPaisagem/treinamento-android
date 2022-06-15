package br.com.cwi.nespresso_app.data.repository

import android.content.Context
import br.com.cwi.nespresso_app.data.entity.MachinesListResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MachineRepository(private val context: Context) {

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun getMachines(): MachinesListResponse? {
        val jsonMachines = getJsonFromFile("nespresso-maquinas.json")
        val jsonAdapter: JsonAdapter<MachinesListResponse> = moshi.adapter(MachinesListResponse::class.java)

        return jsonAdapter.fromJson(jsonMachines)
    }

    fun getJsonFromFile(file: String) = context.assets.open(file).bufferedReader().readText()
}