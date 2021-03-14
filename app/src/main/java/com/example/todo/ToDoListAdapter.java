package com.example.todo;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ToDoListAdapter extends ListAdapter<ToDo,ToDoViewHolder> {

    public ToDoListAdapter(@NonNull DiffUtil.ItemCallback<ToDo> diffCallback){
        super(diffCallback);
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ToDoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo current = getItem(position);
        holder.bind(current.getToDo());
    }

    static class ToDoDiff extends DiffUtil.ItemCallback<ToDo>{


        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getToDo().equals(newItem.getToDo());
        }
    }




}
