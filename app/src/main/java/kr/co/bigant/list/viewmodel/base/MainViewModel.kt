package kr.co.bigant.list.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _itemList = MutableLiveData<List<String>>(emptyList()) //변할수 있음
    val itemList: LiveData<List<String>> get() = _itemList


    fun getData() {
        _itemList.value = listOf("A", "B", "C", "D")
    }

    fun addData() {
        _itemList.value = _itemList.value?.toMutableList()?.plus("F")
    }

    fun deleteData() {
        _itemList.value = _itemList.value?.toMutableList()?.minus("F")
    }
}