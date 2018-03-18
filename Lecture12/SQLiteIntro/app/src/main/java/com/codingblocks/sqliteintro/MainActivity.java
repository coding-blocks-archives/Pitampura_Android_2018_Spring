package com.codingblocks.sqliteintro;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.codingblocks.sqliteintro.db.MyDatabaseHelper;
import com.codingblocks.sqliteintro.db.tables.TodosTable;
import com.codingblocks.sqliteintro.models.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {
    EditText etNewTodo;
    Button btnAddTodo;
    ListView lvTodos;

    public static final String TAG = "TODO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNewTodo = findViewById(R.id.etNewTodo);
        btnAddTodo = findViewById(R.id.btnAddTodo);
        lvTodos = findViewById(R.id.lvTodos);

        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        updateTodos(db);

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo();
                todo.setTask(etNewTodo.getText().toString());
                todo.setDone(false);
                TodosTable.insertTodo(db, todo);
                updateTodos(db);
            }
        });
    }

    void updateTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = TodosTable.getTodos(db);
        ArrayList<String> todoStringList = new ArrayList<>();
        for (Todo t: todos) {
            todoStringList.add(t.getTask());
        }

        lvTodos.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                todoStringList
        ));
    }
}
