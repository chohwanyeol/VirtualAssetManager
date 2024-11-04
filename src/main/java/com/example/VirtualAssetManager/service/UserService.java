package com.example.VirtualAssetManager.service;

import com.example.VirtualAssetManager.model.User;
import com.example.VirtualAssetManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 사용자 ID로 조회
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // 새로운 사용자 추가
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 정보 업데이트
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    // 필드 업데이트
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setEmail(updatedUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found")); // 사용자 없을 시 예외 발생
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
