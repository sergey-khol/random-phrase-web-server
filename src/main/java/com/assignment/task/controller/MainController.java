package com.assignment.task.controller;

import com.assignment.task.service.PhraseService;
import com.assignment.task.util.PhraseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    final
    PhraseService phraseService;

    public MainController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        String[] phraseParts = PhraseUtils.splitPhraseNicely(phraseService.getRandomPhrase().getPhrase());

        model.addAttribute("phrase_part1", phraseParts[0]);
        model.addAttribute("phrase_part2", phraseParts[1]);
        return "home";
    }
}