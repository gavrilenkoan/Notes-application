package com.example.notesapi.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteId) {
        boolean exists = noteRepository.existsById(noteId);
        if(!exists) {
            throw new IllegalStateException(
                    "note with id: \"" + noteId +"\" does not exist"
            );
        }
        return noteRepository.findById(noteId).get();
    }

    public void addNewNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNoteById(Long studentId) {
        boolean exists = noteRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id: \"" + studentId +"\" does not exist"
            );
        }
        noteRepository.deleteById(studentId);
    }

    @Transactional
    public void updateNoteById(
            Long noteId,
            Note newNote) {
        Note note = noteRepository.findNoteById(noteId)
                        .orElseThrow(() -> new IllegalStateException(
                                "student with id: \"" + noteId +"\" does not exist"
                        ));

        if(newNote.getTitle() != null && newNote.getTitle().length() > 0 && !Objects.equals(note.getTitle(), newNote.getTitle())) {
            note.setTitle(newNote.getTitle());
        }

        if(newNote.getDescription() != null && newNote.getDescription().length() > 0 && !Objects.equals(note.getDescription(), newNote.getDescription())) {
            note.setDescription(newNote.getDescription());
        }
    }
}
