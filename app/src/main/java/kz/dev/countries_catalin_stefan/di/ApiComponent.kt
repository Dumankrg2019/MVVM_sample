package kz.dev.countries_catalin_stefan.di

import dagger.Component
import kz.dev.countries_catalin_stefan.model.CountriesService

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService) {

    }
}