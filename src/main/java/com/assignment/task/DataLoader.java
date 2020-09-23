package com.assignment.task;

import com.assignment.task.data.Phrase;
import com.assignment.task.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DataLoader implements ApplicationRunner {

    private final static String PHRASES_LIST_PATH = "classpath:phrases.txt";

    private ResourceLoader resourceLoader;

    private PhraseRepository phraseRepository;

    @Autowired
    public DataLoader(PhraseRepository phraseRepository, ResourceLoader resourceLoader) {
        this.phraseRepository = phraseRepository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Init database with phrases
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceLoader.getResource(PHRASES_LIST_PATH).getInputStream()))) {
            reader.lines().forEach(phraseText -> {
                Phrase phrase = new Phrase();
                phrase.setPhrase(phraseText);
                phraseRepository.save(phrase);
            });
        }
    }
}
