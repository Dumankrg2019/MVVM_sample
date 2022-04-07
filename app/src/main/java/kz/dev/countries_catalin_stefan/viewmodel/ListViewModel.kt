package kz.dev.countries_catalin_stefan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.dev.countries_catalin_stefan.model.Country

class ListViewModel: ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryLoadedError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun  fetchCountries() {

        val mockData = listOf(
            Country("Vacanda"),
            Country("Rodeziya"),
            Country("Prussiya"),
            Country("Angola"),
            Country("Madagaskar"),
            Country("Tajikiston"),
            Country("Peru"),
        )

        countryLoadedError.value = false
        loading.value = false
        countries.value = mockData
    }
}