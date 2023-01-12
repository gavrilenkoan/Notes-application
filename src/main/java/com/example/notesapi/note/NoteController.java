package com.example.notesapi.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(path = "{noteId}")
    public Note getNote(@PathVariable("noteId") Long noteId) {
        return noteService.getNoteById(noteId);
    }

    @PostMapping
    public void addNote(@RequestBody Note note) {
        noteService.addNewNote(note);
    }

    @DeleteMapping(path = "{noteId}")
    public void deleteStudent(@PathVariable("noteId") Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    @PutMapping(path = "{noteId}")
    public void updateStudent(
            @PathVariable("noteId") Long noteId,
            @RequestBody Note note) {
        noteService.updateNoteById(noteId, note);
    }
}