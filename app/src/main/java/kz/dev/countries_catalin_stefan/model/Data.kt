package kz.dev.countries_catalin_stefan.model

import com.google.gson.annotations.SerializedName

data class  Country(
    @SerializedName("name")
    val nameCountry: String?,

    @SerializedName("capital")
    val capital: String?,

    @SerializedName("flagPNG")
    val flag: String?

    )
