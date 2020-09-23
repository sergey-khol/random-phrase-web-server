package com.assignment.task;

import com.assignment.task.repository.PhraseRepository;
import com.assignment.task.service.PhraseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
class PhraseServiceTests {

    private final static int THRESHOLD_REQUESTS_FACTOR = 10; // Specifies the multiplicator for the limit of service calls

    @Autowired
    private PhraseService phraseService;

    @Autowired
    private PhraseRepository phraseRepository;

    @Test
    public void randomPhraseTest() {
        long totalPhrases = phraseRepository.count();
        Set<String> phrases = new HashSet<>();

        for (int i = 0; i < totalPhrases * THRESHOLD_REQUESTS_FACTOR; i++) {
            phrases.add(phraseService.getRandomPhrase().getPhrase());
            if (phrases.size() > totalPhrases / 2) {
                // Got half of the phrases
                return;
            }
        }
        fail("Didn't receive enough phrases");
    }
}