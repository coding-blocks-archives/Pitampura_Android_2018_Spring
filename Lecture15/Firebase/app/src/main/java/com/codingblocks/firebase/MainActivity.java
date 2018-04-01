package com.codingblocks.firebase;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 12345;
    RecyclerView notesRv;
    FloatingActionButton fab;
    ArrayList<Notes> notesArrayList = new ArrayList<>();
    NotesAdapter notesAdapter;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesRv = findViewById(R.id.recyclerViewTodo);
        fab = findViewById(R.id.floatingActionButton);
        notesAdapter = new NotesAdapter(notesArrayList);
        notesRv.setLayoutManager(new LinearLayoutManager(this));
        notesRv.setAdapter(notesAdapter);
        dbref = FirebaseDatabase.getInstance().getReference();
        fab.setVisibility(View.GONE);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            //Not signed in
            startAuth();
        } else {
            //Signed in
            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            fab.setVisibility(View.VISIBLE);
            setDatabaseListener(dbref);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer i = new Random().nextInt(100);
                    Notes notes = new Notes("Title Number " + i, "Description " + i);
                    //Push data to firebase
                    dbref.child("notes").push().setValue(notes);
                }
            });
        }
//        dbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }

    public void startAuth() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                new AuthUI.IdpConfig.PhoneBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build()))
                        .setIsSmartLockEnabled(false)
                        .build(),
                RC_SIGN_IN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            // Successfully signed in
            if (resultCode == RESULT_OK) {
                fab.setVisibility(View.VISIBLE);
                setDatabaseListener(dbref);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer i = new Random().nextInt(100);
                        Notes notes = new Notes("Title Number " + i, "Description " + i);
                        //Push data to firebase
                        dbref.child("notes").push().setValue(notes);
                    }
                });

            } else {

                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    startAuth();
                } else if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    //No internet connection
                    startAuth();
                }
            }
        }
    }


    public void setDatabaseListener(DatabaseReference dbref) {
        dbref.child("notes").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Notes n = dataSnapshot.getValue(Notes.class);
                notesArrayList.add(n);
                notesAdapter.notifyDataSetChanged();
                Log.e("TAG", "onChildAdded: " + n.getTitle());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
