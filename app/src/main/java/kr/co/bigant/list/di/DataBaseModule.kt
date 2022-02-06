package kr.co.bigant.list.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.bigant.list.db.AppDatabase
import kr.co.bigant.list.db.dao.UserDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideAppDataBase(
        @ApplicationContext context : Context
    ):AppDatabase = AppDatabase.buildDatabase(context)
    @Singleton
    @Provides
    fun provideUserDao(
        database: AppDatabase
    ):UserDao = database.userDao()

}