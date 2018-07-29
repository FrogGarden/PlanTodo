package com.example.hongjun.plantodo.dao

import android.arch.persistence.room.*
import com.example.hongjun.plantodo.dto.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun findAll() : List<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(todo : Todo)

    @Update
    fun update(todo : Todo)

    @Query("DELETE FROM todo WHERE done = :done")
    fun delete(done : Boolean)
}