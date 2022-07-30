package com.example.airbnb.repository;

import com.example.airbnb.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

@Modifying
    @Query(value = "select * from status = 1 and user_id = :id", nativeQuery = true)
    Iterable<Wallet> findAllByStatusPublicAndUser_Id(@Param("id") Long id);

    @Modifying
    @Query(value = "select * from status = 2 and user_id = :id", nativeQuery = true)
    Iterable<Wallet> findAllByStatusPrivateAndUser_Id(Long id);

    Iterable<Wallet> findAllByNameContaining(String name);
}
