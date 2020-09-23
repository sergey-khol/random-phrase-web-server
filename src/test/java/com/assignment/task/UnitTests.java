package com.assignment.task;

import com.assignment.task.util.PhraseUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UnitTests {

    @Test
    public void phraseUtilsTest() {
        String str = "Some long phrase that should be divided equally without breaking words";
        String[] parts = PhraseUtils.splitPhraseNicely(str);

        assertEquals(parts.length, 2);
        assertEquals(parts[0], "Some long phrase that should be");
        assertEquals(parts[1], "divided equally without breaking words");
    }
}