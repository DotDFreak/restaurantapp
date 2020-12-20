package com.example.restaurantapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserData)                        //Uj felhasznalo hozzaadasa az adatbazishoz

    @Query("SELECT * FROM user_table")
    fun readLoginData(): LiveData<List<UserData>>               //Ezt a queryt arra hasznalom, hogy rakeressek arra az adatra, amivel valaki be szeretne lepni

    @Query("SELECT * FROM user_table WHERE :usr LIKE username")      //Ezt arra hasznalom, hogy login utan lekerjem a belepett felhasznalo adatait
    fun readLoggedData(usr : String): LiveData<UserData>
}