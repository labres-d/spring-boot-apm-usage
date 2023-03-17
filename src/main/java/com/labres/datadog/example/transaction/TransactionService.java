package com.labres.datadog.example.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }


    public Transaction create(String name) {
        log.info("Transaction created");
        return repository.save(new Transaction(name));
    }

    public Iterable<Transaction> getTransactions() {
        log.info("Transactions listed");
        return repository.findAll();
    }
}
