package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DirectorRepository directorRepository;

    @Override
    public void run(String... strings) throws Exception {
        Director director = new Director();
        director.setName("Steven Spielberg");
        director.setGenre("Drama");
        directorRepository.save(director);

        director = new Director();
        director.setName("Alfred Hitchcock");
        director.setGenre("Suspense");
        directorRepository.save(director);
    }


}
