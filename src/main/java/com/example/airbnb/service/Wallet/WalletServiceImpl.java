package com.example.airbnb.service.Wallet;

import com.example.airbnb.model.Wallet;
import com.example.airbnb.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Iterable<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void remove(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public Iterable<Wallet> findAllByStatusPublicAndUserId(Long id) {
        return walletRepository.findAllByStatusPublicAndUser_Id(id);
    }

    @Override
    public Iterable<Wallet> findAllByStatusPrivateAndUserId(Long id) {
        return walletRepository.findAllByStatusPrivateAndUser_Id(id);
    }

    @Override
    public Iterable<Wallet> findAllByNameContaining(String name) {
        return walletRepository.findAllByNameContaining(name);
    }
}
