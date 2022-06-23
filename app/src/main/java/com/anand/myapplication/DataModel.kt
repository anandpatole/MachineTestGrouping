package com.anand.myapplication

import com.google.gson.annotations.SerializedName
import java.util.*

data class DataModel(
    @SerializedName("sort" ) var sort : ArrayList<Sort> = arrayListOf()
)

data class Sort (

    @SerializedName("Mid"       ) var Mid       : String?    = null,
    @SerializedName("Tid"       ) var Tid       : String?    = null,
    @SerializedName("amount"    ) var amount    : String? = null,
    @SerializedName("narration" ) var narration : String?    = null

)