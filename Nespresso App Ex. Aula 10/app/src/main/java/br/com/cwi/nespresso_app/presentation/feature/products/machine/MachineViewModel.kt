package br.com.cwi.nespresso_app.presentation.feature.products.machine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.domain.repository.MachineRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class MachineViewModel(
    private val repository: MachineRepository
): BaseViewModel() {

    private val _machines = MutableLiveData<List<Machine>>()
    val machines: LiveData<List<Machine>> = _machines

    fun fetchMachines() {
        launch {
            repository.getMachines().let { machine ->
                _machines.postValue(machine)
            }
        }
    }
}