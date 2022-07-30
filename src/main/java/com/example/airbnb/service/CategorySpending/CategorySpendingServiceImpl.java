package com.example.airbnb.service.CategorySpending;

import com.example.airbnb.model.CategorySpending;
import com.example.airbnb.repository.CategorySpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategorySpendingServiceImpl implements CategorySpendingService {
    @Autowired
    CategorySpendingRepository categorySpendingRepository;

    @Override
    public Iterable<CategorySpending> findAll() {
        return categorySpendingRepository.findAll();
    }

    @Override
    public Optional<CategorySpending> findById(Long id) {
        return categorySpendingRepository.findById(id);
    }

    @Override
    public CategorySpending save(CategorySpending categorySpending) {
        return categorySpendingRepository.save(categorySpending);
    }

    @Override
    public void remove(Long id) {
        categorySpendingRepository.deleteById(id);
    }
}
