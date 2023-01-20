package com.esraa.egfwd.shoestore.screens.shoe_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esraa.egfwd.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _shoe= MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
    get() = _shoe

    private var _shoeAddedEvent = MutableLiveData<Boolean>()
    val shoeAddedEvent : LiveData<Boolean>
    get() = _shoeAddedEvent


    init {
        _shoeList.value = mutableListOf()
        _shoe.value = Shoe()
        _shoeAddedEvent.value = false
    }

    fun addShoe(){
        val newShoe = Shoe(_shoe.value!!.name, _shoe.value!!.size, _shoe.value!!.company, _shoe.value!!.description)
        _shoeList.value?.add(newShoe)
        _shoe.value = Shoe()
        _shoeAddedEvent.value = true
        Log.i("ShoeListViewModel", _shoeList.value.toString())
      }

    fun onAddShoeComplete() {
        _shoeAddedEvent.value = false
    }
}