package kr.co.bigant.list.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bigant.list.db.AppDatabase
import kr.co.bigant.list.db.dao.UserDao
import kr.co.bigant.list.entity.User
import kr.co.bigant.list.repository.TestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userDao: UserDao,
    private val testRepository: TestRepository
) : ViewModel() {
    private val _itemList = MutableLiveData<List<User>>(emptyList()) //변할수 있음
    val itemList: LiveData<List<User>> get() = _itemList

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            //IO Thread
            launch(Dispatchers.Main) {
                //Main Thread
            }
            testRepository.getList { itemList ->
                launch {
                    val list = itemList.value?.toMutableList() ?: mutableListOf()
                    if (list.isEmpty()) {
                        testRepository.insert(
                            User(0, "호영", "김"),
                            User(0, "한식", "김"),
                            User(0, "한식", "김")
                        )
                        getData()
                    }else{
                        _itemList.value = list
                    }
                }
            }
        }
    }

    fun addData() {
        viewModelScope.launch {
            val user = User(0, "호영", "김")
            testRepository.insert(user)
        }
        val list = itemList.value?.toMutableList() ?: mutableListOf()
//        list.add("김호영")
//        _itemList.value = list
    }

    fun deleteData() {
        viewModelScope.launch {

        }
    }
}