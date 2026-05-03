package com.example.letssopt.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.letssopt.local.purchase.dao.PurchaseDao
import com.example.letssopt.local.purchase.entity.PurchaseHistory
import kotlin.concurrent.Volatile

@Database(entities = [PurchaseHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun purchaseDao() : PurchaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
