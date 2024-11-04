package com.example.VirtualAssetManager.service;

import com.example.VirtualAssetManager.model.Account;
import com.example.VirtualAssetManager.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    // 모든 계좌 조회
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // 계좌 ID로 조회
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // 새로운 계좌 추가
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // 계좌 정보 업데이트
    public Account updateAccount(Long id, Account updatedAccount) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setAccountNumber(updatedAccount.getAccountNumber());
                    account.setBalance(updatedAccount.getBalance());
                    account.setUser(updatedAccount.getUser());
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // 계좌 삭제
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
