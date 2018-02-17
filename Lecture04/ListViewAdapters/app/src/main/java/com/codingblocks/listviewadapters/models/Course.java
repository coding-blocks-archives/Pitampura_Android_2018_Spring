package com.codingblocks.listviewadapters.models;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    private String courseName;
    private String teacherName;
    private Integer lectures;

    public Course(String courseName, String teacherName, Integer lectures) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Integer getLectures() {
        return lectures;
    }

    public static final String[] TEACHERS = {
            "Arnav", "Prateek", "Deepak",
            "Rishab", "Garima", "Harshit",
            "Aayush", "Rajesh"
    };
    public static final String[] COURSES = {
            "Launchpad", "Crux", "Android",
            "Webdev", "Django", "Machine Learning",
            "Competitive Coding", "Gamedev"
    };

    public static ArrayList<Course> genRandomCourses (int size) {
        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            courses.add(new Course(
                    COURSES[r.nextInt(8)],
                    TEACHERS[r.nextInt(8)],
                    10 + r.nextInt(10)
            ));
        }
        return courses;
    }
}
