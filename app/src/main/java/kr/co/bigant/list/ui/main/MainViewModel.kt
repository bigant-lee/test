package kr.co.bigant.list.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.bigant.list.db.AppDatabase
import kr.co.bigant.list.db.dao.UserDao
import kr.co.bigant.list.entity.User
import kr.co.bigant.list.repository.TestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {
    private val _itemList = MutableLiveData<List<User>>(emptyList()) //변할수 있음
    val itemList: LiveData<List<User>> get() = _itemList
    private lateinit var testRepository: TestRepository

    fun getData() {
        viewModelScope.launch {
            testRepository.getList { itemList ->
                launch {
                    _itemList.value = itemList as List<User>
                }
            }
        }
    }

    fun addData() {
        val list = itemList.value?.toMutableList() ?: mutableListOf()
//        list.add("김호영")
//        _itemList.value = list
    }

    fun deleteData() {
        viewModelScope.launch {

        }
    }
}