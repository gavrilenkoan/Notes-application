package com.example.notesapi.note;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository repository) {
        return args -> {
            Note note1 = new Note("wash dishes",
                    "i really need to do it");
            Note note2 = new Note("shopping");
            Note note3 = new Note("homework",
                            "english, math");
            Note note4 = new Note("home duties",
                            "cleaning");
            Note note5 = new Note("programming");
            Note note6 = new Note();
            Note note7 = new Note("smth",
                            "smth");
            Note note8 = new Note();
            Note note9 = new Note("foo",
                            "foo");
            Note note10 = new Note("sleep",
                            "z-z-z");

            repository.saveAll(
                    List.of(note1, note2, note3, note4, note5,
                            note6, note7, note8, note9, note10)
            );
        };
    }
}
