package com.example.VirtualAssetManager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber;          //계좌번호

    private Double balance;               //잔액

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;                 //계좌의 고객
}
