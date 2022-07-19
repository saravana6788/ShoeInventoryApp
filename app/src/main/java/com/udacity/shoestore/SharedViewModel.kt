package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    var shoesList = listOf<Shoe>(
        Shoe("Ultraboost 22 Shoes", 6.5, "Adidas", "Best for comfort and responsiveness"),
        Shoe("Air Zoom Pegasus 39", 7.5, "Nike", "Best for running"),
        Shoe("Nano X2", 8.0, "Reebok", "Iconic training shoes with lightweight cushioning"),
        Shoe(
            "Fresh Foam X 1080v12",
            10.5,
            "New Balance",
            "Dual-layer midsole construction featuring top-bed foam cushioning and underfoot Fresh Foam X"
        ),
        Shoe(
            "Gel-Kayano 28",
            11.0,
            "Ascis",
            "Stable stride that moves you towards a balanced mindset"
        )
    )

    val shoesListData = MutableLiveData<List<Shoe>>()

    fun showShoesListData() {
        shoesListData.value = shoesList
    }

    fun addNewShoe(newShoe: Shoe) {
        shoesList += newShoe
        shoesListData.value = shoesList
    }


}