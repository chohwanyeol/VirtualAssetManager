package com.example.VirtualAssetManager.service;


import com.example.VirtualAssetManager.model.Transaction;
import com.example.VirtualAssetManager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    // 모든 거래 조회
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 거래 ID로 조회
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // 새로운 거래 추가
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // 거래 정보 업데이트
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setAmount(updatedTransaction.getAmount());
                    transaction.setTransactionDate(updatedTransaction.getTransactionDate());
                    transaction.setAccount(updatedTransaction.getAccount());
                    return transactionRepository.save(transaction);
                })
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    // 거래 삭제
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
