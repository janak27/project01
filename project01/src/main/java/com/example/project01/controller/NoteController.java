package com.example.project01.controller; // Defines the package for organization

import com.example.project01.model.Note; // Importing the Note model
import com.example.project01.repository.NoteRepository; // Importing the Note repository
import org.springframework.http.ResponseEntity; // Used for handling HTTP responses
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * NoteController handles all API requests related to notes.
 * It provides endpoints for CRUD operations: Create, Read, Update, and Delete notes.
 */
@RestController // Marks this class as a REST API controller
@RequestMapping("/api/notes") // Base URL for all endpoints in this controller
public class NoteController {

    private final NoteRepository noteRepository; // Dependency for database operations

    /**
     * Constructor-based dependency injection for NoteRepository.
     * Spring automatically injects the repository instance.
     */
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * ✅ GET all notes
     * URL: GET /api/notes
     * @return List of all notes in the database
     */
    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll(); // Fetch all notes from DB
    }

    /**
     * ✅ GET a single note by ID
     * URL: GET /api/notes/{id}
     * @param id - The ID of the note to retrieve
     * @return Note if found, else a 404 Not Found response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {

        return noteRepository.findById(id) // Fetch note by ID
                .map(ResponseEntity::ok) // If found, return 200 OK with note
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found, return 404
    }

    /**
     * ✅ POST - Create a new note
     * URL: POST /api/notes
     * @param note - Note object from request body
     * @return The created note
     */
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        note.setDate(LocalDate.now()); // Set the current date for the note
        return noteRepository.save(note); // Save new note in DB
    }

    /**
     * ✅ PUT - Update an existing note
     * URL: PUT /api/notes/{id}
     * @param id - ID of the note to update
     * @param noteDetails - Updated note data from request body
     * @return Updated note if found, else 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        return noteRepository.findById(id) // Find existing note
                .map(note -> {
                    note.setTitle(noteDetails.getTitle()); // Update title
                    note.setContent(noteDetails.getContent()); // Update content
                    note.setDate(LocalDate.now()); // Set the current date for updated note
                    Note updatedNote = noteRepository.save(note); // Save changes
                    return ResponseEntity.ok(updatedNote); // Return updated note
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found, return 404
    }

    /**
     * ✅ DELETE - Remove a note
     * URL: DELETE /api/notes/{id}
     * @param id - The ID of the note to delete
     * @return 204 No Content if deleted, else 404 Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNote(@PathVariable Long id) {
        return noteRepository.findById(id) // Find note by ID
                .map(note -> {
                    noteRepository.delete(note); // Delete note
                    return ResponseEntity.noContent().build(); // Return 204 No Content
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found, return 404
    }
}
