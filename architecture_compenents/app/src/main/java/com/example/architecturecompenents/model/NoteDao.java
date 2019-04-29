package com.example.architecturecompenents.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//2nd
@Dao
public interface NoteDao {

    @Insert
    void insert(Notes note);

    @Update
    void update(Notes note);

    @Delete
    void delete(Notes note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Notes>> getAllNotes();
}
