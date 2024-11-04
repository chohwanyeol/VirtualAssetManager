package com.example.VirtualAssetManager.repository;

import com.example.VirtualAssetManager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
