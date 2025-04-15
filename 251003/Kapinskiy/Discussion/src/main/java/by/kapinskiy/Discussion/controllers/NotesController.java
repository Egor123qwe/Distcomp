package by.kapinskiy.Discussion.controllers;


import by.kapinskiy.Discussion.DTOs.Requests.NoteRequestDTO;
import by.kapinskiy.Discussion.DTOs.Responses.NoteResponseDTO;
import by.kapinskiy.Discussion.services.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NoteResponseDTO> getAllNotes() {
        return notesService.findAll();
    }

    @GetMapping("/{id}")
    public NoteResponseDTO getNoteById(@PathVariable Long id) {
        try {
            return notesService.findById(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

}
