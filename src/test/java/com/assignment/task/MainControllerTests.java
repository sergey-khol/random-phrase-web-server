package com.assignment.task;

import com.assignment.task.data.Phrase;
import com.assignment.task.repository.PhraseRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private PhraseRepository phraseRepository;

	@Test
	public void indexPageAccessTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(startsWith("<!DOCTYPE HTML>")));
	}

	@Test
	public void indexPageRandomPhraseTest() throws Exception {
		// Since home page returns a random phrase and splits it we need to check whether the page contains any of existing phrases or not
		final List<Matcher<? super String>> contentExpectedMatchers = new ArrayList<>();
		for (Phrase phrase : phraseRepository.findAll()) {
			contentExpectedMatchers.add(stringContainsInOrder(phrase.getPhrase().split(" ")));
		}

		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(anyOf(contentExpectedMatchers)));
	}
}
