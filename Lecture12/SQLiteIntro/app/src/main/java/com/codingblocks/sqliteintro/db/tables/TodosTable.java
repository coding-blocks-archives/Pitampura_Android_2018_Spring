package com.codingblocks.sqliteintro.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codingblocks.sqliteintro.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.sqliteintro.db.Consts.*;

public class TodosTable {

    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }
    public static String[] PROJECTION_ALL = {
            Columns.ID, Columns.TASK, Columns.DONE
    };

    // SQL Statements
    public static final String CMD_CREATE_TABLE =
            CREATE_TABLE_INE + TABLE_NAME + LBR
                    + Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI
                    + COMMA
                    + Columns.TASK + TYPE_TEXT
                    + COMMA
                    + Columns.DONE + TYPE_BOOL
            + RBR + SEMI;

    public static long insertTodo(SQLiteDatabase db, Todo todo) {
        ContentValues row = new ContentValues();
        row.put(Columns.TASK, todo.getTask());
        row.put(Columns.DONE, todo.isDone());

        return db.insert(
                TABLE_NAME,
                null,
                row
        );
    }

    public static ArrayList<Todo> getTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                PROJECTION_ALL,
                null, null,
                null, null,
                Columns.ID + DESC
        );
        int idxId = c.getColumnIndex(Columns.ID);
        int idxTask = c.getColumnIndex(Columns.TASK);
        int idxDone = c.getColumnIndex(Columns.DONE);

        while(c.moveToNext()) {
            Todo todo = new Todo();
            todo.setId(c.getInt(idxId));
            todo.setTask(c.getString(idxTask));
            todo.setDone(c.getInt(idxDone) == 1);
            todos.add(todo);
        }
        return todos;
    }


}
