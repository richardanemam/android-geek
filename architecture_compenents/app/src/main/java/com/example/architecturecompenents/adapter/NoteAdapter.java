package com.example.architecturecompenents.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architecturecompenents.R;
import com.example.architecturecompenents.model.Notes;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    private List<Notes> notes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.description.setText(notes.get(position).getDescription());
        holder.priority.setText(String.valueOf(notes.get(position).getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Notes> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Notes getNoteAt(int position){
        return notes.get(position);
    }

    public class NoteHolder extends RecyclerView.ViewHolder{

        private TextView priority;
        private TextView title;
        private TextView description;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            priority = itemView.findViewById(R.id.tv_priority);
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null && getAdapterPosition() != RecyclerView.NO_POSITION)
                        listener.onItemClick(notes.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Notes note);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
