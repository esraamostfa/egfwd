package com.esraa.egfwd.shoestore.models


data class Shoe(var name: String = "", var size: Double = 0.0, var company: String = "", var description: String ="",
                val images: List<String> = mutableListOf())