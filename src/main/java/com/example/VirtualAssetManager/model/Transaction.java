package com.example.VirtualAssetManager.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions") // 테이블 이름을 "transactions"로 지정
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 생성
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double amount; // 거래 금액

    @Column(nullable = false)
    private LocalDateTime transactionDate; // 거래 발생 일시

    @ManyToOne // 여러 거래가 하나의 계좌와 연결 (다대일 관계)
    @JoinColumn(name = "account_id") // 외래 키 컬럼 이름을 "account_id"로 지정
    private Account account; // 거래가 발생한 계좌
}
