package com.example.VirtualAssetManager.service;

import com.example.VirtualAssetManager.model.User;
import com.example.VirtualAssetManager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    // 테스트할 UserService 클래스 주입
    @InjectMocks
    private UserService userService;

    // UserRepository를 Mock 객체로 설정하여 데이터베이스와 분리
    @Mock
    private UserRepository userRepository;

    // getUserById() 메서드 테스트
    @Test
    public void testGetUserById() {
        // 가상의 사용자 데이터 생성 및 설정
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        // findById(1L) 호출 시 가상의 사용자 데이터를 반환하도록 설정
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Service 메서드 호출 및 결과 검증
        Optional<User> result = userService.getUserById(1L);
        assertTrue(result.isPresent());  // 결과가 존재하는지 확인
        assertEquals("john_doe", result.get().getUsername());  // username 일치 여부 확인
        assertEquals("john@example.com", result.get().getEmail());  // email 일치 여부 확인
    }

    // createUser() 메서드 테스트
    @Test
    public void testCreateUser() {
        // 가상의 사용자 데이터 생성
        User user = new User();
        user.setUsername("jane_doe");
        user.setEmail("jane@example.com");

        // save() 호출 시 가상의 사용자 데이터를 반환하도록 설정
        when(userRepository.save(user)).thenReturn(user);

        // Service 메서드 호출 및 결과 검증
        User result = userService.createUser(user);
        assertEquals("jane_doe", result.getUsername());  // username 일치 여부 확인
        assertEquals("jane@example.com", result.getEmail());  // email 일치 여부 확인
    }
}