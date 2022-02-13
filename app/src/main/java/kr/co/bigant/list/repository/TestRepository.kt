package kr.co.bigant.list.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.bigant.list.db.dao.UserDao
import kr.co.bigant.list.entity.User

class TestRepository(
    private val dao: UserDao
) {
    suspend fun insert(entity: User) {
        withContext(Dispatchers.IO) {
            dao.insertAll(entity)
        }
    }
    suspend fun getList(callback: (LiveData<List<User>>) -> Unit) {
        withContext(Dispatchers.IO) {
            callback(dao.getAll())
        }
    }
    companion object{
        @Volatile
        private var instance:TestRepository? = null
        fun getInstance(userDao: UserDao)=
            instance ?: synchronized(this){
                instance?:TestRepository(userDao).also {
                    instance = it
                }
            }
    }
}