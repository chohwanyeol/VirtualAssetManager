package com.example.VirtualAssetManager.repository;


import com.example.VirtualAssetManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
