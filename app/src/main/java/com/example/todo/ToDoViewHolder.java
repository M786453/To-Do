package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder{

    private final TextView txt_todo;
    private final CheckBox checkBox_todo;


    private ToDoViewHolder(View itemView){
        super(itemView);
        txt_todo = itemView.findViewById(R.id.txt_todo);
        checkBox_todo = itemView.findViewById(R.id.check_box_todo);



    }

    public void bind(String todo_text){

        txt_todo.setText(todo_text);

    }

    static ToDoViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item,parent,false);
        return new ToDoViewHolder(view);
    }
}
