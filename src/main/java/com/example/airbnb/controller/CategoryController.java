package com.example.airbnb.controller;
import com.example.airbnb.model.CategorySpending;
import com.example.airbnb.service.CategorySpending.CategorySpendingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategorySpendingServiceImpl categorySpendingService;

    @GetMapping
    public ResponseEntity<Iterable<CategorySpending>> showAllCategory(){
        return new ResponseEntity<>(categorySpendingService.findAll() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<CategorySpending>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(categorySpendingService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Optional<CategorySpending>> save(@RequestBody CategorySpending categorySpending) {
        return new ResponseEntity(categorySpendingService.save(categorySpending), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<CategorySpending>> update(@PathVariable Long id, @RequestBody CategorySpending categorySpending) {
        Optional<CategorySpending> categoryOptional = categorySpendingService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categorySpending.setId(categoryOptional.get().getId());
        return new ResponseEntity(categorySpendingService.save(categorySpending), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategorySpending> delete(@PathVariable Long id) {
        Optional<CategorySpending> categoryOptional = categorySpendingService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categorySpendingService.remove(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.NO_CONTENT);
    }


}
