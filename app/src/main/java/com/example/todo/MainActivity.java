package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText edt_todo;
    private Button btn_add_todo,btn_done_todo;
    private FloatingActionButton fab;
    private LinearLayout linearLayout_add_todo;
    private boolean canShowLinearLayoutAddTodo=true;
    private String s_todo ="";
    private ToDoViewModel toDoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_todo = findViewById(R.id.edt_todo);
        btn_add_todo = findViewById(R.id.btn_add_todo);
        btn_done_todo = findViewById(R.id.btn_done);
        fab = findViewById(R.id.fab);
        linearLayout_add_todo = findViewById(R.id.linear_layout_add_todo);
    recyclerView = findViewById(R.id.todo_recycler_view);
    final ToDoListAdapter adapter = new ToDoListAdapter(new ToDoListAdapter.ToDoDiff());
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
      toDoViewModel = new ViewModelProvider(MainActivity.this).get(ToDoViewModel.class);

      toDoViewModel.getTodo_list().observe(this,toDos -> {
          adapter.submitList(toDos);
      });

       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

             animateAddToDoLayout();


           }
       });

      btn_add_todo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (edt_todo.getText().toString().isEmpty()){
                  edt_todo.setError("Field must not be empty");
                  edt_todo.requestFocus();
              }else {
                  s_todo = edt_todo.getText().toString();
                  ToDo toDo = new ToDo(s_todo);
                  toDoViewModel.insert(toDo);
                  edt_todo.setText("");
                  Toast.makeText(MainActivity.this, "To Do Added", Toast.LENGTH_SHORT).show();
              }

          }
      });

    }



    private  void animateAddToDoLayout(){
        if (canShowLinearLayoutAddTodo) {
            linearLayout_add_todo.animate().translationX(0).setDuration(1000);
            fab.animate().rotation(45);

            canShowLinearLayoutAddTodo = false;

        } else {
            linearLayout_add_todo.animate().translationX(1000).setDuration(1000);
            fab.animate().rotation(0);

            canShowLinearLayoutAddTodo = true;
        }
    }
}