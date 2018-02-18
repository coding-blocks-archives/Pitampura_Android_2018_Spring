package com.codingblocks.listviewadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.listviewadapters.adapters.CourseRecyclerAdapter;
import com.codingblocks.listviewadapters.models.Course;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvCourses;
    ArrayList<Course> courses = Course.genRandomCourses(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CourseRecyclerAdapter courseAdapter = new CourseRecyclerAdapter(courses);
        rvCourses.setAdapter(courseAdapter);
    }
}
