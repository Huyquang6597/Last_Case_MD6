package com.example.airbnb.service.MoneyType;

import com.example.airbnb.model.MoneyType;
import com.example.airbnb.repository.MoneyTypeRepository;
import com.example.airbnb.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MoneyTypeServiceImpl implements MoneyTypeService {
    @Autowired
    MoneyTypeRepository moneyTypeRepository;

    @Override
    public Iterable<MoneyType> findAll() {
        return moneyTypeRepository.findAll();
    }

    @Override
    public Optional<MoneyType> findById(Long id) {
        return moneyTypeRepository.findById(id);
    }

    @Override
    public MoneyType save(MoneyType moneyType) {
        return moneyTypeRepository.save(moneyType);
    }

    @Override
    public void remove(Long id) {
        moneyTypeRepository.deleteById(id);
    }
}
