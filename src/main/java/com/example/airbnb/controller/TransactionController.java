package com.example.airbnb.controller;

import com.example.airbnb.model.Transaction;
import com.example.airbnb.model.Wallet;
import com.example.airbnb.service.Transaction.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;
    @GetMapping
    public ResponseEntity<Iterable<Transaction>> showAllTransaction(){
        return new ResponseEntity<>(transactionService.findAll() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Transaction>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.findById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Optional<Transaction>> save(@RequestBody Transaction transaction) {
        return new ResponseEntity(transactionService.save(transaction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        Optional<Transaction> transactionOptional = transactionService.findById(id);
        if (!transactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transaction.setId(transactionOptional.get().getId());
        return new ResponseEntity(transactionService.save(transaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> delete(@PathVariable Long id) {
        Optional<Transaction> transactionOptional = transactionService.findById(id);
        if (!transactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transactionService.remove(id);
        return new ResponseEntity<>(transactionOptional.get(), HttpStatus.NO_CONTENT);
    }
}
