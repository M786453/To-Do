package com.example.todo;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoViewModel extends AndroidViewModel {

    private ToDoRepository toDoRepository;

    private final LiveData<List<ToDo>> todo_list;

    public ToDoViewModel (Application application){

        super(application);
        toDoRepository = new ToDoRepository(application);
        todo_list = toDoRepository.getTodo_list();

    }

    LiveData<List<ToDo>> getTodo_list(){
        return todo_list;
    }

    public  void insert(ToDo toDo){

        toDoRepository.insert(toDo);

    }

    public void delete(ToDo toDo){

        toDoRepository.delete(toDo);
    }


}
