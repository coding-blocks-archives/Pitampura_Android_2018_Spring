package com.codingblocks.firebase;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView notesRv;
    FloatingActionButton fab;
    ArrayList<Notes> notesArrayList = new ArrayList<>();
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesRv = findViewById(R.id.recyclerViewTodo);
        fab = findViewById(R.id.floatingActionButton);
        notesAdapter = new NotesAdapter(notesArrayList);
        notesRv.setLayoutManager(new LinearLayoutManager(this));
        notesRv.setAdapter(notesAdapter);
        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = new Random().nextInt(100);
                Notes notes = new Notes("Title Number " + i, "Description " + i);
                //Push data to firebase
                dbref.push().setValue(notes);
            }
        });
    }


}
