package com.example.architecturecompenents.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.architecturecompenents.model.NoteRepository;
import com.example.architecturecompenents.model.Notes;

import java.util.List;

//5th
public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Notes>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Notes note){
        repository.insert(note);
    }

    public void update(Notes note){
        repository.update(note);
    }

    public void delete(Notes note){
        repository.delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Notes>> getAllNotes(){
        return allNotes;
    }
}
