package com.codingblocks.listviewadapters.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codingblocks.listviewadapters.R;
import com.codingblocks.listviewadapters.models.Course;

import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {
    public static final String TAG = "ADAPTER";

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
        Log.d(TAG, "getView: " + "position = " + position + " convertView = " + convertView);
        CourseViewHolder holder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_item_course, parent, false);
            holder = new CourseViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CourseViewHolder) convertView.getTag();
        }

        Course course = getItem(position);


        holder.tvCourseName.setText(course.getCourseName());
        holder.tvTeacherName.setText(course.getTeacherName());
        holder.tvLectures.setText(course.getLectures().toString());

        return convertView;
    }

    class CourseViewHolder {
        TextView tvCourseName;
        TextView tvTeacherName;
        TextView tvLectures;

        CourseViewHolder(View convertView) {
            tvCourseName = convertView.findViewById(R.id.tvCourseName);
            tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
            tvLectures = convertView.findViewById(R.id.tvLectures);

        }
    }
}
