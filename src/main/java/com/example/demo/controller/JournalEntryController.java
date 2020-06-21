package com.example.demo.controller;

import com.example.demo.entity.Journal;
import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journalEntry")
public class JournalEntryController {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    Logger logger = LoggerFactory.getLogger(JournalEntryController.class);

    @GetMapping
    public Iterable<JournalEntry> findAll() {
        logger.debug("get journal entries");
        return journalEntryRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JournalEntry create(@RequestBody JournalEntry journalEntry) {
        logger.debug("request made to create journal entry");
        logger.debug(journalEntry.getText());
        JournalEntry created = journalEntryRepository.save(journalEntry);
        return created;
    }
}
