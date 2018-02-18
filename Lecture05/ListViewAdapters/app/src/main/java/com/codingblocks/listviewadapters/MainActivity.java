package com.codingblocks.listviewadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.codingblocks.listviewadapters.adapters.CourseListAdapter;
import com.codingblocks.listviewadapters.models.Course;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> courses = Course.genRandomCourses(100);
    ListView lvCourses;
    CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        courseListAdapter = new CourseListAdapter(this, courses);
        lvCourses.setAdapter(courseListAdapter);

    }
}
