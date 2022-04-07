package kz.dev.countries_catalin_stefan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kz.dev.countries_catalin_stefan.model.CountriesService
import kz.dev.countries_catalin_stefan.model.Country

class ListViewModel: ViewModel() {

    private val countriesService = CountriesService()
    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countryLoadedError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun  fetchCountries() {
//        val mockData = listOf(
//            Country("Vacanda"),
//            Country("Rodeziya"),
//            Country("Prussiya"),
//            Country("Angola"),
//            Country("Madagaskar"),
//            Country("Tajikiston"),
//            Country("Peru"),
//        )
//        countryLoadedError.value = false
//        countries.value = mockData

        loading.value = true
        disposable.add(
            countriesService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Country>>()
                    {
                        override fun onSuccess(t: List<Country>) {
                           countries.value = t
                            countryLoadedError.value = false
                            loading.value = false
                        }

                        override fun onError(e: Throwable) {
                            countryLoadedError.value = true
                            loading.value = false
                        }
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}