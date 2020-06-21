package com.example.demo.repository;

import com.example.demo.entity.JournalEntry;
import org.springframework.data.repository.CrudRepository;

public interface JournalEntryRepository extends CrudRepository<JournalEntry, Long> {

}