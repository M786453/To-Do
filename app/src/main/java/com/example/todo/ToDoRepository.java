package com.example.todo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoRepository {

    private ToDoDao toDoDao;
    private LiveData<List<ToDo>> todo_list;


    ToDoRepository(Application application){

        ToDoRoomDatabase db = ToDoRoomDatabase.getDatabase(application);

        toDoDao = db.toDoDao();

        todo_list = toDoDao.getOrderedToDoList();


    }

     LiveData<List<ToDo>> getTodo_list(){


        return todo_list;
     }

     void insert(ToDo toDo){

        ToDoRoomDatabase.databaseWriteExecutor.execute(()->{
            toDoDao.insert(toDo);
        });

     }

    void delete(ToDo toDo){

        ToDoRoomDatabase.databaseWriteExecutor.execute(()->{
            toDoDao.delete(toDo);
        });

    }

}
