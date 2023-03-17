package com.labres.datadog.example.transaction;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Transaction>> getTransactions(){
        return new ResponseEntity<>(service.getTransactions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Param("name") String name){
        return new ResponseEntity<>(service.create(name), HttpStatus.CREATED);
    }
}
