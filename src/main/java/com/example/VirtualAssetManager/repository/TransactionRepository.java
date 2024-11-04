package com.example.VirtualAssetManager.repository;

import com.example.VirtualAssetManager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
