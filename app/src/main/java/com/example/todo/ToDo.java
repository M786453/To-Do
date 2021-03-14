package com.example.todo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_table")
public class ToDo {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "todo")
    private String toDo;









    public ToDo(@NonNull String toDo){
        this.toDo = toDo;


    }

    public String getToDo(){
        return  this.toDo;
    }




}
