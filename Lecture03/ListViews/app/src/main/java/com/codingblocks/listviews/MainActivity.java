package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] courses = {
            "Android",
            "Webdev",
            "Launchpad",
            "Crux",
            "Gamedev",
            "Machine Learning",
            "Competitive Coding",
            "Django",
            "Angular JS",
            "React",
            "Android",
            "Webdev",
            "Launchpad",
            "Crux",
            "Gamedev",
            "Machine Learning",
            "Competitive Coding",
            "Django",
            "Angular JS",
            "React"
    };
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);

//        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                courses
//        );
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_course,
                R.id.tvCourseName,
                courses
        );

        lvCourses.setAdapter(courseAdapter);

    }
}
