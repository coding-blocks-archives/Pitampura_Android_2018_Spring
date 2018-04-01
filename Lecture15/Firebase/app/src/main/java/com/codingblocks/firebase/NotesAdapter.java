package com.codingblocks.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by harshitdwivedi on 1/4/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyHolder> {

    private ArrayList<Notes> notesArrayList;

    public NotesAdapter(ArrayList<Notes> notesArrayList) {
        this.notesArrayList = notesArrayList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Notes notes = notesArrayList.get(position);
        holder.title.setText(notes.getTitle());
        holder.description.setText(notes.getDescription());
    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        public MyHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.noteTitle);
            description = itemView.findViewById(R.id.noteDetail);
        }
    }
}
