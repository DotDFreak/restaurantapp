package com.example.restaurantapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {                       //Ebbol nem ertek sokmindent, ha jol ertettem ez hozza letre az adatbazist
    abstract fun userDAO(): UserDAO
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
        @InternalCoroutinesApi
        fun getDatabase(context: Context) : UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}