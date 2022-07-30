package com.example.airbnb.controller;

import com.example.airbnb.model.CategorySpending;
import com.example.airbnb.model.Wallet;
import com.example.airbnb.service.Wallet.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    WalletServiceImpl walletService;

    @GetMapping
    public ResponseEntity<Iterable<Wallet>> showAllWallet(){
        return new ResponseEntity<>(walletService.findAll() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Wallet>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.findById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Optional<Wallet>> save(@RequestBody Wallet wallet) {
        return new ResponseEntity(walletService.save(wallet), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Wallet>> update(@PathVariable Long id, @RequestBody Wallet wallet) {
        Optional<Wallet> walletOptional = walletService.findById(id);
        if (!walletOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wallet.setId(walletOptional.get().getId());
        return new ResponseEntity(walletService.save(wallet), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Wallet> delete(@PathVariable Long id) {
        Optional<Wallet> walletOptional = walletService.findById(id);
        if (!walletOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        walletService.remove(id);
        return new ResponseEntity<>(walletOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find-by-wallet-name/{name}")
    public ResponseEntity<Iterable<Wallet>> findByWalletName(@PathVariable String name) {
        return new ResponseEntity<>(walletService.findAllByNameContaining(name), HttpStatus.OK);
    }
}
