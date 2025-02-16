package com.example.project01.model;

import jakarta.persistence.*; // JPA annotations for database mapping
import lombok.*; // Lombok annotations to reduce boilerplate code
import java.time.LocalDate; // Java class to handle dates

/**
 * Note is an entity class that represents a note in the database.
 */
@Entity
@Data // Lombok generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok generates a no-args constructor
@AllArgsConstructor // Lombok generates a constructor with all fields
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value
    private Long id; // Unique identifier for each note

    private String title; // Stores the title of the note
    private String content; // Stores the content of the note

    @Column(nullable = false) // Ensures the date field cannot be null
    private LocalDate date; // Stores the date of the note (created or modified)
}
