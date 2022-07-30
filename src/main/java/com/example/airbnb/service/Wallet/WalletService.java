package com.example.airbnb.service.Wallet;

import com.example.airbnb.model.Wallet;
import com.example.airbnb.service.GeneralService;

public interface WalletService extends GeneralService<Wallet> {
    Iterable<Wallet> findAllByStatusPublicAndUserId(Long id);
    Iterable<Wallet>findAllByStatusPrivateAndUserId(Long id);
    Iterable<Wallet>findAllByNameContaining(String name);
}
