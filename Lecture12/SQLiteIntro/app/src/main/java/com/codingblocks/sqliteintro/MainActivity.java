package com.codingblocks.sqliteintro;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.codingblocks.sqliteintro.db.MyDatabaseHelper;
import com.codingblocks.sqliteintro.db.tables.TodosTable;
import com.codingblocks.sqliteintro.models.Todo;

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

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo();
                todo.setTask(etNewTodo.getText().toString());
                todo.setDone(false);
                TodosTable.insertTodo(db, todo);

                for (Todo t: TodosTable.getTodos(db)) {
                    Log.d(TAG, "onClick: " + t.getTask());
                }
            }
        });
    }
}
