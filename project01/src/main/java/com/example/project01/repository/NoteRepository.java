package com.example.project01.repository; // Defines the package for organization

import com.example.project01.model.Note; // Importing the Note model
import org.springframework.data.jpa.repository.JpaRepository; // Importing JpaRepository for database operations

/**
 * NoteRepository is an interface that extends JpaRepository.
 * It provides built-in CRUD operations for the Note entity.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    // No need to write implementation, JpaRepository provides CRUD methods automatically.
}
