package com.example.restaurantapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserData)

    @Query("SELECT * FROM user_table")
    fun readLoginData(): LiveData<List<UserData>>

    @Query("SELECT * FROM user_table WHERE :usr LIKE username")
    fun readLoggedData(usr : String): LiveData<UserData>
}