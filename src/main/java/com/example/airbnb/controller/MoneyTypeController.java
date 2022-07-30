package com.example.airbnb.controller;

import com.example.airbnb.model.MoneyType;
import com.example.airbnb.service.MoneyType.MoneyTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/money-types")
public class MoneyTypeController {
    @Autowired
    MoneyTypeServiceImpl moneyTypeService;

    @GetMapping
    public ResponseEntity<Iterable<MoneyType>> showAllMoneyType(){
        return new ResponseEntity<>(moneyTypeService.findAll() , HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<MoneyType>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(moneyTypeService.findById(id), HttpStatus.OK);
    }
}
