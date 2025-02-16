package com.example.project01.service; // Defines the package for organization

import com.example.project01.model.Note; // Importing the Note model
import com.example.project01.repository.NoteRepository; // Importing the Note repository
import org.springframework.stereotype.Service; // Marks this as a service component

import java.time.LocalDate;
import java.util.List;

/**
 * NoteService is a service class that contains business logic for handling notes.
 * It interacts with the NoteRepository to perform CRUD operations.
 */
@Service // Marks this class as a Spring service (used for business logic)
public class NoteService {

    private final NoteRepository noteRepository; // Dependency for database operations

    /**
     * Constructor-based dependency injection for NoteRepository.
     * Spring automatically injects the repository instance.
     */
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * ✅ GET all notes
     * Retrieves all notes from the database.
     * @return List of all notes
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll(); // Fetch all notes from DB
    }

    /**
     * ✅ POST - Create a new note
     * Saves a new note in the database.
     * @param note - Note object to be saved
     * @return The created note
     */
    public Note createNote(Note note) {
        note.setDate(LocalDate.now()); // Set the current date for the note
        return noteRepository.save(note); // Save note in DB
    }

    /**
     * ✅ DELETE - Remove a note by ID
     * Deletes a note from the database if it exists.
     * @param id - The ID of the note to delete
     */
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id); // Delete note by ID
    }
}
