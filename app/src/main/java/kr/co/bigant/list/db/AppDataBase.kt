package kr.co.bigant.list.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kr.co.bigant.list.db.dao.UserDao
import kr.co.bigant.list.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "user-database")
                .fallbackToDestructiveMigration()
                .build()
    }
}