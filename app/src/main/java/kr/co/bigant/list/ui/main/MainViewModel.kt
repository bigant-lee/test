package kr.co.bigant.list.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.bigant.list.db.AppDatabase
import kr.co.bigant.list.db.dao.UserDao
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {
    private val _itemList = MutableLiveData<List<String>>(emptyList()) //변할수 있음
    val itemList: LiveData<List<String>> get() = _itemList


    fun getData() {
        userDao.getAll()
        _itemList.value = listOf("A", "B", "C", "D")
    }

    fun addData() {
        val list = itemList.value?.toMutableList() ?: mutableListOf()
        list.add("F")
        _itemList.value = list
    }

    fun deleteData() {
        val list = itemList.value?.toMutableList() ?: mutableListOf()
        list.removeLast()
        _itemList.value = list
    }
}