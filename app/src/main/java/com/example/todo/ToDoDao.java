package com.example.todo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo toDo);


    @Delete
    void delete(ToDo toDo);

    @Query("SELECT * FROM todo_table ORDER BY todo ASC")
    LiveData<List<ToDo>> getOrderedToDoList();

    @Query("DELETE FROM todo_table")
    void deleteAll();


}
