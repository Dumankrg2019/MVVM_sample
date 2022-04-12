package kz.dev.countries_catalin_stefan.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CountriesService {


    @Inject
    lateinit var api: CountriesApi

    init {

    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}