package com.example.demo.controller;

import com.example.demo.entity.Journal;
import com.example.demo.repository.JournalEntryRepository;
import com.example.demo.repository.JournalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    Logger logger = LoggerFactory.getLogger(JournalController.class);

    @GetMapping
    public Iterable<Journal> findAll() {
        logger.debug("get journal");
        return journalRepository.findAll();
    }

    @GetMapping("/:id")
    public Journal findOne() {
        logger.debug("get journal");
        return journalRepository.findById(1L).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Journal create(@RequestBody Journal journal) {
        logger.debug("request made to create journal");
        logger.debug(journal.getName());
        Journal created = journalRepository.save(journal);
        return created;
    }
}
