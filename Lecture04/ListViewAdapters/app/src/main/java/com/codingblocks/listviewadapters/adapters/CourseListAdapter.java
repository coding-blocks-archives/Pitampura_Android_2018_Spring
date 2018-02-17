package com.codingblocks.listviewadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codingblocks.listviewadapters.R;
import com.codingblocks.listviewadapters.models.Course;

import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {

    private ArrayList<Course> courses;
    private Context context;

    public CourseListAdapter(Context context, ArrayList<Course> courses) {
        this.courses = courses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course, parent, false);

        Course course = getItem(position);
        TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
        TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
        TextView tvLectures = itemView.findViewById(R.id.tvLectures);

        tvCourseName.setText(course.getCourseName());
        tvTeacherName.setText(course.getTeacherName());
        tvLectures.setText(course.getLectures().toString());

        return itemView;
    }
}
