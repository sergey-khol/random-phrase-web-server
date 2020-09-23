package com.assignment.task.service;

import com.assignment.task.data.Phrase;
import com.assignment.task.repository.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhraseService {

    private final Random random = new Random();

    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    /**
     * Generates random number and that random number used to fetch a phrase from the database
     *  @return random phrase from database
     */
    public Phrase getRandomPhrase() {
        List<Phrase> phrases = phraseRepository.findAll();
        int randomIndex = random.nextInt(phrases.size());
        return phrases.get(randomIndex);
    }

}
